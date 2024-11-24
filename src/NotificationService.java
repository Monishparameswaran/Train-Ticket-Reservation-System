public interface NotificationService {
    public void addObservers(PassengerObserver obj);
    public void notifyObservers(String msg);
    public void notifySpecificUser(PassengerObserver obj,String msg);
}
