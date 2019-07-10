package org.tangdao.common.beetl;

import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.spring.BeetlSpringView;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.tangdao.common.utils.DateUtils;

public class BeetlViewResolver extends BeetlSpringViewResolver {

	public BeetlViewResolver() {	
        this.setViewClass(BeetlView.class);	
	}
	
    protected Class<BeetlSpringView> requiredViewClass() {	
        return BeetlSpringView.class;	
    }	
	
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {	
        BeetlSpringView beetlView = (BeetlSpringView)super.buildView(viewName);	
        beetlView.setGroupTemplate(this.getConfig().getGroupTemplate());	
        String suffix = this.getSuffix();	
        if (suffix != null && suffix.length() != 0 && viewName.contains("#")) {	
            String[] viewNames = viewName.split("#");	
            if (viewNames.length > 2) {	
                throw new Exception(new StringBuilder().insert(0, "视图名称有误：").append(viewName).toString());	
            }	
            beetlView.setUrl(new StringBuilder().insert(0, this.getPrefix()).append(viewNames[0]).append(this.getSuffix()).append("#").append(viewNames[1]).toString());	
        }	
        return beetlView;	
    }

	@Override
	public void afterPropertiesSet() throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException,SecurityException, NoSuchFieldException {
		super.afterPropertiesSet();
		
        String ctxPath = this.getServletContext().getContextPath();	
        String serverStartDate = DateUtils.formatDate(DateUtils.getServerStartDate(), (String)"MMddHHmm"); 
        
        Map<String, Object> sharedVars = this.getConfig().getGroupTemplate().getSharedVars();
        sharedVars.put("ctxStatic", new StringBuilder().insert(0, ctxPath).append("/static").toString());	
        sharedVars.put("ctxPath", ctxPath);	
        sharedVars.put("_version", new StringBuilder().insert(0, "1.0.0").append("-").append(serverStartDate).toString());	
        
        GroupTemplate groupTemplate = this.getConfig().getGroupTemplate();
        groupTemplate.setSharedVars(sharedVars); 
	} 
}
