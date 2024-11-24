import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationSystem implements NotificationService {
    private List<PassengerObserver>observers;
    private static NotificationSystem instance;
    private NotificationSystem(){
        observers = new ArrayList<>();
    }
    public static NotificationSystem getInstance(){
        if( instance==null ){
            synchronized (NotificationSystem.class){
                if( instance==null ){
                    instance = new NotificationSystem();
                }
            }
        }
        return instance;
    }
    public void addObservers(PassengerObserver passenger){
        observers.add(passenger);
    }
    public void notifyObservers(String msg){
        for(PassengerObserver observer:observers){
            observer.update(msg);
        }
    }
    public void notifySpecificUser(PassengerObserver observer,String msg){
        observer.update(msg);
    }
}
