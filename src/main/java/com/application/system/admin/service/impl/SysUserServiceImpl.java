package com.application.system.admin.service.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import com.application.system.admin.entity.SysUser;
import com.application.system.admin.service.SysUserService;

@Service(value="sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public SysUser getUserByUserName(String username) {
		String sql = " select * from sys_user where username=?";
		SysUser sysUser =  null;
		try {
			sysUser = jdbcTemplate.queryForObject(sql,new Object[]{username}, new BeanPropertyRowMapper<SysUser>(SysUser.class));
		}catch (Exception e){
			
		}
		return sysUser;
	}

}
