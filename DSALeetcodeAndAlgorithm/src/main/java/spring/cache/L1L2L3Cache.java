package main.java.spring.cache;

public class L1L2L3Cache {

	
//	<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-data-redis</artifactId>
//</dependency>
//<dependency>
//    <groupId>com.github.ben-manes.caffeine</groupId>
//    <artifactId>caffeine</artifactId>
//</dependency>

	
//	import com.github.benmanes.caffeine.cache.Cache;
//	import com.github.benmanes.caffeine.cache.Caffeine;
//	import org.springframework.data.redis.core.RedisTemplate;
//	import org.springframework.stereotype.Service;
//
//	import java.util.concurrent.TimeUnit;
//
//	@Service
//	public class UserService {
//
//	    private final Cache<String, String> l1Cache;
//	    private final RedisTemplate<String, String> redisTemplate;
//
//	    public UserService(RedisTemplate<String, String> redisTemplate) {
//	        this.redisTemplate = redisTemplate;
//
//	        l1Cache = Caffeine.newBuilder()
//	                .maximumSize(1000)
//	                .expireAfterAccess(5, TimeUnit.MINUTES)
//	                .build();
	
// Lgeacy
//	Cache<String, String> cache = CacheBuilder.newBuilder()
//	        .maximumSize(1000)
//	        .expireAfterAccess(10, TimeUnit.MINUTES)
//	        .build();
//
//
//	legacy
//	cache.put("user1", "Alice");
//	String user = cache.getIfPresent("user1");
//	    }
//
//	    public String getUser(String userId) {
//
//	        // L1 check
//	        String user = l1Cache.getIfPresent(userId);
//	        if (user != null) return user;
//
//	        // L2 check (Redis)
//	        user = redisTemplate.opsForValue().get(userId);
//	        if (user != null) {
//	            l1Cache.put(userId, user); // populate L1
//	            return user;
//	        }
//
//	        // L3 fallback (DB)
//	        user = getUserFromDb(userId);
//
//	        // Populate caches
//	        redisTemplate.opsForValue().set(userId, user, 10, TimeUnit.MINUTES); // L2
//	        l1Cache.put(userId, user); // L1
//
//	        return user;
//	    }
//
//	    private String getUserFromDb(String userId) {
//	        // Simulate DB call
//	        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//	        return "User-" + userId;
//	    }
//	}
//
//	
//	Fast access → L1 cache (in-memory)
//
//	Shared cache → L2 cache (Redis)
//
//	DB fallback → L3
//
//	🔹 6️⃣ Key Notes for Production
//
//	L1 → Caffeine (LRU/LFU + TTL)
//
//	L2 → Redis (distributed cache)
//
//	Eviction → TTL, LRU, LFU
//
//	Cache warming → populate cache on app startup if needed
//
//	Monitoring → Caffeine provides stats, Redis has INFO command
}
