package main.java.spring.cache;

public class cache {

	
//	<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-cache</artifactId>
//</dependency>
//
//<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-data-redis</artifactId>
//</dependency>
	
//	import org.springframework.boot.SpringApplication;
//	import org.springframework.boot.autoconfigure.SpringBootApplication;
//	import org.springframework.cache.annotation.EnableCaching;
//
//	@SpringBootApplication
//	@EnableCaching
//	public class CacheApplication {
//	    public static void main(String[] args) {
//	        SpringApplication.run(CacheApplication.class, args);
//	    }
//	}

	
//	import org.springframework.cache.annotation.Cacheable;
//	import org.springframework.stereotype.Service;
//
//	@Service
//	public class UserService {
//
//	    // Simulate slow DB/API
//	    @Cacheable(value = "users", key = "#userId")
//	    public String getUserById(String userId) {
//	        try {
//	            Thread.sleep(2000); // simulate expensive operation
//	        } catch (InterruptedException e) {
//	            Thread.currentThread().interrupt();
//	        }
//	        return "User-" + userId;
//	    }
//	}
	
	
//	import org.springframework.cache.annotation.CacheEvict;
//	import org.springframework.cache.annotation.CachePut;
//
//	@Service
//	public class UserService {
//
//	    @Cacheable(value = "users", key = "#userId")
//	    public String getUserById(String userId) {
//	        simulateSlowService();
//	        return "User-" + userId;
//	    }
//
//	    @CachePut(value = "users", key = "#userId")
//	    public String updateUser(String userId, String name) {
//	        return name; // update cache with new value
//	    }
//
//	    @CacheEvict(value = "users", key = "#userId")
//	    public void deleteUser(String userId) {
//	        // evicts cache
//	    }
//
//	    private void simulateSlowService() {
//	        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//	    }
//	}

	
//	import org.springframework.context.annotation.Bean;
//	import org.springframework.context.annotation.Configuration;
//	import org.springframework.data.redis.cache.RedisCacheConfiguration;
//	import org.springframework.data.redis.cache.RedisCacheManager;
//	import org.springframework.data.redis.connection.RedisConnectionFactory;
//	import org.springframework.data.redis.serializer.RedisSerializationContext;
//	import java.time.Duration;
//
//	@Configuration
//	public class RedisConfig {
//
//	    @Bean
//	    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//	        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//	            .entryTtl(Duration.ofMinutes(10)) // TTL for cached entries
//	            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
//	                    new org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer()
//	            ));
//
//	        return RedisCacheManager.builder(connectionFactory)
//	                .cacheDefaults(config)
//	                .build();
//	    }
//	}



}
