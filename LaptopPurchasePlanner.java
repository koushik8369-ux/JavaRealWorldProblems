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

                System.out.print("Do you want EMI? (yes/no): ");
                String emiChoice = sc.next();

                if (emiChoice.equalsIgnoreCase("yes")) {

                    System.out.print("Enter EMI months: ");
                    int months = sc.nextInt();

                    System.out.print("Enter annual interest rate (%): ");
                    double annualRate = sc.nextDouble();

                    double monthlyRate = annualRate / 12 / 100;

                    double monthlyEMI =
                            (remainingAmount * monthlyRate
                            * Math.pow(1 + monthlyRate, months))
                            / (Math.pow(1 + monthlyRate, months) - 1);

                    double totalPayment = monthlyEMI * months;
                    double totalInterest = totalPayment - remainingAmount;

                    System.out.println("\n--- EMI Details ---");
                    System.out.println("Amount through EMI: ₹" + remainingAmount);
                    System.out.println("EMI Months: " + months);
                    System.out.println("Annual Interest Rate: " + annualRate + "%");
                    System.out.println("Monthly EMI: ₹" + monthlyEMI);
                    System.out.println("Total Interest: ₹" + totalInterest);
                    System.out.println("Total Payment: ₹" + totalPayment);

                } else {

                    System.out.println("EMI not selected.");
                    System.out.println("Please save more money before purchasing.");
                }
            }
        }

        sc.close();
    }
}