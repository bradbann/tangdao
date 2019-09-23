package org.tangdao.modules.exchanger.template.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangdao.common.utils.DateUtils;
import org.tangdao.modules.exchanger.config.CommonContext.CMCP;
import org.tangdao.modules.exchanger.config.ParameterFilterContext;
import org.tangdao.modules.sms.config.PassageContext.DeliverStatus;
import org.tangdao.modules.sms.model.domain.SmsMtMessageDeliver;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * 
  * TODO 通道状态报告回执公共解析
  *
  * @author ruyang
  * @version V1.0.0   
  * @date 2016年12月12日 上午1:14:08
 */
public class DeliverTemplateHandler {

	private static Logger logger = LoggerFactory.getLogger(DeliverTemplateHandler.class);

	public static List<SmsMtMessageDeliver> translate(SmsPassageAccess access, JSONObject report) {

		List<SmsMtMessageDeliver> list = new ArrayList<>();
		try {
//			JSONObject paramDefination = JSON.parseObject(access.getParams());
//			if (!paramDefination.keySet().contains(TPosition.MSGID_NODE_NAME)
//					|| !paramDefination.keySet().contains(TPosition.MOBILE_NODE_NAME)
//					|| !paramDefination.keySet().contains(TPosition.STATUS_CODE_NODE_NAME)) {
//
//				logger.error("数据节点配置有误 : {}", paramDefination.toJSONString());
//				throw new RuntimeException("数据节点配置异常");
//			}

			String rport = report.getString(ParameterFilterContext.PARAMETER_NAME_IN_STREAM);
			if (StringUtils.isEmpty(rport)) {
                return null;
            }
			List<JSONObject> array = JSON.parseObject(rport, new TypeReference<List<JSONObject>>(){});
			if(CollectionUtils.isEmpty(array)) {
                return null;
            }
			
			SmsMtMessageDeliver response;
			for(JSONObject prameterReport : array) {
				
				// 消息ID
				String msgId = prameterReport.getString("Msg_Id");
				// 手机号码
				String mobile = prameterReport.getString("Mobile");
				// 状态码
				String statusCode = prameterReport.getString("Status");
				
				response = new SmsMtMessageDeliver();
				
				response.setMsgId(msgId);
				response.setMobile(mobile);
				response.setCmcp(CMCP.local(mobile).getCode());
				response.setStatusCode(statusCode);
				response.setStatus(
						(StringUtils.isNotEmpty(statusCode) && statusCode.equalsIgnoreCase(access.getSuccessCode())
								? DeliverStatus.SUCCESS.getValue() : DeliverStatus.FAILED.getValue()));
				response.setDeliverTime(DateUtils.getDate());
				response.setCreateTime(new Date());
				response.setRemarks(prameterReport.toJSONString());

				list.add(response);
			}

			return list;
		} catch (Exception e) {
			logger.error("解析回执数据失败", e);
			throw new RuntimeException("解析回执数据失败");
		}
	}

}
