package com.application.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageListener implements MessageListener {
	
	@Resource
	private RedisCachService redisCachService;
	
	 public String receiveMessage(Serializable message) {
		 System.out.println(message);
		 return message.toString();
     }

	public void onMessage(Message message, byte[] pattern) {
		StringRedisSerializer serializer = new StringRedisSerializer();
		System.out.println(serializer.deserialize(message.getBody()) );
	}
	
}
