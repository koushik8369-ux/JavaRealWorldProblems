import java.util.Scanner;

public class LaptopPurchasePlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   STUDENT LAPTOP PURCHASE PLANNER");
        System.out.println("=================================");

        System.out.print("Enter laptop price: ₹");
        double laptopPrice = sc.nextDouble();

        System.out.print("Enter your budget: ₹");
        double budget = sc.nextDouble();

        System.out.print("Enter your savings: ₹");
        double savings = sc.nextDouble();

        double remainingAmount = laptopPrice - savings;

        double savingsPercentage = (savings / laptopPrice) * 100;

        System.out.println("\n--- Purchase Summary ---");
        System.out.println("Laptop Price      : ₹" + laptopPrice);
        System.out.println("Budget            : ₹" + budget);
        System.out.println("Savings           : ₹" + savings);
        System.out.println("Savings Covered   : " + savingsPercentage + "%");

        if (savings >= laptopPrice) {

            System.out.println("\nStatus: You can buy the laptop.");
            System.out.println("You have enough savings.");

        } else {

            System.out.println("\nAmount Needed: ₹" + remainingAmount);

            if (budget >= laptopPrice) {

                System.out.println("Status: Your budget is sufficient.");
                System.out.println("You need ₹" + remainingAmount + " more from savings.");

            } else {

                System.out.println("Status: Your current budget is not sufficient.");

                double budgetShortage = laptopPrice - budget;

                System.out.println("Budget Shortage: ₹" + budgetShortage);

                System.out.print("\nDo you want EMI? (yes/no): ");
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
                    System.out.println("Amount through EMI : ₹" + remainingAmount);
                    System.out.println("EMI Months         : " + months);
                    System.out.println("Annual Interest    : " + annualRate + "%");
                    System.out.println("Monthly EMI        : ₹" + monthlyEMI);
                    System.out.println("Total Interest     : ₹" + totalInterest);
                    System.out.println("Total Payment      : ₹" + totalPayment);

                } else {

                    System.out.println("\nEMI not selected.");

                    System.out.print(
                            "Enter how many months you want to save: ");
                    int savingMonths = sc.nextInt();

                    double monthlySaving =
                            remainingAmount / savingMonths;

                    System.out.println("\n--- Saving Plan ---");
                    System.out.println("Amount to Save     : ₹" + remainingAmount);
                    System.out.println("Saving Period      : "
                            + savingMonths + " months");
                    System.out.println("Save Per Month     : ₹"
                            + monthlySaving);
                }
            }
        }

        System.out.println("\n=================================");
        System.out.println("        THANK YOU!");
        System.out.println("=================================");

        sc.close();
    }
}