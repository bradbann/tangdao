package org.tangdao.common.suports;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.tangdao.common.utils.ServletUtils;

public abstract class BaseController {
	
	protected static final String FORWARD = "forward:";
	protected static final String REDIRECT = "redirect:";
	
	public static final String WEB_DATA_BINDER_SOURCE = WebDataBinder.class.getName()+".SOURCE"; 
	public static final String WEB_DATA_BINDER_TARGET = WebDataBinder.class.getName()+".TARGET"; 
	
	protected Object getWebDataBinderSource(HttpServletRequest request) {	
		return request.getAttribute(WEB_DATA_BINDER_SOURCE);	
	}	
		
	protected Object getWebDataBinderTarget(HttpServletRequest request) {	
		return request.getAttribute(WEB_DATA_BINDER_TARGET);	
	} 
	
	protected HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	
	protected String renderResult(String result, String message, Object data) {	
		return ServletUtils.renderResult(result, message, data);	
	}
	
	protected String renderResult(String result, String message) {	
		return this.renderResult(result, message, null);	
	}
	
	protected String renderResult(HttpServletResponse response, String result, String message, Object data) {	
		return ServletUtils.renderResult(response, result, message, data);	
	} 
	
	protected String renderResult(String result, StringBuilder message) {	
		return this.renderResult(result, message != null ? message.toString() : "");	
	}	
	
	protected String renderResult(HttpServletResponse response, String result, String message) {	
	      return ServletUtils.renderResult(response, result, message, null);	
	} 

	protected ModelAndView view(String view) {
		ModelAndView modelAndView = new ModelAndView(view);
		return modelAndView;
	}

	protected ModelAndView view(String view, String name, Object model) {
		ModelAndView modelAndView = new ModelAndView(view);
		modelAndView.addObject(name, model);
		return modelAndView;
	}
}
