import java.util.Scanner;

class BikeRental {

    private String customerName;
    private String bikeModel;
    private int rentalDays;
    private double costPerDay;

    public BikeRental(String customerName, String bikeModel,
                      int rentalDays, double costPerDay) {

        this.customerName = customerName;
        this.bikeModel = bikeModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    public double calculateTotal() {
        return rentalDays * costPerDay;
    }

    public void displayBill() {

        double total = calculateTotal();

        System.out.println("\n========== RENTAL BILL ==========");
        System.out.println("Customer     : " + customerName);
        System.out.println("Bike Model   : " + bikeModel);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Cost Per Day : ₹" + costPerDay);
        System.out.println("--------------------------------");
        System.out.println("Total Amount : ₹" + total);
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

        System.out.print("Enter rental days: ");
        int rentalDays = sc.nextInt();

        System.out.print("Enter cost per day: ");
        double costPerDay = sc.nextDouble();

        BikeRental rental = new BikeRental(
                customerName,
                bikeModel,
                rentalDays,
                costPerDay
        );

        rental.displayBill();

        sc.close();
    }
}