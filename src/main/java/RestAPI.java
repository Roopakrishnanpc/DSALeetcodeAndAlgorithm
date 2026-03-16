//package main.java;
//
//
//@Repository
//@RequestMapping("api/v1")
//public class RestAPIController {
//	
//	@Autowired
//	OrderService orderService;
//	
//	RestControler(OrderService orderService){
//		this.orderService=orderService;
//	}
//	
//	@GetMapping("order")
//	public ResponseEntity<?> orders(){
//		oorderService.getOrder();
//	}
//}
//
//
//interface OrderService {
//	Order getOrder;
//}
//package com.example.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    private final RestTemplate restTemplate;
//
//    public OrderServiceImpl(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public List<Order> getOrders(){
//
//        String url = "https://jsonplaceholder.typicode.com/posts";
//
//        Order[] orders = restTemplate.getForObject(url, Order[].class);
//
//        return Arrays.asList(orders);
//    }
//}
//
//
//
//@Repository
//interface OrderRepository extends JPARepository
