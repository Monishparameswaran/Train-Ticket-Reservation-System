# Train Ticket Reservation System

A Java-based console application simulating a real-world train ticket reservation system with features like booking, cancellation, and notifications. The system efficiently manages ticket types, berths, and special conditions for passengers, ensuring an intuitive and realistic experience. It offers functionalities such as reserving berths, handling RAC (Reservation Against Cancellation) tickets, and maintaining a waiting list. The system also implements rules for priority seating, such as allocating lower berths to elderly passengers and women with children. Notifications are sent to passengers regarding ticket status changes during cancellations, enhancing user communication. The flexible design accommodates both train and flight reservations, offering scalability for other transport systems.

## Key Features:
- **Ticket Types**: 
  - **63 Berths**
  - **16 RAC (Reservation Against Cancellation)** tickets (seats only, no sleeping berth)
  - **10 Waiting List** tickets (moves to RAC upon cancellation)
- **Booking Conditions**:
  - Children under age 5 cannot be allocated tickets, but data is stored.
  - Elderly and women with children are allocated **lower berths** by default, regardless of their preference.
  - **Passenger Details** required during booking: Name, Age, Gender, Berth Preference.
- **Cancellation Logic**:
  - RAC tickets are upgraded to Berths upon cancellations.
  - Waiting List tickets move to RAC.
- **Ticket Printing**: Print booked and available tickets, including passenger details and notifications.

## Design Patterns:
- **Singleton**: For managing a single reservation system instance.
- **Factory & Abstract Factory**: Used to create related objects for booking, cancellation, and printing services (train, flight, bus).
- **Observer**: Notifies passengers in RAC and waiting list about ticket status changes during cancellations.

## Classes and Interfaces:
- **BookingService (TicketBooking)**: Handles ticket booking and availability checks.
  - Methods: `bookTicket(Passenger p)`, `isBookingAvailable()`
- **CancellationService (TicketCancellation)**: Manages ticket cancellations.
  - Method: `cancel(int passengerID)`
- **PrintingService (TicketPrinter)**: Prints passenger ticket details and available tickets.
  - Method: `print(int id)`
- **ReservationSystem**: Singleton class that integrates all services.
  - Methods: `bookTicket(Passenger p)`, `cancelTicket(int passengerID)`, `printBooked()`, `printAvailableTickets()`
- **NotificationSystem (NotificationService)**: Notifies passengers of ticket status changes.

## How It Works:
1. **Booking**: Passengers can book a ticket by providing their details and preferences. Special conditions for children, elderly, and women are handled automatically.
2. **Cancellation**: Upon cancellation, RAC tickets move to Berths, and waiting list tickets are promoted to RAC. A notification system ensures passengers are updated with status changes.
3. **Printing**: Users can view booked tickets or available tickets at any time.

## Technologies Used:
- **Java**: Core programming language.
- **Design Patterns**: Singleton, Factory, Abstract Factory, Observer.
- **OOP Principles**: Ensures code reusability and maintainability.
