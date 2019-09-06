package org.tangdao.modules.sms.model.domain;

import java.util.List;
import java.util.Map;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.exchanger.model.dto.ParseParamDto;
import org.tangdao.modules.exchanger.model.dto.RequestParamDto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 通道消息模板参数Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_passage_parameter")
public class SmsPassageParameter extends DataEntity<SmsPassageParameter> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String passageId;		// 通道ID
	private String protocol;		// 协议类型
	private String callType;		// 1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取 6-余额查询
	private String url;		// url
	private String paramsDefinition;		// 定义，直接取模板里的值
	private String params;		// 具体的参数值，取模板中的key作为KEY，如{＂username＂:＂test＂, ＂password＂:＂123456＂}
	private String resultFormat;		// result_format
	private String successCode;		// success_code
	private String position;		// 返回值的具体位置，json存储
	
	public SmsPassageParameter() {
		super();
	}

	public SmsPassageParameter(String id){
		super(id);
	}
	
	// 通道代码（伪列）
	@TableField(exist = false)
	private String passageCode;
	// 限流速度
	@TableField(exist = false)
	private Integer packetsSize;
	// 第一条计费字数（针对一客一签有意义）
	@TableField(exist = false)
	private Integer feeByWords;
	// 通道方短信模板ID（提前报备）
	@TableField(exist = false)
	private String smsTemplateId;
	// 变量参数，专指用于类似点对点短信数组/或者JSON变量传递 add by zhengying 20170825
	@TableField(exist = false)
	private String[] variableParamNames;
	
	@TableField(exist = false)
	private String[] variableParamValues;
	
	
	// 最大连接数
	@TableField(exist = false)
	private Integer connectionSize;
	// 读取数据流超时时间（针对已经和目标服务器建立连接，对方处理时间过慢，相应超时时间）
	@TableField(exist = false)
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