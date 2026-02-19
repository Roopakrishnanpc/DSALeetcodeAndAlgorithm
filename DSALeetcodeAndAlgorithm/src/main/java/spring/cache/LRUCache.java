package main.java.spring.cache;

public class LRUCache {

	
//	<dependency>
//    <groupId>com.github.ben-manes.caffeine</groupId>
//    <artifactId>caffeine</artifactId>
//    <version>3.1.8</version>
//</dependency>

//	
//	import com.github.benmanes.caffeine.cache.Caffeine;
//	import org.springframework.cache.CacheManager;
//	import org.springframework.cache.caffeine.CaffeineCacheManager;
//	import org.springframework.context.annotation.Bean;
//	import org.springframework.context.annotation.Configuration;
//
//	import java.util.concurrent.TimeUnit;
//
//	@Configuration
//	public class CacheConfig {
//
//	    @Bean
//	    public CacheManager cacheManager() {
//	        CaffeineCacheManager cacheManager = new CaffeineCacheManager("users");
//	        cacheManager.setCaffeine(Caffeine.newBuilder()
//	                .maximumSize(1000)       // Max 1000 items
//	                .expireAfterAccess(10, TimeUnit.MINUTES) // LRU eviction + TTL
//	        );
//	        return cacheManager;
//	    }
//	}
// maximumSize + expireAfterAccess → LRU cache behavior.
	
//	
//	Caffeine.newBuilder()
//    .maximumSize(1000)
//    .weigher((key, value) -> 1)
//    .evictionListener((key, value, cause) -> System.out.println("Evicted " + key + " cause: " + cause))
//    .recordStats() // records frequency stats
//    .build();
	
	
	
//	Caffeine.newBuilder()
//    .expireAfterWrite(5, TimeUnit.MINUTES) // expires 5 min after write
//    .maximumSize(1000)
//    .build();
//	expireAfterWrite → TTL per entry
//	expireAfterAccess → resets timer on access (like LRU + TTL hybrid)

}
