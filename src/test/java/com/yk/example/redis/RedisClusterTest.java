package com.yk.example.redis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;


public class RedisClusterTest {
	
	private JedisCluster jc = null;
	
	@Before
	public void init(){
		
	
	}
	
	@Test
	public void test1(){
		Set<HostAndPort> jedisClusterNodes = new HashSet<>();
	    jedisClusterNodes.add(new redis.clients.jedis.HostAndPort("192.168.127.128", 7000));
		jedisClusterNodes.add(new redis.clients.jedis.HostAndPort("192.168.127.128", 7001));
		jedisClusterNodes.add(new redis.clients.jedis.HostAndPort("192.168.127.128", 7002));
	    jc = new JedisCluster(jedisClusterNodes);
		
	   System.out.println(jc.getClusterNodes().size());	    
	   Map<String, JedisPool> nodes =  jc.getClusterNodes();
	   for(Map.Entry<String, JedisPool> entry : nodes.entrySet()){
		   System.out.println(entry.getKey()+"----------"+entry.getValue());
	   }
	   jc.set("hello","world");
		System.out.println(jc.get("hello"));
	}
	


}
