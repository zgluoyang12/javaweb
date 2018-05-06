package com.application.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service(value="redisCachService")
public class RedisCachService {
	
	@Resource
	private RedisTemplate redisTemplate;
	
	
	public void set(String key ,String... values){
		ListOperations listLink = redisTemplate.opsForList();
		listLink.leftPushAll(key, values);
		//listLink.
	}
	
	public void get(String key){
		List<String> list = redisTemplate.opsForList().range(key, 0, 4);
		for(String s:list){
			System.out.println(s);
		}
	}
	
	public void sendMessage(String channel, Serializable message){
		redisTemplate.convertAndSend(channel, message);
	}
	
}
