

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        BookingService svc = new TicketBooking();
//        CancellationService csvc = new TicketCancelling();
//        BookedTicketsPrinterService bpsvc = new BookedTicketPrinterImplementation();
//        AvailableTicketPrinterService psvc = new AvailableTicketsPrinter();
        ReservationSystem sys = ReservationSystem.getInstance(new TrainTicketReservationFactory());
        boolean cond = true;
        while( cond ){
            System.out.println("1. Book the Ticket");
            System.out.println("2. Cancel the Ticket");
            System.out.println("3. Print the Booked Tickets");
            System.out.println("4. Print the Available Tickets");
            System.out.println("5. Exit");
            int option = in.nextInt();
            switch(option){
                case 1:{
                    System.out.print("Enter name: ");
                    String name = in.next();
                    System.out.println();
                    System.out.print("Enter age: ");
                    int age = in.nextInt();
                    System.out.println();
                    System.out.print("Enter gender ");
                    String gender = in.next();
                    System.out.println("Enter birthPreference");
                    String berthPreference = in.next();
                    Passenger p = new PassengerBuilder().setName(name).setAge(age).setGender(gender).
                                setBerthPreference(berthPreference).build();
                    try {
                        sys.bookTickets(p);
                    }
                    catch(InsufficientTicketException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter passengerID to cancel the Tickets: ");
                    int id = in.nextInt();
                    try
                    {sys.cancelTickets(id);}
                    catch (InvalidPassengerId e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    sys.printBookedTickets();
                    break;
                }
                case 4:{
                    sys.printAvailableTickets();
                    break;
                }

                case 5:{
                    cond = false;
                    break;
                }
            }
        }
    }
}

