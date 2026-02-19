package main.java.ResTTemplateVSWebClient;

public class RestTemplateVsWebClient {

}
//
//# 🔹 1️⃣ RestTemplate
//
//* Traditional **blocking HTTP client** in Spring.
//* Each request **blocks the calling thread** until response is received.
//* **Still widely used**, but Spring recommends **WebClient** for new reactive apps.
//
//### Example: Synchronous REST call
//
//```java
//@Service
//public class RestTemplateService {
//
//    private final RestTemplate restTemplate;
//
//    public RestTemplateService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String fetchData(String id) {
//        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
//        return restTemplate.getForObject(url, String.class);
//    }
//}
//```
//
//### Bean configuration
//
//```java
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//}
//```
//
//✅ Usage:
//
//```java
//@RestController
//@RequestMapping("/rest")
//public class RestTemplateController {
//
//    private final RestTemplateService service;
//
//    public RestTemplateController(RestTemplateService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/{id}")
//    public String getData(@PathVariable String id) {
//        return service.fetchData(id); // blocking call
//    }
//}
//```
//
//**Drawbacks:**
//
//* Blocks a thread per request → **not scalable** under high concurrency
//* Cannot naturally integrate with **reactive / non-blocking pipelines**
//
//---
//
//# 🔹 2️⃣ WebClient (Spring WebFlux)
//
//* Modern, **non-blocking, reactive** HTTP client
//* Uses **Project Reactor** (`Mono` / `Flux`)
//* Supports **streaming, backpressure, async operations**
//* Can be used in **Spring MVC** or **WebFlux apps**
//
//### Example: Reactive REST call
//
//```java
//@Service
//public class WebClientService {
//
//    private final WebClient webClient;
//
//    public WebClientService(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
//    }
//
//    public Mono<String> fetchData(String id) {
//        return webClient.get()
//                .uri("/todos/{id}", id)
//                .retrieve()
//                .bodyToMono(String.class)
//                .timeout(Duration.ofSeconds(2)) // timeout example
//                .onErrorResume(e -> Mono.just("Fallback: " + e.getMessage()));
//    }
//}
//```
//
//### Bean configuration
//
//```java
//@Configuration
//public class WebClientConfig {
//
//    @Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }
//}
//```
//
//### Controller
//
//```java
//@RestController
//@RequestMapping("/webclient")
//public class WebClientController {
//
//    private final WebClientService service;
//
//    public WebClientController(WebClientService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/{id}")
//    public Mono<String> getData(@PathVariable String id) {
//        return service.fetchData(id); // non-blocking, reactive
//    }
//}
//```
//
//✅ Features:
//
//* **Timeouts**: `.timeout(Duration.ofSeconds(2))`
//* **Fallback / error handling**: `.onErrorResume(...)`
//* **Non-blocking** → efficient for high concurrency
//* Supports **Flux** for streaming multiple items
//
//---
//
//# 🔹 3️⃣ Comparison: RestTemplate vs WebClient
//
//| Feature               | RestTemplate                    | WebClient                 |
//| --------------------- | ------------------------------- | ------------------------- |
//| Blocking?             | ✅ Blocking                      | ❌ Non-blocking            |
//| Reactive              | ❌                               | ✅ Mono / Flux             |
//| Streaming             | ❌                               | ✅ Supported               |
//| Thread efficient      | ❌ consumes 1 thread per request | ✅ scales with few threads |
//| Timeout handling      | Via `RequestFactory`            | Built-in `.timeout()`     |
//| Modern recommendation | Legacy                          | Recommended for new apps  |
//
//---
//
//# 🔹 4️⃣ Advanced WebClient Usage with Resilience
//
//You can **combine WebClient with Resilience4j** for full reactive resilience:
//
//```java
//@Service
//public class ResilientWebClientService {
//
//    private final WebClient webClient;
//
//    public ResilientWebClientService(WebClient.Builder builder) {
//        this.webClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
//    }
//
//    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "webclientCB", fallbackMethod = "fallback")
//    public Mono<String> fetchData(String id) {
//        return webClient.get()
//                .uri("/todos/{id}", id)
//                .retrieve()
//                .bodyToMono(String.class)
//                .timeout(Duration.ofSeconds(2));
//    }
//
//    public Mono<String> fallback(String id, Throwable t) {
//        return Mono.just("Fallback value for " + id);
//    }
//}
//```
//
//---
//
//# 🔹 5️⃣ Best Practices
//
//1. **Prefer WebClient** for new apps, especially high-concurrency or reactive pipelines
//2. Use **timeout + retry + circuit breaker + fallback** for resilience
//3. **Do not block reactive pipelines** (`block()` should be avoided in WebFlux)
//4. Combine with **caching** if you want **offline fallback data**
//
//---
//
//✅ **Summary**:
//
//* **RestTemplate** → simple, blocking, legacy
//* **WebClient** → reactive, non-blocking, future-proof
//* Combine **WebClient + Resilience4j + caching** → production-ready resilient service
//
//---
//
