package com.application.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Map<String ,Object> validUsername(String username){
		String sql = " select * from ayuser where name ='" + username + "'";
		List<Map<String ,Object>> list = jdbcTemplate.queryForList(sql);
		if(null != list && list.size()> 0 ){
			return list.get(0);
		}
		return null;
	}
}
