package org.tangdao.modules.paas.model.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.modules.exchanger.model.dto.ParseParamDto;
import org.tangdao.modules.exchanger.model.dto.RequestParamDto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 通道模板内容Entity
 * 
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("paas_passage_template_detail")
public class PassageTemplateDetail extends DataEntity<PassageTemplateDetail> {

	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;

	private String templateId; // template_id
	private String callType; // 1-发送 2-状态回执推送 3-状态回执自取 4-上行推送 5-上行自取
	private String url; // url
	private String params; // 参数
	private String position; // 具体值的位置，json存储
	private String resultFormat; // 结果格式
	private String successCode; // 成功码标记

	public PassageTemplateDetail() {
		super();
	}

	public PassageTemplateDetail(String id) {
		super(id);
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

	public List<RequestParamDto> getRequestParams() {
		List<RequestParamDto> list = new ArrayList<RequestParamDto>();
		if (StringUtils.isNotBlank(params)) {
			list = JsonMapper.fromJson(params, RequestParamDto.class);
		}
		return list;
	}

	public List<ParseParamDto> getParseParams() {
		List<ParseParamDto> list = new ArrayList<ParseParamDto>();
		if (StringUtils.isNotBlank(position)) {
			list = JsonMapper.fromJson(position, ParseParamDto.class);
		}
		return list;
	}

}