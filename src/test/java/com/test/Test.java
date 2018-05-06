package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.application.service.RedisCachService;

import redis.clients.jedis.Jedis;


public class Test {
	
	@org.junit.Test
	public void testSpringRedis(){
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		RedisCachService redisCacheService  = (RedisCachService) ctx.getBean("redisCacheService");
		
		
	}
	
//	public static void main(String[] args){
//		Jedis jedis = new Jedis("60.205.104.67");
//		jedis.auth("my_redis");
//        System.out.println("连接成功");
//        //存储数据到列表中
//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
//        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("site-list", 0 ,2);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }
//	}
}
