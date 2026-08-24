import java.util.Scanner;

class Laptop {

    double price;
    double budget;
    double savings;

    Laptop(double price, double budget, double savings) {
        this.price = price;
        this.budget = budget;
        this.savings = savings;
    }

    double getRemainingAmount() {
        return price - savings;
    }

    double getSavingsPercentage() {
        return (savings / price) * 100;
    }

    void displayDetails() {
        System.out.println("\n--- Laptop Details ---");
        System.out.println("Laptop Price    : ₹" + price);
        System.out.println("Student Budget  : ₹" + budget);
        System.out.println("Available Savings: ₹" + savings);
        System.out.println("Savings Covered : "
                + getSavingsPercentage() + "%");
    }
}

public class LaptopPurchasePlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   STUDENT LAPTOP PURCHASE PLANNER");
        System.out.println("=================================");

        System.out.print("Enter laptop price: ₹");
        double price = sc.nextDouble();

        System.out.print("Enter your budget: ₹");
        double budget = sc.nextDouble();

        System.out.print("Enter your savings: ₹");
        double savings = sc.nextDouble();

        Laptop laptop = new Laptop(price, budget, savings);

        laptop.displayDetails();

        double remainingAmount = laptop.getRemainingAmount();

        if (remainingAmount <= 0) {

            System.out.println("\nStatus: You can buy the laptop.");
            System.out.println("You have enough savings.");

        } else {

            System.out.println("\nAmount Needed: ₹" + remainingAmount);

            if (budget >= price) {

                System.out.println("Status: Your budget is sufficient.");

            } else {

                System.out.println(
                        "Status: Your budget is not sufficient.");

                double shortage = price - budget;

                System.out.println("Budget Shortage: ₹" + shortage);

                System.out.print("\nDo you want EMI? (yes/no): ");
                String emiChoice = sc.next();

                if (emiChoice.equalsIgnoreCase("yes")) {

                    System.out.print("Enter EMI months: ");
                    int months = sc.nextInt();

                    System.out.print(
                            "Enter annual interest rate (%): ");
                    double annualRate = sc.nextDouble();

                    double monthlyRate =
                            annualRate / 12 / 100;

                    double monthlyEMI =
                            (remainingAmount * monthlyRate
                            * Math.pow(
                                    1 + monthlyRate,
                                    months))
                            /
                            (Math.pow(
                                    1 + monthlyRate,
                                    months) - 1);

                    double totalPayment =
                            monthlyEMI * months;

                    double totalInterest =
                            totalPayment - remainingAmount;

                    System.out.println("\n--- EMI Details ---");
                    System.out.println(
                            "Amount Through EMI: ₹"
                            + remainingAmount);
                    System.out.println(
                            "EMI Months: " + months);
                    System.out.println(
                            "Interest Rate: "
                            + annualRate + "%");
                    System.out.println(
                            "Monthly EMI: ₹"
                            + monthlyEMI);
                    System.out.println(
                            "Total Interest: ₹"
                            + totalInterest);
                    System.out.println(
                            "Total Payment: ₹"
                            + totalPayment);

                } else {

                    System.out.println(
                            "\nEMI not selected.");

                    System.out.print(
                            "Enter saving period in months: ");

                    int savingMonths =
                            sc.nextInt();

                    double monthlySaving =
                            remainingAmount
                            / savingMonths;

                    System.out.println(
                            "\n--- Saving Plan ---");

                    System.out.println(
                            "Amount to Save: ₹"
                            + remainingAmount);

                    System.out.println(
                            "Saving Period: "
                            + savingMonths
                            + " months");

                    System.out.println(
                            "Save Per Month: ₹"
                            + monthlySaving);
                }
            }
        }

        sc.close();
    }
}