public class AvailableTicketsPrinter implements AvailableTicketPrinterService {
   public void print(){
       System.out.println("----------Available tickets are----------");
       System.out.println("Lower Berth: "+TicketBooking.availableLowerBerths);
       System.out.println("Middle Berth: "+TicketBooking.availableMiddleBerths);
       System.out.println("Upper Berth: "+TicketBooking.availableUpperBerths);
       System.out.println("RAC Berth: "+TicketBooking.availableRacTickets);
       System.out.println("Waiting List: "+TicketBooking.availableWaitingList);
       System.out.println("---------------------------------------------");

   }
}
