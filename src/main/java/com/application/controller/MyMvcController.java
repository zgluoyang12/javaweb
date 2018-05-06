package com.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/mvc")
public class MyMvcController {
	
	
	@RequestMapping
	public String goList(HttpServletRequest requst,Model model){
		model.addAttribute("test", "Helllo baby!");
		return "index";
	}
	
	@RequestMapping("/success")
	public String success(HttpServletRequest requst,Model model){
		model.addAttribute("test", "login success!");
		return "success";
	}
}
