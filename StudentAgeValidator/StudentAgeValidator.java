import java.util.Scanner;

public class StudentAgeValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Registration Validator ===");

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        String ageInput = scanner.nextLine();

        // String to int using Wrapper Class
        int age = Integer.parseInt(ageInput);

        boolean validAge = age >= 0 && age <= 100;
        boolean eligibleForRegistration = age >= 18;
        boolean eligibleForVoting = age >= 18;

        System.out.println("\n=== Student Registration Summary ===");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Age: " + age);

        if (!validAge) {
            System.out.println("Registration Status: Invalid Age");
        } else if (!eligibleForRegistration) {
            System.out.println("Registration Status: Not Eligible");
        } else {
            System.out.println("Registration Status: Eligible");
        }

        System.out.println("Voting Eligibility: " + eligibleForVoting);

        scanner.close();
    }
}