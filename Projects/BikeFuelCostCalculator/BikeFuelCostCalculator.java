import java.util.Scanner;

public class BikeFuelCostCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter one-way distance (km): ");
        double oneWayDistance = scanner.nextDouble();

        System.out.print("Enter bike mileage (km per litre): ");
        double mileage = scanner.nextDouble();

        System.out.print("Enter petrol price per litre: ");
        double petrolPrice = scanner.nextDouble();

        System.out.print("Enter trip duration (days): ");
        int tripDays = scanner.nextInt();

        System.out.print("Enter fuel budget: ");
        double budget = scanner.nextDouble();

        double totalDistance = oneWayDistance * 2;
        double fuelRequired = totalDistance / mileage;
        double totalFuelCost = fuelRequired * petrolPrice;
        double averageDistancePerDay = totalDistance / tripDays;

        System.out.println();
        System.out.println("========== BIKE TRIP SUMMARY ==========");
        System.out.printf("Total Distance          : %.2f km%n", totalDistance);
        System.out.printf("Total Fuel Required     : %.2f litres%n", fuelRequired);
        System.out.printf("Petrol Price            : \u20B9%.2f per litre%n", petrolPrice);
        System.out.printf("Total Fuel Cost         : \u20B9%.2f%n", totalFuelCost);
        System.out.printf("Trip Duration           : %d days%n", tripDays);
        System.out.printf("Average Distance Per Day: %.2f km%n", averageDistancePerDay);
        System.out.printf("Budget                  : \u20B9%.2f%n", budget);

        if (budget >= totalFuelCost) {
            System.out.println("Budget Status           : Trip is within budget");
        } else {
            double extraMoneyNeeded = totalFuelCost - budget;
            System.out.println("Budget Status           : Budget is insufficient");
            System.out.printf("Extra Money Needed      : \u20B9%.2f%n", extraMoneyNeeded);
        }

        System.out.println("========================================");

        scanner.close();
    }
}