import java.util.Scanner;

public class MovieTicketBooking {

    static final int ROWS = 5;
    static final int SEATS = 6;

    static int bookingCounter = 1;
    static int totalRevenue = 0;

    public static void displaySeats(int[][] seats) {

        System.out.println("\n===== SEAT LAYOUT =====");

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < SEATS; j++) {
                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("0 = Available | 1 = Booked");
    }

    public static String generateBookingId() {

        String bookingId =
                String.format("B%03d", bookingCounter);

        bookingCounter++;

        return bookingId;
    }

    public static void bookSeat(
            Scanner sc,
            int[][] seats,
            Movie movie) {

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Row (1-5): ");
        int row = sc.nextInt();

        System.out.print("Enter Seat (1-6): ");
        int seat = sc.nextInt();

        sc.nextLine();

        if (row < 1 || row > ROWS ||
            seat < 1 || seat > SEATS) {

            System.out.println("Invalid row or seat!");
            return;
        }

        if (seats[row - 1][seat - 1] == 1) {

            System.out.println("Seat already booked!");
            return;
        }

        seats[row - 1][seat - 1] = 1;

        Customer customer =
                new Customer(customerName);

        String bookingId =
                generateBookingId();

        totalRevenue += movie.getTicketPrice();

        Booking booking = new Booking(
                bookingId,
                customer,
                movie,
                row,
                seat
        );

        booking.displayBookingDetails();
    }

    public static void cancelSeat(
            Scanner sc,
            int[][] seats,
            Movie movie) {

        System.out.print("Enter Row (1-5): ");
        int row = sc.nextInt();

        System.out.print("Enter Seat (1-6): ");
        int seat = sc.nextInt();

        sc.nextLine();

        if (row < 1 || row > ROWS ||
            seat < 1 || seat > SEATS) {

            System.out.println("Invalid row or seat!");
            return;
        }

        if (seats[row - 1][seat - 1] == 0) {

            System.out.println("Seat is not booked!");
            return;
        }

        seats[row - 1][seat - 1] = 0;

        totalRevenue -= movie.getTicketPrice();

        System.out.println(
                "Booking cancelled successfully!");

        System.out.println(
                "₹" + movie.getTicketPrice() +
                " refunded.");
    }

    public static void showRevenue(Movie movie) {

        System.out.println("\n===== REVENUE SUMMARY =====");

        System.out.println(
                "Movie: " + movie.getMovieName());

        System.out.println(
                "Ticket Price: ₹" +
                movie.getTicketPrice());

        System.out.println(
                "Total Revenue: ₹" +
                totalRevenue);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] seats = new int[ROWS][SEATS];

        Movie movie =
                new Movie("Avengers", 150);

        while (true) {

            System.out.println(
                    "\n===== MOVIE TICKET BOOKING =====");

            System.out.println(
                    "Movie: " + movie.getMovieName());

            System.out.println(
                    "Ticket Price: ₹" +
                    movie.getTicketPrice());

            System.out.println("\n1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("4. Show Total Revenue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:
                    displaySeats(seats);
                    break;

                case 2:
                    bookSeat(sc, seats, movie);
                    break;

                case 3:
                    cancelSeat(sc, seats, movie);
                    break;

                case 4:
                    showRevenue(movie);
                    break;

                case 5:

                    System.out.println(
                            "Thank you for using Movie Ticket Booking System!");

                    sc.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice!");
            }
        }
    }
}