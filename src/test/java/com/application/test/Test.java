package com.application.test;

import static org.junit.Assert.*;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.application.service.RedisCachService;
import com.application.service.RedisMessageListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test{
	
	@Resource
	private RedisCachService  redisCachService;
	
	@Resource
	private RedisMessageListener redisMessageListener;
	
	//@org.junit.Test
	public void test() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext();
//		RedisCachService redisCacheService  = (RedisCachService) ctx.getBean("redisCachService");
//		redisCachService.set("sys_user_test", "8","9","10");
//		redisCachService.get("sys_user_test");
	//	redisCachService.get("1111");
	}
	
	//@org.junit.Test
	public void testSerial(){
		StringRedisSerializer serializer = new StringRedisSerializer();
		byte []b = serializer.serialize("haha 1111");
		System.out.println(serializer.deserialize(b));
		
	}
	@org.junit.Test
	public void testRedisMsg(){
		redisCachService.sendMessage("redisc", "haha 111");
	}
	
	

}
