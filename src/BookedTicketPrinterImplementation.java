public class BookedTicketPrinterImplementation implements BookedTicketsPrinterService {
    public void print(){
        for( Integer it:TicketBooking.passengers.keySet() ){
            System.out.println(TicketBooking.passengers.get(it).toString());
        }
    }
}
