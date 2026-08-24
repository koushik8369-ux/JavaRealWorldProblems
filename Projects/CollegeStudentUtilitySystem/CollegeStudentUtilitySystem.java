import java.util.Scanner;

public class CollegeStudentUtilitySystem {

    // Attendance Eligibility Checker
    public static void checkAttendance(Scanner sc) {

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

    // Grade & CGPA Calculator
    public static void calculateGradeAndCGPA(Scanner sc) {

        System.out.println("\n--- Grade & CGPA Calculator ---");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            System.out.print(
                    "Enter marks for subject "
                            + i + ": ");

            double marks = sc.nextDouble();

            totalMarks += marks;
        }

        double average =
                totalMarks / subjects;

        double cgpa =
                average / 10;

        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.printf(
                "\nTotal Marks: %.2f%n",
                totalMarks);

        System.out.printf(
                "Average: %.2f%n",
                average);

        System.out.println(
                "Grade: " + grade);

        System.out.printf(
                "CGPA: %.2f%n",
                cgpa);
    }

    // Library Fine Calculator
    public static void calculateLibraryFine(Scanner sc) {

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

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                    checkAttendance(sc);
                    break;

                case 2:
                    calculateGradeAndCGPA(sc);
                    break;

                case 3:
                    calculateLibraryFine(sc);
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