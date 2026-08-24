import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java Calculator ===");

        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.println("\nResults:");
        System.out.println("Addition       : " + (a + b));
        System.out.println("Subtraction    : " + (a - b));
        System.out.println("Multiplication : " + (a * b));

        if (b != 0) {
            System.out.println("Division       : " + (a / b));
        } else {
            System.out.println("Division       : Cannot divide by zero");
        }

        scanner.close();
    }
}