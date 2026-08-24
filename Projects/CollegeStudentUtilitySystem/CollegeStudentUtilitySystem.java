import java.util.Scanner;

public class CollegeStudentUtilitySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AttendanceChecker attendanceChecker =
                new AttendanceChecker();

        GradeCalculator gradeCalculator =
                new GradeCalculator();

        LibraryFineCalculator libraryFineCalculator =
                new LibraryFineCalculator();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("       COLLEGE STUDENT UTILITY SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Attendance Eligibility Checker");
            System.out.println("2. Grade & CGPA Calculator");
            System.out.println("3. Library Fine Calculator");
            System.out.println("4. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    attendanceChecker.checkAttendance(sc);
                    break;

                case 2:
                    gradeCalculator.calculateGradeAndCGPA(sc);
                    break;

                case 3:
                    libraryFineCalculator.calculateFine(sc);
                    break;

                case 4:
                    System.out.println(
                            "\nThank you for using the system!");
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}