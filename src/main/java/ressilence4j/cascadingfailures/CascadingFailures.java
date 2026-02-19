package main.java.ressilence4j.cascadingfailures;
//
//public class CascadingFailures {
//
//}
//Perfect! ✅ You want a **full, production-grade resilience patterns demo** in Spring Boot — including **circuit breakers, fallbacks, caching, timeouts, bulkhead, thread pool, semaphore**. Let’s go **step by step**, with a **working example you can use in real applications**.
//
//We’ll use **Resilience4j**, which is the **de facto standard for Spring Boot** (lightweight, annotation-based, supports advanced patterns).
//
//---
//
//# 🔹 1️⃣ Add Dependencies
//
//**Maven:**
//
//```xml
//<dependency>
//    <groupId>io.github.resilience4j</groupId>
//    <artifactId>resilience4j-spring-boot3</artifactId>
//    <version>2.1.0</version>
//</dependency>
//<dependency>
//    <groupId>io.github.resilience4j</groupId>
//    <artifactId>resilience4j-circuitbreaker</artifactId>
//</dependency>
//<dependency>
//    <groupId>io.github.resilience4j</groupId>
//    <artifactId>resilience4j-bulkhead</artifactId>
//</dependency>
//<dependency>
//    <groupId>io.github.resilience4j</groupId>
//    <artifactId>resilience4j-timelimiter</artifactId>
//</dependency>
//<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-starter-cache</artifactId>
//</dependency>
//```
//
//Enable caching in Spring Boot:
//
//```java
//@SpringBootApplication
//@EnableCaching
//public class ResilienceApp {
//    public static void main(String[] args) {
//        SpringApplication.run(ResilienceApp.class, args);
//    }
//}
//```
//
//---
//
//# 🔹 2️⃣ Create a Simple Service
//
//We simulate a **remote service** that sometimes fails or is slow:
//
//```java
//@Service
//public class RemoteService {
//
//    private Random random = new Random();
//
//    public String fetchData(String id) {
//        int r = random.nextInt(10);
//        if (r < 3) { // 30% chance to fail
//            throw new RuntimeException("Remote service failed!");
//        }
//        try {
//            Thread.sleep(1000); // simulate delay
//        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//        return "Data-" + id + "-" + System.currentTimeMillis();
//    }
//}
//```
//
//---
//
//# 🔹 3️⃣ Circuit Breaker + Fallback + Cache
//
//We want **three levels**:
//
//1. **Normal call** → remote service
//2. **Fallback 1** → if service fails, use a simple cached value
//3. **Fallback 2** → if cache empty, return default message
//
//```java
//@Service
//public class DataService {
//
//    private final RemoteService remoteService;
//    private final CacheManager cacheManager;
//
//    public DataService(RemoteService remoteService, CacheManager cacheManager) {
//        this.remoteService = remoteService;
//        this.cacheManager = cacheManager;
//    }
//
//    @Cacheable(value = "dataCache", key = "#id")
//    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "remoteServiceCB", fallbackMethod = "fallback1")
//    public String getData(String id) {
//        return remoteService.fetchData(id); // normal call
//    }
//
//    // 1st fallback: fetch from cache manually
//    public String fallback1(String id, Throwable t) {
//        System.out.println("Fallback1 triggered: " + t.getMessage());
//        var cache = cacheManager.getCache("dataCache");
//        String cached = cache != null ? cache.get(id, String.class) : null;
//        if (cached != null) {
//            return cached;
//        }
//        return fallback2(id, t);
//    }
//
//    // 2nd fallback: default value
//    public String fallback2(String id, Throwable t) {
//        System.out.println("Fallback2 triggered: returning default value");
//        return "Default-Data-" + id;
//    }
//}
//```
//
//**Explanation:**
//
//* `@CircuitBreaker` → monitors failures and opens breaker if failure rate is high
//* `fallback1` → first fallback, tries **cache**
//* `fallback2` → last fallback, default value
//
//---
//
//# 🔹 4️⃣ Timeout / ThreadPool / Semaphore (Bulkhead)
//
//```java
//@Service
//public class BulkheadService {
//
//    private final RemoteService remoteService;
//
//    public BulkheadService(RemoteService remoteService) {
//        this.remoteService = remoteService;
//    }
//
//    @io.github.resilience4j.bulkhead.annotation.Bulkhead(name = "bulkheadService", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "bulkheadFallback")
//    @io.github.resilience4j.timelimiter.annotation.TimeLimiter(name = "timeLimiterService", fallbackMethod = "timeoutFallback")
//    public CompletableFuture<String> fetchAsync(String id) {
//        return CompletableFuture.supplyAsync(() -> remoteService.fetchData(id));
//    }
//
//    public CompletableFuture<String> timeoutFallback(String id, Throwable t) {
//        return CompletableFuture.completedFuture("Timeout fallback for " + id);
//    }
//
//    public CompletableFuture<String> bulkheadFallback(String id, Throwable t) {
//        return CompletableFuture.completedFuture("Bulkhead fallback for " + id);
//    }
//}
//```
//
//**Explanation:**
//
//* **Semaphore Bulkhead** → limits concurrent calls to avoid resource exhaustion
//* **Thread Pool Bulkhead** → each service can have a dedicated thread pool
//* **TimeLimiter** → enforces **maximum allowed execution time**; triggers fallback if exceeded
//
//---
//
//# 🔹 5️⃣ Controller Example
//
//```java
//@RestController
//@RequestMapping("/api")
//public class DataController {
//
//    private final DataService dataService;
//    private final BulkheadService bulkheadService;
//
//    public DataController(DataService dataService, BulkheadService bulkheadService) {
//        this.dataService = dataService;
//        this.bulkheadService = bulkheadService;
//    }
//
//    @GetMapping("/data/{id}")
//    public String getData(@PathVariable String id) {
//        return dataService.getData(id);
//    }
//
//    @GetMapping("/async-data/{id}")
//    public CompletableFuture<String> getAsyncData(@PathVariable String id) {
//        return bulkheadService.fetchAsync(id);
//    }
//}
//```
//
//---
//
//# 🔹 6️⃣ How It Works Together (Production Ready)
//
//1. **User hits `/data/{id}`** → normal service call
//2. **Service fails** → CircuitBreaker triggers **fallback1** → tries **cache**
//3. **Cache empty** → fallback2 returns **default value**
//4. **Async calls** → use **Bulkhead + Semaphore** → limits concurrent execution
//5. **Timeout** → if remote service slow, triggers **timeout fallback**
//6. **Caching** → ensures repeated calls are fast, avoids overloading service
//
//---
//
//# 🔹 7️⃣ Advanced Features
//
//* **CircuitBreaker config**: failure rate threshold, wait duration, minimum calls
//* **Bulkhead config**: max concurrent calls, max thread pool size
//* **TimeLimiter config**: duration for timeout
//* **Combining caching + fallback** → reduces DB/API load under heavy traffic
//* **Observability**: Resilience4j exposes **metrics** via Micrometer/Prometheus
//
//---
//
//✅ With this setup, you now have **real-world resilient service**:
//
//* Circuit breaker with **multi-level fallback**
//* Cache-aware fallback
//* Timeout protection
//* Bulkhead (thread pool / semaphore) limiting
//
//---
//
//
//@Service
//public class BulkheadService {
//
//    private final RemoteService remoteService;
//
//    public BulkheadService(RemoteService remoteService) {
//        this.remoteService = remoteService;
//    }
//
//    @io.github.resilience4j.bulkhead.annotation.Bulkhead(
//        name = "bulkheadService", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "bulkheadFallback")
//    @io.github.resilience4j.timelimiter.annotation.TimeLimiter(
//        name = "timeLimiterService", fallbackMethod = "timeoutFallback")
//    public CompletableFuture<String> fetchAsync(String id) {
//        return CompletableFuture.supplyAsync(() -> remoteService.fetchData(id));
//    }
//
//    public CompletableFuture<String> timeoutFallback(String id, Throwable t) {
//        return CompletableFuture.completedFuture("Timeout fallback for " + id);
//    }
//
//    public CompletableFuture<String> bulkheadFallback(String id, Throwable t) {
//        return CompletableFuture.completedFuture("Bulkhead fallback for " + id);
//    }
//}
