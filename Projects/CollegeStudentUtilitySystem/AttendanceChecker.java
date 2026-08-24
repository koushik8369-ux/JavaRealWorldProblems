import java.util.Scanner;

public class AttendanceChecker {

    public void checkAttendance(Scanner sc) {

        System.out.println("\n--- Attendance Eligibility Checker ---");

        System.out.print("Enter total classes: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter classes attended: ");
        int attendedClasses = sc.nextInt();

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