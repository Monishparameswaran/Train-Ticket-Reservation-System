
import java.util.*;
public class TicketBooking implements BookingService {

    static int availableLowerBerths = 1;//normally 21
    static int availableMiddleBerths = 1;//normally 21
    static int availableUpperBerths = 1;//normally 21
    static int availableRacTickets = 1;//normally 18
    static int availableWaitingList = 1;//normally 10

    static Queue<Integer> waitingList = new LinkedList<>();//queue of WL passengers
    static Queue<Integer> racList =  new LinkedList<>();//queu of RAC passengers
    static List<Integer> bookedTicketList =  new ArrayList<>();//list of bookedticket passengers

    static List<Integer> lowerBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> middleBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> upperBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...18
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...10


    static Map<Integer, Passenger> passengers = new HashMap<>();//map of passenger ids to passengers
    static NotificationService notificationService = NotificationSystem.getInstance();

    @Override
    public void bookTickets(Passenger p) throws InsufficientTicketException {
        if( !isBookingAvailable() ){
            throw new InsufficientTicketException("there are no more Tickets Available!");
        }
        Passenger.id++;
        p.setPassengerId(Passenger.id);

        String berthPreference = p.getBerthPreference();

        if( berthPreference.equals("L") && availableLowerBerths>0 ){availableLowerBerths--;
            p.setAlloted("L");
        }
        else if( availableMiddleBerths>0 && ((berthPreference.equals("M") ) || (berthPreference.equals("L") )) ){
            availableMiddleBerths--;
            p.setAlloted("M");
        }
        else{
            if( availableUpperBerths > 0 ){availableUpperBerths--;p.setAlloted("U");}
            else if( availableLowerBerths > 0 ){
                availableLowerBerths--;
                p.setAlloted("L");
            }
            else if( availableMiddleBerths>0 ){
                availableMiddleBerths--;
                p.setAlloted("M");
            }
            else if( availableRacTickets>0){
                availableRacTickets--;
                p.setAlloted("RAC");
                racList.add(p.getPassengerID()); // to add the passenger to the RACList
            }
            else{
                if( availableWaitingList>0 ){
                    availableWaitingList--;
                    p.setAlloted("Waiting");
                    waitingList.add(p.getPassengerID());
                }
            }
        }


        passengers.put(Passenger.id,p);
        notificationService.notifySpecificUser(p,"Ticket Booked as :  "+p.getAlloted()+" ticketId: "+p.getPassengerID());
        System.out.println(p.toString());
    }

    @Override
    public boolean isBookingAvailable() {
        return availableLowerBerths > 0 || availableMiddleBerths > 0 || availableUpperBerths > 0
                || availableRacTickets > 0 || availableWaitingList > 0;
    }
}
