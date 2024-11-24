import java.util.ArrayList;
import java.util.List;
public class Passenger implements PassengerObserver {
    public static int id = 0;
    private String name;
    private int age;
    private String Gender;
    private int passengerID;
    private String berthPreference;
    private String alloted;
    private int seatNumber;
    private List<String>notifications;
    public Passenger(String name,int age,String berthPreference,int seatNumber,String gender){
        //this.id = id;
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        //this.alloted = alloted;
        this.seatNumber = seatNumber;
        this.Gender = gender;
        notifications = new ArrayList<>();
    }

    public void setPassengerID(int id){this.passengerID = id;}
    public void setGender(String gender){this.Gender = gender;}
    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public void setAlloted(String alloted) {
        this.alloted = alloted;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getBerthPreference() {
        return berthPreference;
    }
    public String getAlloted() {
        return alloted;
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public String getGender() {
        return Gender;
    }
    public List<String> getNotifications(){return notifications;}

    @Override
    public String toString() {
        return "Passenger{" +
                "id= "+this.passengerID+
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", berthPreference='" + this.berthPreference + '\'' +
                ", alloted='" + this.alloted + '\'' +
                ", seatNumber=" + this.seatNumber +
                ",   Notifications = "+ this.notifications +
                '}';
    }

    public void setPassengerId(int id) {
        this.passengerID = id;
    }
    public int getPassengerID(){return this.passengerID;}


    public void update(String msg){
        notifications.add(msg);
    }
}
