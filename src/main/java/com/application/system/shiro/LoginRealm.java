package com.application.system.shiro;

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

public class LoginRealm extends AuthorizingRealm {
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}
	//登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		LocalUsernamePasswdToken localToken =  (LocalUsernamePasswdToken)token;
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
				localToken.getSysUser().getUsername(), //密码 
				localToken.getSysUser().getPassword(), //身份
                getName()  //realm name  
        );  
		return authenticationInfo;
	}

}
