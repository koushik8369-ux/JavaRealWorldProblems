public class Booking {

    private String bookingId;
    private Customer customer;
    private Movie movie;
    private int row;
    private int seat;

    public Booking(String bookingId, Customer customer,
                   Movie movie, int row, int seat) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.movie = movie;
        this.row = row;
        this.seat = seat;
    }

    public void displayBookingDetails() {

        System.out.println("\n===== BOOKING CONFIRMED =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " +
                customer.getCustomerName());
        System.out.println("Movie: " +
                movie.getMovieName());
        System.out.println("Seat: Row " +
                row + ", Seat " + seat);
        System.out.println("Ticket Price: ₹" +
                movie.getTicketPrice());
    }
}