import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CollegeStudentUtilitySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students =
                FileManager.loadStudents();

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
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Attendance Eligibility Checker");
            System.out.println("4. Grade & CGPA Calculator");
            System.out.println("5. Library Fine Calculator");
            System.out.println("6. Exit");
            System.out.println("==========================================");

            while (true) {

                try {

                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();

                    break;

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input! Please enter a number from 1 to 6.");

                    sc.nextLine();
                }
            }

            switch (choice) {

                case 1:

                    addStudent(sc, students);

                    FileManager.saveStudents(students);

                    break;

                case 2:

                    viewStudents(students);

                    break;

                case 3:

                    attendanceChecker.checkAttendance(sc);

                    break;

                case 4:

                    gradeCalculator.calculateGradeAndCGPA(sc);

                    break;

                case 5:

                    libraryFineCalculator.calculateFine(sc);

                    break;

                case 6:

                    System.out.println(
                            "\nThank you for using the system!");

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice! Please select 1 to 6.");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void addStudent(
            Scanner sc,
            ArrayList<Student> students) {

        System.out.println("\n--- Add Student ---");

        int id;

        while (true) {

            try {

                System.out.print("Enter student ID: ");
                id = sc.nextInt();

                if (id <= 0) {

                    System.out.println(
                            "Student ID must be greater than 0.");

                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Enter a valid student ID.");

                sc.nextLine();
            }
        }

        sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        int semester;

        while (true) {

            try {

                System.out.print("Enter semester: ");
                semester = sc.nextInt();

                if (semester <= 0) {

                    System.out.println(
                            "Semester must be greater than 0.");

                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Enter a valid semester.");

                sc.nextLine();
            }
        }

        Student student =
                new Student(
                        id,
                        name,
                        department,
                        semester);

        students.add(student);

        System.out.println(
                "\nStudent added successfully!");
    }

    public static void viewStudents(
            ArrayList<Student> students) {

        System.out.println("\n--- Student Records ---");

        if (students.isEmpty()) {

            System.out.println(
                    "No student records found.");

            return;
        }

        System.out.println(
                "Total Students: " + students.size());

        for (Student student : students) {

            student.displayStudent();
        }

        System.out.println("------------------------------------------");
    }
}