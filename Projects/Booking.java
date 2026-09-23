public class Booking {

    String bookingId;
    String customerName;
    String movieName;
    int row;
    int seat;
    int ticketPrice;

    public Booking(String bookingId, String customerName,
                   String movieName, int row, int seat,
                   int ticketPrice) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.row = row;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
    }

    public void displayBookingDetails() {

        System.out.println("\n===== BOOKING CONFIRMED =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customerName);
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: Row " + row + ", Seat " + seat);
        System.out.println("Ticket Price: ₹" + ticketPrice);
    }
}