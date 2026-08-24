import java.util.Scanner;

class Laptop {

    private double price;
    private double budget;
    private double savings;

    public Laptop(double price, double budget, double savings) {
        this.price = price;
        this.budget = budget;
        this.savings = savings;
    }

    // Getters
    public double getPrice() {
        return price;
    }

    public double getBudget() {
        return budget;
    }

    public double getSavings() {
        return savings;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    // Calculate remaining amount
    public double getRemainingAmount() {
        return price - savings;
    }

    // Calculate savings percentage
    public double getSavingsPercentage() {
        return (savings / price) * 100;
    }

    // Display laptop details
    public void displayDetails() {

        System.out.println("\n========== LAPTOP DETAILS ==========");

        System.out.printf("Laptop Price      : ₹%.2f%n", price);
        System.out.printf("Student Budget    : ₹%.2f%n", budget);
        System.out.printf("Available Savings : ₹%.2f%n", savings);
        System.out.printf("Savings Covered   : %.2f%%%n",
                getSavingsPercentage());
    }
}

public class LaptopPurchasePlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("       STUDENT LAPTOP PURCHASE PLANNER");
        System.out.println("==========================================");

        // Input
        System.out.print("Enter laptop price: ₹");
        double price = sc.nextDouble();

        System.out.print("Enter your budget: ₹");
        double budget = sc.nextDouble();

        System.out.print("Enter your savings: ₹");
        double savings = sc.nextDouble();

        // Create Laptop object
        Laptop laptop = new Laptop(price, budget, savings);

        // Display details
        laptop.displayDetails();

        double remainingAmount = laptop.getRemainingAmount();

        // Purchase decision
        if (remainingAmount <= 0) {

            System.out.println("\n✅ Status: You can buy the laptop.");
            System.out.println("You have enough savings.");

        } else {

            System.out.printf(
                    "\nAmount Needed: ₹%.2f%n",
                    remainingAmount);

            // Budget check
            if (budget >= price) {

                System.out.println(
                        "✅ Status: Your budget is sufficient.");

                System.out.println(
                        "You need to save the remaining amount.");

            } else {

                System.out.println(
                        "❌ Status: Your budget is not sufficient.");

                double budgetShortage = price - budget;

                System.out.printf(
                        "Budget Shortage: ₹%.2f%n",
                        budgetShortage);

                // EMI option
                System.out.print(
                        "\nDo you want EMI? (yes/no): ");

                String emiChoice = sc.next();

                if (emiChoice.equalsIgnoreCase("yes")) {

                    System.out.print(
                            "Enter EMI period in months: ");

                    int months = sc.nextInt();

                    System.out.print(
                            "Enter annual interest rate (%): ");

                    double annualRate = sc.nextDouble();

                    // EMI calculation
                    double monthlyRate =
                            annualRate / 12 / 100;

                    double monthlyEMI;

                    if (monthlyRate == 0) {

                        monthlyEMI =
                                remainingAmount / months;

                    } else {

                        monthlyEMI =
                                (remainingAmount
                                        * monthlyRate
                                        * Math.pow(
                                                1 + monthlyRate,
                                                months))
                                        /
                                        (Math.pow(
                                                1 + monthlyRate,
                                                months)
                                                - 1);
                    }

                    double totalPayment =
                            monthlyEMI * months;

                    double totalInterest =
                            totalPayment - remainingAmount;

                    // EMI details
                    System.out.println(
                            "\n========== EMI DETAILS ==========");

                    System.out.printf(
                            "Amount Through EMI : ₹%.2f%n",
                            remainingAmount);

                    System.out.println(
                            "EMI Period         : "
                                    + months + " months");

                    System.out.printf(
                            "Annual Interest    : %.2f%%%n",
                            annualRate);

                    System.out.printf(
                            "Monthly EMI        : ₹%.2f%n",
                            monthlyEMI);

                    System.out.printf(
                            "Total Interest     : ₹%.2f%n",
                            totalInterest);

                    System.out.printf(
                            "Total Payment      : ₹%.2f%n",
                            totalPayment);

                } else {

                    // Saving plan
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
                            "\n========== SAVING PLAN ==========");

                    System.out.printf(
                            "Amount to Save : ₹%.2f%n",
                            remainingAmount);

                    System.out.println(
                            "Saving Period  : "
                                    + savingMonths
                                    + " months");

                    System.out.printf(
                            "Save Per Month : ₹%.2f%n",
                            monthlySaving);
                }
            }
        }

        System.out.println(
                "\n==========================================");
        System.out.println(
                "       THANK YOU FOR USING THE PLANNER");
        System.out.println(
                "==========================================");

        sc.close();
    }
}