import java.util.Scanner;

public class MovieTicketBooking {

    static final int ROWS = 5;
    static final int SEATS = 6;
    static final int TICKET_PRICE = 150;

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] seats = new int[ROWS][SEATS];

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING =====");
            System.out.println("1. Display Seats");
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

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movieName = sc.nextLine();

                    System.out.print("Enter Row (1-5): ");
                    int row = sc.nextInt();

                    System.out.print("Enter Seat (1-6): ");
                    int seat = sc.nextInt();

                    if (row < 1 || row > ROWS ||
                        seat < 1 || seat > SEATS) {

                        System.out.println("Invalid row or seat!");

                    } else if (seats[row - 1][seat - 1] == 1) {

                        System.out.println("Seat already booked!");

                    } else {

                        seats[row - 1][seat - 1] = 1;

                        String bookingId = String.format(
                                "B%03d", bookingCounter);

                        bookingCounter++;

                        totalRevenue += TICKET_PRICE;

                        Booking booking = new Booking(
                                bookingId,
                                customerName,
                                movieName,
                                row,
                                seat,
                                TICKET_PRICE
                        );

                        booking.displayBookingDetails();
                    }

                    break;

                case 3:

                    System.out.print("Enter Row (1-5): ");
                    int cancelRow = sc.nextInt();

                    System.out.print("Enter Seat (1-6): ");
                    int cancelSeat = sc.nextInt();

                    if (cancelRow < 1 || cancelRow > ROWS ||
                        cancelSeat < 1 || cancelSeat > SEATS) {

                        System.out.println("Invalid row or seat!");

                    } else if (seats[cancelRow - 1][cancelSeat - 1] == 0) {

                        System.out.println("Seat is not booked!");

                    } else {

                        seats[cancelRow - 1][cancelSeat - 1] = 0;

                        totalRevenue -= TICKET_PRICE;

                        System.out.println(
                                "Booking cancelled successfully!");

                        System.out.println(
                                "₹" + TICKET_PRICE + " refunded.");
                    }

                    break;

                case 4:

                    System.out.println("\n===== REVENUE SUMMARY =====");
                    System.out.println(
                            "Ticket Price: ₹" + TICKET_PRICE);

                    System.out.println(
                            "Total Revenue: ₹" + totalRevenue);

                    break;

                case 5:

                    System.out.println(
                            "Thank you for using Movie Ticket Booking System!");

                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}