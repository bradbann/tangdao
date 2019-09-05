package org.tangdao.modules.paas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.paas.config.PaasRedisConstant;
import org.tangdao.modules.paas.mapper.HostWhiteListMapper;
import org.tangdao.modules.paas.model.domain.HostWhiteList;
import org.tangdao.modules.paas.service.IHostWhiteListService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HostWhiteListServiceImpl extends CrudServiceImpl<HostWhiteListMapper, HostWhiteList> implements IHostWhiteListService {
	
	@Resource
    private StringRedisTemplate stringRedisTemplate;
	
	private String getKey(String userCode) {
        return String.format("%s:%d", PaasRedisConstant.RED_USER_WHITE_HOST, userCode);
    }
	
	@Override
    public int updateByPrimaryKey(HostWhiteList record) {
		int result = this.count(Wrappers.<HostWhiteList>lambdaQuery().eq(HostWhiteList::getStatus, HostWhiteList.STATUS_NORMAL)
				.eq(HostWhiteList::getUserCode, record).eq(HostWhiteList::getIp, record.getIp()));
        if (result == 0) {
            pushToRedis(record.getUserCode(), record.getIp());
            return this.getBaseMapper().updateById(record);
        } else {
            return 2;
        }
    }

	@Override
	public boolean ipAllowedPass(String userCode, String ip) {
//      try {
//      Set<String> set = stringRedisTemplate.opsForSet().members(getKey(userId));
//      if(CollectionUtils.isNotEmpty(set) && set.contains(ip)) {
//          return true;
//      }
//
//  } catch (Exception e) {
//      logger.warn("REDIS 操作用户服务器IP配置失败", e);
//  }
//
//   int result = hostWhiteListMapper.selectByUserIdAndIp(userId, ip);
//   if(result == 0) {
//       logger.warn("用户IP 未报备，及时备案");
//   }

		return true;
	}
	
	/**
     * 添加至REDIS
     * 
     * @param userSmsConfig
     */
    private void pushToRedis(String userCode, String ip) {
        try {
            stringRedisTemplate.opsForSet().add(getKey(userCode), ip);
        } catch (Exception e) {
            log.warn("REDIS 操作用户服务器IP配置失败", e);
        }
    }

	@Override
	public boolean reloadToRedis() {
		List<HostWhiteList> list = this.select();
        if (CollectionUtils.isEmpty(list)) {
            log.warn("服务器IP报备为空");
            return true;
        }

        List<Object> con = stringRedisTemplate.execute((connection) -> {
            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.openPipeline();
            for (HostWhiteList hwl : list) {
                byte[] key = serializer.serialize(getKey(hwl.getUserCode()));
                connection.sAdd(key, serializer.serialize(JSON.toJSONString(hwl)));
            }

            return connection.closePipeline();

        }, false, true);

        return CollectionUtils.isNotEmpty(con);
	}
	
    public Map<String, Object> batchInsert(HostWhiteList record) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int count = 0;
        boolean is_successs = true;
        // 重复标记
        boolean is_flag = false;
        String context = "";
        if (StringUtils.isEmpty(record.getIp())) {
            resultMap.put("result_code", "-2");
            resultMap.put("result_msg", "参数不能为空！");
            return resultMap;
        }
        try {
            String str[] = record.getIp().split("\n");
            for (int i = 0; i < str.length; i++) {
                count++;
                record.setIp(str[i]);
                record.setStatus(HostWhiteList.STATUS_NORMAL);
                // 标记重复提示
                boolean codeFlag = false;
                // 去空格验证是否为空
                if (!StringUtils.isEmpty(str[i].trim())) {
                    // 判断是否重复 重复则不保存
                	int exisCount = this.count(Wrappers.<HostWhiteList>lambdaQuery().eq(HostWhiteList::getStatus, HostWhiteList.STATUS_NORMAL)
            				.eq(HostWhiteList::getUserCode, record).eq(HostWhiteList::getIp, record.getIp()));
                    if (exisCount == 0) {
                        // flag = hostWhiteListMapper.batchInsert(record) > 0;
                    } else {
                        is_flag = true;
                        codeFlag = true;
                        is_successs = false;
                    }
                }
                if (codeFlag) {
                    context += "重复行：" + count + ";ip地址：" + str[i] + ";";
                }
            }
            // 保存
            if (!is_flag) {
                for (int i = 0; i < str.length; i++) {
                    count++;
                    record.setIp(str[i]);
                    record.setStatus(HostWhiteList.STATUS_NORMAL);
                    // 标记重复提示
                    // 去空格验证是否为空
                    if (!StringUtils.isEmpty(str[i].trim())) {
                        pushToRedis(record.getUserCode(), record.getIp());
                        this.save(record);
                    }
                }
            }
            if (is_successs) {
                resultMap.put("result_code", "success");
                resultMap.put("result_msg", "成功！");
            } else {
                resultMap.put("result_code", "fail");
                resultMap.put("result_msg", context);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result_code", "exption");
            resultMap.put("result_msg", "异常" + e.getMessage());
        }
        return resultMap;
    }

}
