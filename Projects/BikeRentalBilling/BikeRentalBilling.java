import java.util.Scanner;

public class BikeRentalBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== BIKE RENTAL BILLING ==========");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter bike model: ");
        String bikeModel = sc.nextLine();

        System.out.print("Enter rental days: ");
        int rentalDays = sc.nextInt();

        System.out.print("Enter cost per day: ");
        double costPerDay = sc.nextDouble();

        double total = rentalDays * costPerDay;

        System.out.println("\n========== RENTAL BILL ==========");
        System.out.println("Customer     : " + customerName);
        System.out.println("Bike Model   : " + bikeModel);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Cost Per Day : ₹" + costPerDay);
        System.out.println("-------------------------------");
        System.out.println("Total Amount : ₹" + total);

        sc.close();
    }
}