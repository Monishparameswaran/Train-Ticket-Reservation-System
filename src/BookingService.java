public interface BookingService {
    public abstract void bookTickets(Passenger p) throws InsufficientTicketException;
    public abstract boolean isBookingAvailable();
}
