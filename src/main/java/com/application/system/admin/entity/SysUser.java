package com.application.system.admin.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_user")
public class SysUser {
	
	private BigDecimal id;
	private String username;
	private String password;
	private int is_used;
	private String user_type;
	private BigDecimal role_id;
	
	@Id
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIs_used() {
		return is_used;
	}
	public void setIs_used(int is_used) {
		this.is_used = is_used;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public BigDecimal getRole_id() {
		return role_id;
	}
	public void setRole_id(BigDecimal role_id) {
		this.role_id = role_id;
	}
}
