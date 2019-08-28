package org.tangdao.modules.sys.web;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.suports.BaseEntity;
import org.tangdao.common.utils.DateUtils;
import org.tangdao.common.utils.EncodeUtils;

/**
 * @ClassName: AdviceController.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ruyang
 * @date 2019年3月1日 上午9:46:17
 * 
 */
@ControllerAdvice
public class AdviceController {
	
	@ExceptionHandler({ BindException.class, ConstraintViolationException.class, ValidationException.class })
	protected String exceptionHandlerTo400Page() {
		return "error/400";
	}

	@ExceptionHandler({ AuthenticationException.class, AccessDeniedException.class})
	protected String exceptionHandlerTo403Page() {
		return "error/403";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder, HttpServletRequest request) {
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				this.setValue(EncodeUtils.xssFilter(text));
			}
		});
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				this.setValue(DateUtils.parseDate(text));
			}
		});
		if (binder.getTarget() instanceof BaseEntity) {
			BaseEntity<?> baseEntity = (BaseEntity<?>) binder.getTarget();
			request.setAttribute(BaseController.WEB_DATA_BINDER_SOURCE, baseEntity.clone());
			request.setAttribute(BaseController.WEB_DATA_BINDER_TARGET, baseEntity);
		}
	}
}
