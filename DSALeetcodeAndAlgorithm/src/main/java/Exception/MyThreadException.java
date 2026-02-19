package main.java.Exception;
class MyThreadException extends Exception {
    public MyThreadException(String message) {
        super(message);///in spring throw new MyThreadException("Something went wrong in /test");

    }
    public MyThreadException(String message, Throwable cause) {
        super(message, cause);
    }
}
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MyThreadException.class)
//    public ResponseEntity<String> handleMyThreadException(MyThreadException ex) {
//        return new ResponseEntity<>("Custom error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
//        // log exception (optional)
//        ex.printStackTrace();
//        return new ResponseEntity<>("Something else went wrong: " + ex.getMessage(),
//                                    HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}

//@RestController
//public class TestController {
//
//    @GetMapping("/custom")
//    public String custom() throws MyThreadException {
//        throw new MyThreadException("Custom error happened!");
//    }
//
//    @GetMapping("/null")
//    public String nullPointer() {
//        String s = null;
//        s.length(); // triggers NullPointerException
//        return "ok";
//    }
//}
