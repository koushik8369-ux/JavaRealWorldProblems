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
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    displaySeats(seats);

                    break;

                case 2:

                    System.out.print("Enter Row (1-5): ");
                    int row = sc.nextInt();

                    System.out.print("Enter Seat (1-6): ");
                    int seat = sc.nextInt();

                    row = row - 1;
                    seat = seat - 1;

                    if (row < 0 || row >= seats.length ||
                        seat < 0 || seat >= seats[row].length) {

                        System.out.println("Invalid seat selection!");

                    } else if (seats[row][seat] == 1) {

                        System.out.println("Seat already booked!");
                        System.out.println("Booking failed.");

                    } else {

                        seats[row][seat] = 1;

                        System.out.println();
                        System.out.println("Seat booked successfully!");
                    }

                    break;

                case 3:

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