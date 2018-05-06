package com.application.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class AuthenFilter extends AccessControlFilter {
	
	private String unauthorizedUrl = "/unauthorized.jsp";
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request,response);
//		if(null == subject.getPrincipal()){
//			return false;
//		}else{
//			return false;
//		}
		return false;
		
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request,response);
		WebUtils.issueRedirect(request, response, unauthorizedUrl);  
		return false;
	}

}
