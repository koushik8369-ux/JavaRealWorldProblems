import java.util.Scanner;

public class StudentAgeValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student age: ");
        String ageInput = scanner.nextLine();

        // Convert String to int using Wrapper Class
        int age = Integer.parseInt(ageInput);

        // Check eligibility
        boolean eligible = age >= 18;

        System.out.println("\n--- Student Details ---");
        System.out.println("Student Age: " + age);
        System.out.println("Eligible for Registration: " + eligible);

        scanner.close();
    }
}