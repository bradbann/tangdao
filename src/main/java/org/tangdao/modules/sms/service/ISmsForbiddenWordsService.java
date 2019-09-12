package org.tangdao.modules.sms.service;

import java.util.List;
import java.util.Set;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsForbiddenWords;

/**
 * 告警敏感词Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsForbiddenWordsService extends ICrudService<SmsForbiddenWords> {
	
	/**
     * TODO 短信内容是否包含敏感字
     * 
     * @param content
     * @return
     */
    boolean isContainsForbiddenWords(String content);

    /**
     * TODO 短信内容是否包含敏感字
     * 
     * @param content 短信内容
     * @param safeWords 报备白名单词汇
     * @return
     */
    boolean isContainsForbiddenWords(String content, Set<String> safeWords);

    /**
     * TODO 根据内容查找具体的敏感词汇
     * 
     * @param content
     * @return
     */
    Set<String> filterForbiddenWords(String content);

    /**
     * TODO 过滤敏感词（去除报备白名单词汇）
     * 
     * @param content
     * @param safeWords
     * @return
     */
    Set<String> filterForbiddenWords(String content, Set<String> safeWords);

    /**
     * TODO 获取所有的敏感词库
     * 
     * @return
     */
    List<String> findForbiddenWordsLibrary();

    /**
     * TODO 新增敏感词汇
     * 
     * @param words
     * @return
     */
    boolean saveForbiddenWords(SmsForbiddenWords words);

    /**
     * TODO 修改敏感词汇
     * 
     * @param words
     * @return
     */
    boolean update(SmsForbiddenWords words);

    /**
     * TODO 重新加载数据库中的敏感词至REDIS中
     * 
     * @return
     */
    boolean reloadRedisForbiddenWords();

    /**
     * TODO 根据ID删除敏感词信息
     * 
     * @param id
     * @return
     */
    boolean deleteWord(int id);

    /**
     * TODO 获取所有的敏感词标签库
     * 
     * @return
     */
    String[] findWordsLabelLibrary();

    /**
     * TODO 根据敏感词查询归属的标签名称（多个词汇可能存在多种标签名称）
     * 
     * @param words
     * @return
     */
    List<SmsForbiddenWords> getLabelByWords(String words);

    /**
     * TODO 刷新本地敏感词库（JVM）
     * 
     * @param isWildcards 是否为通配敏感词
     * @param isSaveMode 是否新增模式
     * @return
     */
    boolean freshLocalForbiddenWords(boolean isWildcards, boolean isSaveMode);
}