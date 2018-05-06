package com.application.system.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.common.GlobalConstants;
import com.application.common.ResultMessage;
import com.application.system.admin.entity.SysUser;
import com.application.system.admin.service.SysUserService;
import com.application.system.shiro.LocalUsernamePasswdToken;

@Controller
@RequestMapping("/system/admin")
public class LoginController {
	
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping
	public String goLogin(HttpServletRequest requst,Model model){
		return "/system/admin/login";
	}
	
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultMessage login(HttpServletRequest request,String username ,String password,String validcoed){
		ResultMessage message = new ResultMessage();
		SysUser sysUser = sysUserService.getUserByUserName(username);
		HttpSession session = request.getSession();
		if(null== sysUser){
			message.setSuccess(false);
			message.setMsg("用户不存在");
			return message;
		}
		session.removeAttribute(GlobalConstants.APP_USER);
		Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(new LocalUsernamePasswdToken(username, password, sysUser));
			session.setAttribute(GlobalConstants.APP_USER, sysUser);
			message.setSuccess(true);
		}catch(IncorrectCredentialsException  e){
			message.setSuccess(false);
			message.setMsg("用户名或密码错误");
			e.printStackTrace();
		}
		return message;
	}
}
