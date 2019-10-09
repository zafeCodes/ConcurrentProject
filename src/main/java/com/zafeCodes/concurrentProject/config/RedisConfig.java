package com.zafeCodes.concurrentProject.config;

import com.zafeCodes.concurrentProject.config.FastJson2JsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@EnableCaching
@Configuration
public class RedisConfig  extends CachingConfigurerSupport {
	/**
	 *	单机版 redis
	 * @param factory
	 * @return
	 */
	@Bean("redisTemplate")
	public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		// key的序列化类型
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());

		// value的序列化类型
		redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer(Object.class));
		redisTemplate.setHashValueSerializer(new FastJson2JsonRedisSerializer(Object.class));
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
//		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//				.entryTtl(Duration.ofSeconds(60))
//				.disableCachingNullValues();
//
//		return RedisCacheManager.builder(factory)
//				.cacheDefaults(config)
//				.transactionAware()
//				.build();
		return RedisCacheManager.create(factory);
	}

}
