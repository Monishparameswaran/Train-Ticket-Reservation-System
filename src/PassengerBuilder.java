public class PassengerBuilder {
    private static int id = 1;
    private String name;
    private int age;
    private String berthPreference;
    private String alloted;
    private int seatNumber;
    private String gender;
    public PassengerBuilder(){}



    public static void setId(int id) {
        PassengerBuilder.id = id;
    }


    public PassengerBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public PassengerBuilder setAge(int age) {
        this.age = age;
        return this;
    }


    public PassengerBuilder setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
        return this;
    }

    public PassengerBuilder setAlloted(String alloted) {
        this.alloted = alloted;
        return this;
    }

    public PassengerBuilder setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public PassengerBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Passenger build(){
        return new Passenger(name,age,berthPreference,seatNumber,gender);
    }
}
