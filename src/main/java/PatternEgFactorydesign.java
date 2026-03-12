//package main.java;
//
//import javax.sound.midi.SysexMessage;
//
//interface Notification{
//	void sendMessage();
//}
//class EmailNotofication  implements  Notification{
//
//	@Override
//	public void sendMessage() {
//		// TODO Auto-generated method stub
//		System.out.println("message using Email");
//	}
//	
//}
//class WhatssappNotificaation implements Notification{
//
//	@Override
//	public void sendMessage() {
//		// TODO Auto-generated method stub
//		System.out.println("message using WhatsApp");
//
//	}
//	
//}
//class MobilePhoneNotofication implements Notification{
//
//	@Override
//	public void sendMessage() {
//		// TODO Auto-generated method stub
//		System.out.println("message using Mobile Phone");
//
//	}	
//}
//
//class NotificationFactory{
//	public static Notification send(String type) {
//	
//	if(type.equals("SMS"))
//		return new MobilePhoneNotofication();
//	else if(type.equals("Whatsapp"))
//		return new WhatssappNotificaation();
//	else 
//		return new EmailNotofication();
//	}
//}
//@RestController
//@RequestMapping("api/v1")
//public class PatternEgFactorydesign {
//	public static void main(String[] args) {
//		Notification notification = NotificationFactory.send("SMS");//new MobilePhoneNotofication();
//		notification.sendMessage();//ystem.out.println("message using Mobile Phone");
//	}
//	PersonService serive=new PersonService();
//
//	@PostMapping("/post")
//	public ResponseEntity<E> postData(@RequestBody Student student){
//		service.postData(student);
//		return ResponseEntity.ok();
//	}
//	
//}
//interface PersonService {
//	void postData(Student student);
//}
//
//@Service
//@Transactional
//public class PersonServiceImpl implements PersonService{
//	PersonRepository repository=new PersonRepository();
//	@Override
//	public void postData(Student student) {
//		// TODO Auto-generated method stub
//		repository.save(person);
//	}
//	
//}
//@Repository
//public class PersonRepository implements JPARepository<>{
//	
//}
//@RestControllerAdvice
//public class GlobalExceptionHandler{
//	
//	@ExceptionHandler(PersonDataIssue.class)
//	handle()
//	throw new pErsonDataIsue(person)
//}
//
//class PersonDataIssue{
//	PersonDataIssue(Person person){
//		System.out.print("Person data is not right, please check the correctness and come back");
//	}
//}