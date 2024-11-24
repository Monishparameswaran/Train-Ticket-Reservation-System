public class TrainTicketReservationFactory implements ReservationFactory{

    @Override
    public  BookingService createBookingService() {
        return new TicketBooking();
    }

    @Override
    public  CancellationService createCancellationService() {
        return new TicketCancelling();
    }

    @Override
    public  BookedTicketsPrinterService createBookTicketPrinterService() {
        return new BookedTicketPrinterImplementation();
    }

    @Override
    public  AvailableTicketPrinterService createAvailableTicketPrinterService() {
        return new AvailableTicketsPrinter();
    }
}
