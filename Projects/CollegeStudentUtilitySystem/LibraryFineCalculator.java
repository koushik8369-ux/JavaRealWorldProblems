import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryFineCalculator {

    public void calculateFine(Scanner sc) {

        System.out.println("\n--- Library Fine Calculator ---");

        int overdueDays;

        while (true) {

            try {

                System.out.print(
                        "Enter number of overdue days: ");

                overdueDays = sc.nextInt();

                if (overdueDays < 0) {

                    System.out.println(
                            "Invalid input! Overdue days cannot be negative.");

                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter a whole number.");

                sc.nextLine();
            }
        }

        double fine;

        if (overdueDays == 0) {

            fine = 0;

        } else if (overdueDays <= 5) {

            fine = overdueDays * 2;

        } else if (overdueDays <= 10) {

            fine = overdueDays * 5;

        } else {

            fine = overdueDays * 10;
        }

        System.out.printf(
                "Library Fine: ₹%.2f%n",
                fine);

        if (fine == 0) {

            System.out.println(
                    "Status: No fine.");

        } else {

            System.out.println(
                    "Status: Fine pending.");
        }
    }
}