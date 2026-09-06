import java.util.Scanner;

public class StudentAgeValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Registration Validator ===");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        String ageInput = scanner.nextLine();

        // Convert String to int using Wrapper Class
        int age = Integer.parseInt(ageInput);

        System.out.println("\n=== Registration Summary ===");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);

        // Age validation and eligibility
        if (age < 0 || age > 100) {
            System.out.println("Status: Invalid Age");
        } else if (age < 18) {
            System.out.println("Status: Not Eligible for Registration");
        } else if (age <= 25) {
            System.out.println("Status: Eligible for Registration");
        } else {
            System.out.println("Status: Requires Special Eligibility Review");
        }

        scanner.close();
    }
}