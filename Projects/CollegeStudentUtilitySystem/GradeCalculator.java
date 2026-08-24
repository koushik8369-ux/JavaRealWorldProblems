import java.util.Scanner;

public class GradeCalculator {

    public void calculateGradeAndCGPA(Scanner sc) {

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
}