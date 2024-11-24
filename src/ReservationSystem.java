public class ReservationSystem {  // acts as a singleTon class

    private static ReservationSystem instance;
    private BookingService bookingService;
    private CancellationService cancellationService;
    private AvailableTicketPrinterService availableTicketPrinterService;
    private BookedTicketsPrinterService bookedTicketsPrinterService;

    private ReservationSystem(ReservationFactory abstractFactory) {
        bookingService = abstractFactory.createBookingService();
        cancellationService = abstractFactory.createCancellationService();
        availableTicketPrinterService = abstractFactory.createAvailableTicketPrinterService();
        bookedTicketsPrinterService = abstractFactory.createBookTicketPrinterService();
    }
    public void bookTickets(Passenger p)throws InsufficientTicketException{
        bookingService.bookTickets(p);
    }
    public void cancelTickets(int id){
        cancellationService.CancelTicket(id);
    }
    public void printAvailableTickets(){
        availableTicketPrinterService.print();
    }
    public void printBookedTickets(){
        bookedTicketsPrinterService.print();
    }

    public static ReservationSystem getInstance(ReservationFactory factory){
        if( instance==null ){
            synchronized (ReservationSystem.class){
                if( instance==null ) {
                    instance = new ReservationSystem(factory);
                }
            }
        }
        return instance;
    }
}
