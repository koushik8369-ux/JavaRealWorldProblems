import java.util.Scanner;

public class ElectricityBillCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== ELECTRICITY BILL ==========");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        double energyCharge;

        if (units <= 100) {
            energyCharge = units * 2;
        } else if (units <= 200) {
            energyCharge = (100 * 2) + ((units - 100) * 3);
        } else if (units <= 500) {
            energyCharge = (100 * 2)
                    + (100 * 3)
                    + ((units - 200) * 5);
        } else {
            energyCharge = (100 * 2)
                    + (100 * 3)
                    + (300 * 5)
                    + ((units - 500) * 7);
        }

        double fixedCharge = 100;
        double totalBill = energyCharge + fixedCharge;

        System.out.println("\n========== ELECTRICITY BILL ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Used    : " + units);
        System.out.printf("Energy Charge : ₹%.2f%n", energyCharge);
        System.out.printf("Fixed Charge  : ₹%.2f%n", fixedCharge);
        System.out.println("--------------------------------------");
        System.out.printf("Total Bill    : ₹%.2f%n", totalBill);

        sc.close();
    }
}