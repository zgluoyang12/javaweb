package com.application.system.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/system/admin/index")
public class IndexController {
	
	
	@RequestMapping
	public String goIndex(){
		return "/system/admin/admin_main";
	}
	
}
