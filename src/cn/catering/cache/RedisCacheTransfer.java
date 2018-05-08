package cn.catering.cache;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisPool;

public class RedisCacheTransfer {
	@Autowired
	public void setJedisPool(JedisPool jedisPool) {
		RedisCache.setJedisPool(jedisPool);
	}
}
