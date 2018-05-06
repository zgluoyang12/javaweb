package com.application.system.admin.service;


import com.application.system.admin.entity.SysUser;

public interface SysUserService {
	SysUser getUserByUserName(String username);
}
