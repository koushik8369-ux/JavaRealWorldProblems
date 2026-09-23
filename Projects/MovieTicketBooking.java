import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] seats = new int[5][6];

        while (true) {

            System.out.println();
            System.out.println("===== MOVIE TICKET BOOKING =====");
            System.out.println("1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    displaySeats(seats);
                    break;

                case 2:

                    System.out.print("Enter Row (1-5): ");
                    int bookRow = sc.nextInt();

                    System.out.print("Enter Seat (1-6): ");
                    int bookSeat = sc.nextInt();

                    bookRow = bookRow - 1;
                    bookSeat = bookSeat - 1;

                    if (bookRow < 0 || bookRow >= seats.length ||
                        bookSeat < 0 || bookSeat >= seats[bookRow].length) {

                        System.out.println("Invalid seat selection!");

                    } else if (seats[bookRow][bookSeat] == 1) {

                        System.out.println("Seat already booked!");
                        System.out.println("Booking failed.");

                    } else {

                        seats[bookRow][bookSeat] = 1;

                        System.out.println("Seat booked successfully!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Row (1-5): ");
                    int cancelRow = sc.nextInt();

                    System.out.print("Enter Seat (1-6): ");
                    int cancelSeat = sc.nextInt();

                    cancelRow = cancelRow - 1;
                    cancelSeat = cancelSeat - 1;

                    if (cancelRow < 0 || cancelRow >= seats.length ||
                        cancelSeat < 0 ||
                        cancelSeat >= seats[cancelRow].length) {

                        System.out.println("Invalid seat selection!");

                    } else if (seats[cancelRow][cancelSeat] == 0) {

                        System.out.println("Seat is not booked!");
                        System.out.println("Cancellation failed.");

                    } else {

                        seats[cancelRow][cancelSeat] = 0;

                        System.out.println("Seat cancelled successfully!");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Movie Ticket Booking System!"
                    );

                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }

    static void displaySeats(int[][] seats) {

        System.out.println();
        System.out.println("      1  2  3  4  5  6");

        for (int i = 0; i < seats.length; i++) {

            System.out.print("Row " + (i + 1) + " ");

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == 0) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" X ");
                }
            }

            System.out.println();
        }
    }
}