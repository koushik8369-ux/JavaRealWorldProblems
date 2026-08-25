import java.util.Scanner;

class BikeRental {

    private String customerName;
    private String bikeModel;
    private String category;
    private int rentalDays;
    private double costPerDay;
    private boolean helmetRequired;
    private int extraHelmets;
    private int lateHours;
    private boolean member;
    private String promoCode;

    private static final double HELMET_PER_DAY = 50;
    private static final double SECURITY_DEPOSIT = 2000;
    private static final double LATE_CHARGE_PER_HOUR = 100;

    public BikeRental(String customerName, String bikeModel,
                      String category, int rentalDays,
                      double costPerDay, boolean helmetRequired,
                      int extraHelmets, int lateHours,
                      boolean member, String promoCode) {

        this.customerName = customerName;
        this.bikeModel = bikeModel;
        this.category = category;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
        this.helmetRequired = helmetRequired;
        this.extraHelmets = extraHelmets;
        this.lateHours = lateHours;
        this.member = member;
        this.promoCode = promoCode;
    }

    public boolean isValidRental() {
        return rentalDays > 0
                && costPerDay > 0
                && extraHelmets >= 0
                && lateHours >= 0;
    }

    public double calculateRentalCost() {
        return rentalDays * costPerDay;
    }

    public double calculateHelmetCharges() {

        if (!helmetRequired) {
            return 0;
        }

        int totalHelmets = 1 + extraHelmets;

        return totalHelmets * HELMET_PER_DAY * rentalDays;
    }

    public double calculateLateCharges() {
        return lateHours * LATE_CHARGE_PER_HOUR;
    }

    public double calculateSubtotal() {
        return calculateRentalCost()
                + calculateHelmetCharges()
                + calculateLateCharges();
    }

    public double getLongRentalDiscountRate() {

        if (rentalDays > 5) {
            return 0.15;
        } else if (rentalDays >= 3) {
            return 0.10;
        }

        return 0;
    }

    public double calculateLongRentalDiscount() {
        return calculateSubtotal() * getLongRentalDiscountRate();
    }

    public double getMembershipDiscountRate() {

        if (member) {
            return 0.05;
        }

        return 0;
    }

    public double calculateMembershipDiscount(double amountAfterRentalDiscount) {
        return amountAfterRentalDiscount * getMembershipDiscountRate();
    }

    public double calculatePromoDiscount(double amountAfterOtherDiscounts) {

        if (promoCode.equalsIgnoreCase("SAVE100")) {
            return Math.min(100, amountAfterOtherDiscounts);
        }

        return 0;
    }

    public double calculateFinalRentalAmount() {

        double subtotal = calculateSubtotal();

        double rentalDiscount = calculateLongRentalDiscount();

        double afterRentalDiscount = subtotal - rentalDiscount;

        double membershipDiscount =
                calculateMembershipDiscount(afterRentalDiscount);

        double afterMembershipDiscount =
                afterRentalDiscount - membershipDiscount;

        double promoDiscount =
                calculatePromoDiscount(afterMembershipDiscount);

        return afterMembershipDiscount - promoDiscount;
    }

    public double calculateTotalDiscount() {

        double subtotal = calculateSubtotal();

        double rentalDiscount = calculateLongRentalDiscount();

        double afterRentalDiscount = subtotal - rentalDiscount;

        double membershipDiscount =
                calculateMembershipDiscount(afterRentalDiscount);

        double afterMembershipDiscount =
                afterRentalDiscount - membershipDiscount;

        double promoDiscount =
                calculatePromoDiscount(afterMembershipDiscount);

        return rentalDiscount + membershipDiscount + promoDiscount;
    }

    public double calculateAmountPayable() {
        return calculateFinalRentalAmount() + SECURITY_DEPOSIT;
    }

    public void displayBill() {

        double rentalCost = calculateRentalCost();
        double helmetCharges = calculateHelmetCharges();
        double lateCharges = calculateLateCharges();

        double subtotal = calculateSubtotal();

        double rentalDiscount = calculateLongRentalDiscount();

        double afterRentalDiscount = subtotal - rentalDiscount;

        double membershipDiscount =
                calculateMembershipDiscount(afterRentalDiscount);

        double afterMembershipDiscount =
                afterRentalDiscount - membershipDiscount;

        double promoDiscount =
                calculatePromoDiscount(afterMembershipDiscount);

        double finalRentalAmount = calculateFinalRentalAmount();

        double amountPayable = calculateAmountPayable();

        System.out.println();
        System.out.println("==============================================");
        System.out.println("             BIKE RENTAL BILL");
        System.out.println("==============================================");

        System.out.println("Customer          : " + customerName);
        System.out.println("Bike Model        : " + bikeModel);
        System.out.println("Category          : " + category);
        System.out.println("Rental Days       : " + rentalDays);
        System.out.printf("Cost Per Day      : ₹%.2f%n", costPerDay);

        System.out.println("----------------------------------------------");

        System.out.printf("Rental Cost       : ₹%.2f%n", rentalCost);
        System.out.printf("Helmet Charges    : ₹%.2f%n", helmetCharges);
        System.out.printf("Late Charges      : ₹%.2f%n", lateCharges);
        System.out.printf("Subtotal          : ₹%.2f%n", subtotal);

        System.out.println("----------------------------------------------");

        System.out.printf("Long Rental Disc. : ₹%.2f%n", rentalDiscount);
        System.out.printf("Membership Disc.  : ₹%.2f%n", membershipDiscount);
        System.out.printf("Promo Discount    : ₹%.2f%n", promoDiscount);
        System.out.printf("Total Discount    : ₹%.2f%n",
                calculateTotalDiscount());

        System.out.println("----------------------------------------------");

        System.out.printf("Rental Amount     : ₹%.2f%n",
                finalRentalAmount);

        System.out.printf("Security Deposit  : ₹%.2f%n",
                SECURITY_DEPOSIT);

        System.out.println("----------------------------------------------");

        System.out.printf("Amount Payable    : ₹%.2f%n",
                amountPayable);

        System.out.println("==============================================");
        System.out.println("Security deposit is refundable.");
        System.out.println("==============================================");
    }
}

public class BikeRentalBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== BIKE RENTAL BILLING ==========");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter bike model: ");
        String bikeModel = sc.nextLine();

        System.out.println("\nSelect bike category:");
        System.out.println("1. Scooter");
        System.out.println("2. Bike");
        System.out.println("3. Premium Bike");

        System.out.print("Enter category choice: ");
        int categoryChoice = sc.nextInt();

        String category;

        switch (categoryChoice) {
            case 1:
                category = "Scooter";
                break;

            case 2:
                category = "Bike";
                break;

            case 3:
                category = "Premium Bike";
                break;

            default:
                System.out.println("Invalid bike category.");
                sc.close();
                return;
        }

        System.out.print("Enter rental days: ");
        int rentalDays = sc.nextInt();

        System.out.print("Enter cost per day: ");
        double costPerDay = sc.nextDouble();

        System.out.print("Do you want a helmet? (yes/no): ");
        String helmetChoice = sc.next();

        boolean helmetRequired;

        if (helmetChoice.equalsIgnoreCase("yes")) {
            helmetRequired = true;
        } else if (helmetChoice.equalsIgnoreCase("no")) {
            helmetRequired = false;
        } else {
            System.out.println("Invalid helmet choice.");
            sc.close();
            return;
        }

        int extraHelmets = 0;

        if (helmetRequired) {
            System.out.print("Enter number of extra helmets: ");
            extraHelmets = sc.nextInt();
        }

        System.out.print("Enter late return hours: ");
        int lateHours = sc.nextInt();

        System.out.print("Are you a member? (yes/no): ");
        String memberChoice = sc.next();

        boolean member;

        if (memberChoice.equalsIgnoreCase("yes")) {
            member = true;
        } else if (memberChoice.equalsIgnoreCase("no")) {
            member = false;
        } else {
            System.out.println("Invalid membership choice.");
            sc.close();
            return;
        }

        System.out.print("Enter promo code (or NONE): ");
        String promoCode = sc.next();

        BikeRental rental = new BikeRental(
                customerName,
                bikeModel,
                category,
                rentalDays,
                costPerDay,
                helmetRequired,
                extraHelmets,
                lateHours,
                member,
                promoCode
        );

        if (rental.isValidRental()) {
            rental.displayBill();
        } else {
            System.out.println();
            System.out.println("Invalid rental details.");
            System.out.println(
                    "Rental days, cost, helmets and late hours "
                    + "must be valid."
            );
        }

        sc.close();
    }
}