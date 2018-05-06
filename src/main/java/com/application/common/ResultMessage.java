package com.application.common;

import java.util.HashMap;
import java.util.Map;

public class ResultMessage {
	/**
	 * 无权�?	 */
	public static final String CODE_NO_PERMISION = "NO_PERMISION";
	/**
	 * 未登�?	 */
	public static final String CODE_NO_LOGIN = "NO_LOGIN";
	/**
	 * 重复登陆(多人登陆)
	 */
	public static final String CODE_MULTI_LOGIN = "MULTI_LOGIN";
	
	private boolean success = true;// 是否成功
	private String msg = "操作成功";// 提示信息
	private String code;
	private Object obj = null;// 其他信息
	private Map<String, Object> attributes;// 其他参数
	
	
	public ResultMessage() {
		this.success = true;
	}
	
	
	public ResultMessage(String code) {
		this.code = code;
	}


	public ResultMessage(String code, String msg) {
		this.msg = msg;
		this.code = code;
	}


	public ResultMessage(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void addAttribute(String key ,Object value){
		if(attributes==null){
			attributes = new HashMap<String, Object>();
		}
		attributes.put(key, value);
	}
}
