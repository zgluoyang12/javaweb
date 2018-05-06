package com.application.system.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.application.system.admin.entity.SysUser;

public class LocalUsernamePasswdToken  extends UsernamePasswordToken{
	
	private SysUser sysUser;
	
	public LocalUsernamePasswdToken(String username,String password,SysUser user){
		super(username,password);
		this.sysUser = user;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
}
