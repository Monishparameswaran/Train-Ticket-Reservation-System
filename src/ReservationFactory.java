public interface ReservationFactory {
    public BookingService createBookingService();
    public CancellationService createCancellationService();
    public BookedTicketsPrinterService createBookTicketPrinterService();
    public AvailableTicketPrinterService createAvailableTicketPrinterService();
}
