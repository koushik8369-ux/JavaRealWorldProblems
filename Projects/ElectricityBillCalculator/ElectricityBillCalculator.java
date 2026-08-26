import java.util.Scanner;

class ElectricityBill {

    private static final double FIXED_CHARGE = 100.0;
    private static final double SURCHARGE_RATE = 0.05;

    private static final int FIRST_SLAB_LIMIT = 100;
    private static final int SECOND_SLAB_LIMIT = 200;
    private static final int THIRD_SLAB_LIMIT = 500;

    private static final double FIRST_SLAB_RATE = 2.0;
    private static final double SECOND_SLAB_RATE = 3.0;
    private static final double THIRD_SLAB_RATE = 5.0;
    private static final double FOURTH_SLAB_RATE = 7.0;

    private String customerName;
    private int units;

    public ElectricityBill(String customerName, int units) {
        this.customerName = customerName;
        this.units = units;
    }

    public boolean isValid() {
        return customerName != null
                && !customerName.trim().isEmpty()
                && units >= 0;
    }

    public double calculateEnergyCharge() {

        if (units <= FIRST_SLAB_LIMIT) {
            return units * FIRST_SLAB_RATE;
        }

        if (units <= SECOND_SLAB_LIMIT) {
            return (FIRST_SLAB_LIMIT * FIRST_SLAB_RATE)
                    + ((units - FIRST_SLAB_LIMIT) * SECOND_SLAB_RATE);
        }

        if (units <= THIRD_SLAB_LIMIT) {
            return (FIRST_SLAB_LIMIT * FIRST_SLAB_RATE)
                    + ((SECOND_SLAB_LIMIT - FIRST_SLAB_LIMIT) * SECOND_SLAB_RATE)
                    + ((units - SECOND_SLAB_LIMIT) * THIRD_SLAB_RATE);
        }

        return (FIRST_SLAB_LIMIT * FIRST_SLAB_RATE)
                + ((SECOND_SLAB_LIMIT - FIRST_SLAB_LIMIT) * SECOND_SLAB_RATE)
                + ((THIRD_SLAB_LIMIT - SECOND_SLAB_LIMIT) * THIRD_SLAB_RATE)
                + ((units - THIRD_SLAB_LIMIT) * FOURTH_SLAB_RATE);
    }

    public double calculateSurcharge() {

        double energyCharge = calculateEnergyCharge();

        if (energyCharge > 2000) {
            return energyCharge * SURCHARGE_RATE;
        }

        return 0.0;
    }

    public double calculateTotalBill() {

        return calculateEnergyCharge()
                + FIXED_CHARGE
                + calculateSurcharge();
    }

    public void displayBill() {

        double energyCharge = calculateEnergyCharge();
        double surcharge = calculateSurcharge();
        double totalBill = calculateTotalBill();

        System.out.println();
        System.out.println("========================================");
        System.out.println("          ELECTRICITY BILL");
        System.out.println("========================================");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Used    : " + units);
        System.out.println("----------------------------------------");
        System.out.printf("Energy Charge : ₹%.2f%n", energyCharge);
        System.out.printf("Fixed Charge  : ₹%.2f%n", FIXED_CHARGE);
        System.out.printf("Surcharge     : ₹%.2f%n", surcharge);
        System.out.println("----------------------------------------");
        System.out.printf("Total Bill    : ₹%.2f%n", totalBill);
        System.out.println("========================================");
    }
}

public class ElectricityBillCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       ELECTRICITY BILL CALCULATOR");
        System.out.println("========================================");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        ElectricityBill bill =
                new ElectricityBill(customerName, units);

        if (bill.isValid()) {
            bill.displayBill();
        } else {
            System.out.println();
            System.out.println("Invalid input.");
            System.out.println("Customer name cannot be empty.");
            System.out.println("Units cannot be negative.");
        }

        sc.close();
    }
}