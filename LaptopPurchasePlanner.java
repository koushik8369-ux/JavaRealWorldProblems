import java.util.Scanner;

public class LaptopPurchasePlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter laptop price: ");
        double laptopPrice = sc.nextDouble();

        System.out.print("Enter your budget: ");
        double budget = sc.nextDouble();

        System.out.print("Enter your savings: ");
        double savings = sc.nextDouble();

        double remainingAmount = laptopPrice - savings;

        System.out.println("\n--- Laptop Purchase Summary ---");
        System.out.println("Laptop Price: ₹" + laptopPrice);
        System.out.println("Budget: ₹" + budget);
        System.out.println("Savings: ₹" + savings);

        if (savings >= laptopPrice) {
            System.out.println("Status: You can buy the laptop.");
        } else {
            System.out.println("Amount needed: ₹" + remainingAmount);

            if (remainingAmount <= budget) {
                System.out.println("Status: You can buy it using your budget.");
            } else {
                System.out.println("Status: You need more money.");
            }
        }

        sc.close();
    }
} 