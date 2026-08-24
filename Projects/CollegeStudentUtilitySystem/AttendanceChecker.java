import java.util.InputMismatchException;
import java.util.Scanner;

public class AttendanceChecker {

    public void checkAttendance(Scanner sc) {

        System.out.println("\n--- Attendance Eligibility Checker ---");

        int totalClasses;

        while (true) {

            try {

                System.out.print("Enter total classes: ");
                totalClasses = sc.nextInt();

                if (totalClasses <= 0) {

                    System.out.println(
                            "Invalid input! Total classes must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter a whole number.");

                sc.nextLine();
            }
        }

        int attendedClasses;

        while (true) {

            try {

                System.out.print("Enter classes attended: ");
                attendedClasses = sc.nextInt();

                if (attendedClasses < 0 ||
                        attendedClasses > totalClasses) {

                    System.out.println(
                            "Invalid input! Attended classes must be between 0 and "
                                    + totalClasses + ".");

                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter a whole number.");

                sc.nextLine();
            }
        }

        double attendance =
                ((double) attendedClasses / totalClasses) * 100;

        double requiredAttendance = 75.0;

        System.out.printf(
                "Attendance Percentage: %.2f%%%n",
                attendance);

        if (attendance >= requiredAttendance) {

            System.out.println(
                    "Status: Eligible for examination.");

        } else {

            System.out.println(
                    "Status: Not eligible for examination.");

            double shortage =
                    requiredAttendance - attendance;

            System.out.printf(
                    "Attendance Shortage: %.2f%%%n",
                    shortage);
        }
    }
}