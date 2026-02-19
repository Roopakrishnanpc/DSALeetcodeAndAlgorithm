package main.java.ResTTemplateVSWebClient;

public class RealTime {

}
//Circuit Breaker ✅
//
//Fallback (multi-level) ✅
//
//Cache ✅
//
//Timeout ✅
//
//Bulkhead + Semaphore ✅
//
//Handling 100+ concurrent requests ✅
//
//I’ll share a complete working example step by step.
//
//1️⃣ Dependencies (pom.xml)
//<dependencies>
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-webflux</artifactId>
//    </dependency>
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-cache</artifactId>
//    </dependency>
//    <dependency>
//        <groupId>io.github.resilience4j</groupId>
//        <artifactId>resilience4j-spring-boot3</artifactId>
//        <version>2.1.0</version>
//    </dependency>
//    <dependency>
//        <groupId>io.github.resilience4j</groupId>
//        <artifactId>resilience4j-circuitbreaker</artifactId>
//    </dependency>
//    <dependency>
//        <groupId>io.github.resilience4j</groupId>
//        <artifactId>resilience4j-bulkhead</artifactId>
//    </dependency>
//    <dependency>
//        <groupId>io.github.resilience4j</groupId>
//        <artifactId>resilience4j-timelimiter</artifactId>
//    </dependency>
//</dependencies>
//
//2️⃣ Enable Caching
//@SpringBootApplication
//@EnableCaching
//public class WebClientResilienceApp {
//    public static void main(String[] args) {
//        SpringApplication.run(WebClientResilienceApp.class, args);
//    }
//}
//
//3️⃣ Configure WebClient
//@Configuration
//public class WebClientConfig {
//
//    @Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }
//}
//
//4️⃣ Simulated Remote Service
//
//We simulate an unstable external API:
//
//@Service
//public class RemoteService {
//
//    private final Random random = new Random();
//
//    public String fetchData(String id) {
//        int r = random.nextInt(10);
//        if (r < 3) throw new RuntimeException("Remote service failed!"); // 30% failure
//        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//        return "Remote-Data-" + id + "-" + System.currentTimeMillis();
//    }
//}
//
//5️⃣ WebClient Service with Resilience
//@Service
//public class ResilientWebClientService {
//
//    private final WebClient webClient;
//    private final CacheManager cacheManager;
//    private final RemoteService remoteService;
//
//    public ResilientWebClientService(WebClient.Builder builder, CacheManager cacheManager, RemoteService remoteService) {
//        this.webClient = builder.baseUrl("http://dummy").build(); // URL ignored, using remoteService simulation
//        this.cacheManager = cacheManager;
//        this.remoteService = remoteService;
//    }
//
//    // CircuitBreaker + Cache + Fallback
//    @Cacheable(value = "dataCache", key = "#id")
//    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "webClientCB", fallbackMethod = "fallback1")
//    public String getData(String id) {
//        // Simulate WebClient call (blocking here for demo; normally use Mono)
//        return remoteService.fetchData(id);
//    }
//
//    // 1st fallback: check cache
//    public String fallback1(String id, Throwable t) {
//        System.out.println("Fallback1 triggered: " + t.getMessage());
//        var cache = cacheManager.getCache("dataCache");
//        String cached = cache != null ? cache.get(id, String.class) : null;
//        if (cached != null) return cached;
//        return fallback2(id, t);
//    }
//
//    // 2nd fallback: default value
//    public String fallback2(String id, Throwable t) {
//        System.out.println("Fallback2 triggered: returning default value");
//        return "Default-Data-" + id;
//    }
//
//    // Async call with Bulkhead + Timeout
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
//
//6️⃣ Controller
//@RestController
//@RequestMapping("/api")
//public class DataController {
//
//    private final ResilientWebClientService service;
//
//    public DataController(ResilientWebClientService service) {
//        this.service = service;
//    }
//
//    // Normal call with CircuitBreaker + Cache + Fallback
//    @GetMapping("/data/{id}")
//    public String getData(@PathVariable String id) {
//        return service.getData(id);
//    }
//
//    // Async call with Bulkhead + Timeout
//    @GetMapping("/async-data/{id}")
//    public CompletableFuture<String> getAsyncData(@PathVariable String id) {
//        return service.fetchAsync(id);
//    }
//}
//
//7️⃣ Test Concurrent Requests
//
//You can simulate 100+ concurrent requests using:
//
//a) JMeter / Postman Runner
//
//Send 100+ concurrent GET requests to /api/data/{id} or /api/async-data/{id}.
//
//Observe:
//
//Some requests go to fallback1/fallback2 if remote fails.
//
//Async requests respect bulkhead (Semaphore) limits.
//
//b) Programmatically with Java
//@SpringBootApplication
//public class LoadTestApp implements CommandLineRunner {
//
//    private final DataController controller;
//
//    public LoadTestApp(DataController controller) { this.controller = controller; }
//
//    public static void main(String[] args) { SpringApplication.run(LoadTestApp.class, args); }
//
//    @Override
//    public void run(String... args) throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(20); // 20 threads
//        List<Callable<String>> tasks = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            int id = i % 10;
//            tasks.add(() -> controller.getData(String.valueOf(id)));
//        }
//        List<Future<String>> results = executor.invokeAll(tasks);
//        for (Future<String> f : results) {
//            System.out.println(f.get());
//        }
//        executor.shutdown();
//    }
//}
//
//
//✅ This simulates 100+ concurrent requests, showing:
//
//Circuit breaker triggers
//
//Fallbacks activate
//
//Cache returns previous data
//
//Bulkhead limits concurrency