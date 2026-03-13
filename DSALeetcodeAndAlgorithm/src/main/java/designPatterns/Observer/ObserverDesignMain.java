package main.java.designPatterns.Observer;
interface Observer{
    void update(String message);
}
class EmailService implements  Observer{
    public void update(String message){
        System.out.println("Email sent "+ message);
    }
}
class StatusService implements  Observer{
    public void update(String message){
        System.out.println("Status received " + message);
    }
}
class Service {
    private List<Observer> list=new ArrayList<>();
    public void addObserver(Observer observer){
        list.add(observer);
    }
    public void createOrder(){
        notifyObserver("Order created success ");
    }
    private void notifyObserver(String message){
        for(Observer o:observer){
            o.update(message);
        }
    }
}
public class ObserverDesignMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Service service =new Service();
        service.addObserver(new EmailService());
        service.addObserver(new StatusService());
        service.createOrder();
    }
}