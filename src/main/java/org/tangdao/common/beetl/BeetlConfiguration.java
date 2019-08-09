package org.tangdao.common.beetl;

import org.beetl.ext.spring.AccessExpressionIfFunction;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

	@Override
	protected void initOther() {
		groupTemplate.registerFunction("expIf", new AccessExpressionIfFunction());
	}
}
