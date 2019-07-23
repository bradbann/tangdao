package org.tangdao.common.beetl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.spring.BeetlSpringView;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

/** 
 * @ClassName: BeetlView.java 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author ruyang
 * @date 2019年2月26日 上午9:53:26
 *  
 */
public class BeetlView extends BeetlSpringView {

	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException {	
        model.put("ctx", request.getContextPath());	
        super.renderMergedTemplateModel(model, request, response);	
	} 
}
