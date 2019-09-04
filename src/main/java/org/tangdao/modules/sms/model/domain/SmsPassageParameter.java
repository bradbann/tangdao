package org.tangdao.modules.sms.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.exchanger.model.dto.ParseParamDto;
import org.tangdao.modules.exchanger.model.dto.RequestParamDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsPassageParameter implements Serializable {

	private static final long serialVersionUID = 7911727707980440841L;

	private String id;

	private String passageId;

	private String protocol;

	private String callType;

	private String url;

	private String paramsDefinition;

	private String params;

	private String resultFormat;

	private String successCode;

	private String position;

	private Date createTime;

	// 通道代码（伪列）
	private String passageCode;
	// 限流速度
	private Integer packetsSize;
	// 第一条计费字数（针对一客一签有意义）
	private Integer feeByWords;
	// 通道方短信模板ID（提前报备）
	private String smsTemplateId;
	// 变量参数，专指用于类似点对点短信数组/或者JSON变量传递 add by zhengying 20170825
	private String[] variableParamNames;
	
	private String[] variableParamValues;
	
	
	// 最大连接数
	private Integer connectionSize;
	// 读取数据流超时时间（针对已经和目标服务器建立连接，对方处理时间过慢，相应超时时间）
	private Integer readTimeout;


	public void setProtocol(String protocol) {
		this.protocol = protocol == null ? null : protocol.trim();
	}


	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}


	public void setParamsDefinition(String paramsDefinition) {
		this.paramsDefinition = paramsDefinition == null ? null : paramsDefinition.trim();
	}

	public void setParams(String params) {
		this.params = params == null ? null : params.trim();
	}

	public void setResultFormat(String resultFormat) {
		this.resultFormat = resultFormat == null ? null : resultFormat.trim();
	}

	public void setSuccessCode(String successCode) {
		this.successCode = successCode == null ? null : successCode.trim();
	}

	public List<RequestParamDto> getRequestParams() {
		List<RequestParamDto> list = ListUtils.newArrayList();
		if (StringUtils.isNotBlank(paramsDefinition)) {
			list = JsonMapper.fromJson(paramsDefinition, RequestParamDto.class);
		}
		return list;
	}

	public List<ParseParamDto> getParseParams() {
		List<ParseParamDto> list =  ListUtils.newArrayList();
		if (StringUtils.isNotBlank(position)) {
			Map<String, String> map = JsonMapper.fromJson(position, Map.class);
			for (Map.Entry<String, String> m : map.entrySet()) {
				ParseParamDto dto = new ParseParamDto();
				dto.setPosition(m.getValue());
				dto.setParseName(m.getKey());
				dto.setShowName("");
			}
		}
		return list;
	}

	public String getShowResultFormat() {
		if (StringUtils.isNotBlank(resultFormat)) {
			resultFormat = resultFormat.replaceAll("\"", "&quot;");
			resultFormat = resultFormat.replaceAll("'", "&#39;");
			resultFormat = resultFormat.replaceAll("<", "&lt;");
			resultFormat = resultFormat.replaceAll(">", "&gt;");
			return resultFormat;
		}
		return null;
	}


	public String[] getVariableParamNames() {
		return variableParamNames;
	}

	public void setVariableParamNames(String[] variableParamNames) {
		this.variableParamNames = variableParamNames;
	}

	public String[] getVariableParamValues() {
		return variableParamValues;
	}

	public void setVariableParamValues(String[] variableParamValues) {
		this.variableParamValues = variableParamValues;
	}

}
