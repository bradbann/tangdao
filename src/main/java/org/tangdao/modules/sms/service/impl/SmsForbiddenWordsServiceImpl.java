package org.tangdao.modules.sms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.config.redis.constant.SmsRedisConstant;
import org.tangdao.modules.paas.config.SettingsContext;
import org.tangdao.modules.sms.filter.SensitiveWordFilter;
import org.tangdao.modules.sms.mapper.SmsForbiddenWordsMapper;
import org.tangdao.modules.sms.model.domain.SmsForbiddenWords;
import org.tangdao.modules.sms.service.ISmsForbiddenWordsService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;

/**
 * 告警敏感词ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class SmsForbiddenWordsServiceImpl extends CrudServiceImpl<SmsForbiddenWordsMapper, SmsForbiddenWords> implements ISmsForbiddenWordsService{

	@Resource
	private StringRedisTemplate  stringRedisTemplate;
	
	private final Logger         logger              = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean isContainsForbiddenWords(String content) {
		if (StringUtils.isEmpty(content)) {
            return false;
        }

        try {
            return SensitiveWordFilter.isContains(content);
        } catch (Exception e) {
            logger.error("解析是否包含敏感词失败", e);
            return false;
        }
	}

	@Override
	public boolean isContainsForbiddenWords(String content, Set<String> safeWords) {
		Set<String> words = filterForbiddenWords(content);
        if (ListUtils.isEmpty(words)) {
            return false;
        }

        if (ListUtils.isEmpty(safeWords)) {
            return true;
        }

        // 如果报备的敏感词包含本次检索出来的敏感词，则认为本次无敏感词
        return !safeWords.containsAll(words);
	}

	@Override
	public Set<String> filterForbiddenWords(String content) {
		if (StringUtils.isEmpty(content)) {
            return null;
        }

		// 过滤内容敏感词
		Set<String> sensitiveWords = SensitiveWordFilter.doFilter(content);
		
		// 过滤通配敏感词
		Set<String> wildcardsWords = SensitiveWordFilter.pickupWildcardsWords(content);
		if(ListUtils.isEmpty(sensitiveWords)) {
		    if(ListUtils.isEmpty(wildcardsWords)) {
		        return null;
		    }
		    
		    return wildcardsWords;
		} else {
		    if(ListUtils.isEmpty(wildcardsWords)) {
	            return sensitiveWords;
	        }
	        
	        sensitiveWords.addAll(wildcardsWords);
	        return sensitiveWords;
		}
	}

	@Override
	public Set<String> filterForbiddenWords(String content, Set<String> safeWords) {
		Set<String> set = filterForbiddenWords(content);
        if (ListUtils.isEmpty(set)) {
            return null;
        }

        set.removeAll(safeWords);

        return set;
	}

	@Override
	public List<String> findForbiddenWordsLibrary() {
		try {
            Set<String> set = stringRedisTemplate.opsForSet().members(SmsRedisConstant.RED_FORBIDDEN_WORDS);

            if (ListUtils.isNotEmpty(set)) {
                return new ArrayList<>(set);
            }

        } catch (Exception e) {
            logger.warn("Redis敏感词加载失败.", e);
        }

        List<String> list = this.getBaseMapper().selectAllWords();
        try {
            stringRedisTemplate.opsForSet().add(SmsRedisConstant.RED_FORBIDDEN_WORDS, list.toArray(new String[] {}));
        } catch (Exception e) {
            logger.warn("Redis敏感词同步失败.", e);
        }

        return list;
	}

	@Override
	public boolean saveForbiddenWords(SmsForbiddenWords words) {
		if (words == null || StringUtils.isBlank(words.getWord()) || StringUtils.isBlank(words.getLabel())) {
            return false;
        }

        try {
            stringRedisTemplate.opsForSet().add(SmsRedisConstant.RED_FORBIDDEN_WORDS, words.getWord());
        } catch (Exception e) {
            logger.warn("Redis敏感词同步失败.", e);
        }

        // 暂时均默认为1级
        words.setLevel(1);
        boolean result = this.save(words);
        if (!result) {
            return false;
        }
        
        try {
            // 是否为通配敏感词
            if(SensitiveWordFilter.isWildcardsWords(words.getWord())) {
                SensitiveWordFilter.addWildcarsWords(words.getWord());
            } else {
                // 重新初始化明确敏感词词库(JVM)
                SensitiveWordFilter.setSensitiveWord(new ArrayList<>(findForbiddenWordsLibrary()));
            }
            return true;
        } catch (Exception e) {
            logger.error("保存敏感词["+JSON.toJSONString(words)+"]失败", e);
            return false;
        }
	}

	@Override
	public boolean update(SmsForbiddenWords words) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reloadRedisForbiddenWords() {
		List<String> words = this.getBaseMapper().selectAllWords();
        if (ListUtils.isEmpty(words)) {
            logger.info("数据库未检索到敏感词，放弃填充REDIS");
            return true;
        }
        try {
            // 加载精确敏感词库
            SensitiveWordFilter.setSensitiveWord(words);
            
            // 加载通配敏感词库
            SensitiveWordFilter.loadWildcarsWords(words);

            stringRedisTemplate.delete(SmsRedisConstant.RED_FORBIDDEN_WORDS);
            stringRedisTemplate.opsForSet().add(SmsRedisConstant.RED_FORBIDDEN_WORDS, words.toArray(new String[] {}));
            return true;
        } catch (Exception e) {
            logger.warn("REDIS重载敏感词数据失败", e);
            return false;
        }
	}

	@Override
	public boolean deleteWord(int id) {
		try {
            SmsForbiddenWords words = this.get(id);
            stringRedisTemplate.opsForSet().remove(SmsRedisConstant.RED_FORBIDDEN_WORDS, words.getWord());

            // 是否为通配敏感词
            if(SensitiveWordFilter.isWildcardsWords(words.getWord())) {
                SensitiveWordFilter.removeWildcarsWords(words.getWord());
            } else {
                // 重新初始化明确敏感词词库(JVM)
                SensitiveWordFilter.setSensitiveWord(new ArrayList<>(findForbiddenWordsLibrary()));
            }

        } catch (Exception e) {
            logger.warn("Redis 删除敏感词信息失败, id : {}", id, e);
            return false;
        }
        return this.deleteById(id);
	}

	@Override
	public String[] findWordsLabelLibrary() {
//		SystemConfig systemConfig = systemConfigService.findByTypeAndKey(SystemConfigType.WORDS_LIBRARY.name(), WordsLibrary.FORBIDDEN_LABEL.name());
//		if (systemConfig == null || StringUtils.isEmpty(systemConfig.getAttrValue())) {
//			logger.warn("敏感词标签库未配置，请及时配置");
//			return null;
//		}
//		
//		return systemConfig.getAttrValue().split(SettingsContext.MULTI_VALUE_SEPERATOR);
		return "".split(SettingsContext.MULTI_VALUE_SEPERATOR);
	}

	@Override
	public List<SmsForbiddenWords> getLabelByWords(String words) {
		if (StringUtils.isEmpty(words)) {
            return null;
        }

        String[] wordsArray = words.split(",");
        SmsForbiddenWords forbiddenWords = null;

        List<SmsForbiddenWords> list = new ArrayList<>();
        if (wordsArray.length == 1) {
            // 如果只有一个词汇，并且为空则直接返回空
            if (StringUtils.isBlank(wordsArray[0])) {
                return null;
            }
            forbiddenWords = this.getOne(Wrappers.<SmsForbiddenWords>lambdaQuery().eq(SmsForbiddenWords::getWord, wordsArray[0]));
            if (forbiddenWords == null) {
                return null;
            }

            list.add(forbiddenWords);
            return list;
        }
        List<SmsForbiddenWords> wordLib = this.select(Wrappers.<SmsForbiddenWords>lambdaQuery().in(SmsForbiddenWords::getWord, Lists.newArrayList(wordsArray)));
        if (ListUtils.isEmpty(wordLib)) {
            return null;
        }

        Map<String, SmsForbiddenWords> map = new HashMap<>();
        // 如果存在多个标签，需要判断是否是同一个，如果为同一个标签则只返回一个即可
        for (SmsForbiddenWords word : wordLib) {
            if (!map.containsKey(word.getLabel())) {
                map.put(word.getLabel(), word);
                continue;
            }

            SmsForbiddenWords originWord = map.get(word.getLabel());
            originWord.setWord(originWord.getWord() + "," + word.getWord());

            map.put(word.getLabel(), originWord);
        }

        for (String label : map.keySet()) {
            list.add(map.get(label));
        }

        return list;
	}

	@Override
	public boolean freshLocalForbiddenWords(boolean isWildcards, boolean isSaveMode) {
		try {
            // 重新初始化明确敏感词词库(JVM)
            SensitiveWordFilter.setSensitiveWord(new ArrayList<>(findForbiddenWordsLibrary()));
            return true;
        } catch (Exception e) {
            logger.warn("REDIS刷新敏感词数据失败", e);
            return false;
        }
	}
		
}