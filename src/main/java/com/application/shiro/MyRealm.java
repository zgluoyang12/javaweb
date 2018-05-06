package com.application.shiro;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.application.service.UserService;

public class MyRealm extends AuthorizingRealm {
	
	@Resource
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}
	
	//��¼��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();//��¼�û���
		Map<String,Object> user = userService.validUsername(username);
	    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
                user.get("name"), //�û���  
                user.get("passwd"), //����  
                getName()  //realm name  
        );  
		return authenticationInfo;
	}

}
