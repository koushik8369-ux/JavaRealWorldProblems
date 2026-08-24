import java.util.Scanner;

public class LibraryFineCalculator {

    public void calculateFine(Scanner sc) {

        System.out.println("\n--- Library Fine Calculator ---");

        System.out.print(
                "Enter number of overdue days: ");

        int overdueDays = sc.nextInt();

        double fine;

        if (overdueDays <= 0) {

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