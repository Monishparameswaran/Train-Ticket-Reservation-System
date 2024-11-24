import sun.security.krb5.internal.Ticket;

import java.util.HashMap;

public class TicketCancelling implements CancellationService {

    private NotificationService notificationService;


    public TicketCancelling(){
        notificationService = NotificationSystem.getInstance();
    }

    private void reduceCountOfTickets(String berth){
        switch(berth){
            case "L":{
                TicketBooking.availableLowerBerths--;
                break;
            }
            case "M":{
                TicketBooking.availableMiddleBerths--;
                break;
            }
            case "U": {
                TicketBooking.availableUpperBerths--;
                break;
            }
        }
    }
    private  void moveSeats(  String berth ){
        if( !TicketBooking.racList.isEmpty() ){
            Passenger firstRACPerson = TicketBooking.passengers.get(TicketBooking.racList.poll());
            TicketBooking.availableRacTickets++;
            firstRACPerson.setAlloted(berth);
            reduceCountOfTickets(berth);
            notificationService.notifySpecificUser(firstRACPerson,"Your ticket status upgraded to "+firstRACPerson.getAlloted());
            // notify the first RAC person
            System.out.println(firstRACPerson);
            if( !TicketBooking.waitingList.isEmpty() ){
                Passenger firstWaitingPerson =  TicketBooking.passengers.get(TicketBooking.waitingList.poll());
                firstWaitingPerson.setAlloted("RAC");
                TicketBooking.availableRacTickets--;
                notificationService.notifySpecificUser(firstWaitingPerson,"Your ticket status upgraded to "+firstWaitingPerson.getAlloted());
                TicketBooking.racList.add(firstWaitingPerson.getPassengerID());
                System.out.println(firstWaitingPerson);
                TicketBooking.availableWaitingList++;
                // notify the firstWaitingPerson
            }
        }

    }
    @Override
    public  void CancelTicket(int passengerID) {
        if( !TicketBooking.passengers.containsKey((passengerID)) ){
            throw new InvalidPassengerId("The given Passenger not found in our records,try again.");
        }
        Passenger curr = TicketBooking.passengers.get(passengerID);

        String berth = curr.getAlloted();
        System.out.println(curr);
        switch (berth){
            case "L": {
                TicketBooking.availableLowerBerths++;
                moveSeats("L");
                // remove from the position
                break;
            }
            case "M":{
                TicketBooking.availableMiddleBerths++;
                moveSeats("M");
                break;
            }
            case "U":{
                TicketBooking.availableUpperBerths++;
                moveSeats("U");
                break;
            }
            case "RAC":{
                TicketBooking.availableRacTickets++;
                if( !TicketBooking.waitingList.isEmpty() ){
                    Passenger firstWaitingPerson =  TicketBooking.passengers.get(TicketBooking.waitingList.poll());
                    firstWaitingPerson.setAlloted("RAC");
                    TicketBooking.availableWaitingList++;
                    TicketBooking.availableRacTickets--;
                    notificationService.notifySpecificUser(firstWaitingPerson,"Your ticket status upgraded to "+firstWaitingPerson.getAlloted());
                    // notify the firstWaitingPerson
                }
                break;
            }
        }
        notificationService.notifySpecificUser(curr,"Your ticket has been cancelled successfully");
        TicketBooking.passengers.remove(passengerID);
    }
}
