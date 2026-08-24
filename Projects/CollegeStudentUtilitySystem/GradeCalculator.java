import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalculator {

    public void calculateGradeAndCGPA(Scanner sc) {

        System.out.println("\n--- Grade & CGPA Calculator ---");

        int subjects;

        while (true) {

            try {

                System.out.print("Enter number of subjects: ");
                subjects = sc.nextInt();

                if (subjects <= 0) {

                    System.out.println(
                            "Invalid input! Number of subjects must be greater than 0.");

                    continue;
                }

                break;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter a whole number.");

                sc.nextLine();
            }
        }

        double totalWeightedPoints = 0;
        int totalCredits = 0;
        double totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            System.out.println("\nSubject " + i);

            sc.nextLine();

            System.out.print("Enter subject name: ");
            String subjectName = sc.nextLine();

            double marks;

            while (true) {

                try {

                    System.out.print("Enter marks (0-100): ");
                    marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {

                        System.out.println(
                                "Invalid marks! Enter marks between 0 and 100.");

                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input! Please enter a number.");

                    sc.nextLine();
                }
            }

            int credits;

            while (true) {

                try {

                    System.out.print("Enter subject credits: ");
                    credits = sc.nextInt();

                    if (credits <= 0) {

                        System.out.println(
                                "Credits must be greater than 0.");

                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {

                    System.out.println(
                            "Invalid input! Please enter a whole number.");

                    sc.nextLine();
                }
            }

            String grade;
            int gradePoint;

            if (marks >= 90) {

                grade = "A+";
                gradePoint = 10;

            } else if (marks >= 80) {

                grade = "A";
                gradePoint = 9;

            } else if (marks >= 70) {

                grade = "B";
                gradePoint = 8;

            } else if (marks >= 60) {

                grade = "C";
                gradePoint = 7;

            } else if (marks >= 50) {

                grade = "D";
                gradePoint = 6;

            } else {

                grade = "F";
                gradePoint = 0;
            }

            double weightedPoints =
                    gradePoint * credits;

            totalWeightedPoints += weightedPoints;
            totalCredits += credits;
            totalMarks += marks;

            System.out.println("\nSubject Result");
            System.out.println("------------------------------");
            System.out.println("Subject: " + subjectName);
            System.out.println("Marks: " + marks);
            System.out.println("Credits: " + credits);
            System.out.println("Grade: " + grade);
            System.out.println("Grade Point: " + gradePoint);
        }

        double averageMarks =
                totalMarks / subjects;

        double cgpa =
                totalWeightedPoints / totalCredits;

        System.out.println("\n==========================================");
        System.out.println("             FINAL RESULT");
        System.out.println("==========================================");

        System.out.printf(
                "Total Marks: %.2f%n",
                totalMarks);

        System.out.printf(
                "Average Marks: %.2f%n",
                averageMarks);

        System.out.println(
                "Total Credits: " + totalCredits);

        System.out.printf(
                "CGPA: %.2f%n",
                cgpa);

        System.out.println("==========================================");
    }
}