import java.util.Scanner;

public class BikeFuelCostCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total distance to travel (km): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter bike mileage (km per litre): ");
        double mileage = scanner.nextDouble();

        System.out.print("Enter petrol price per litre: ");
        double petrolPrice = scanner.nextDouble();

        double fuelRequired = distance / mileage;
        double totalFuelCost = fuelRequired * petrolPrice;

        System.out.printf("Fuel Required: %.2f litres%n", fuelRequired);
        System.out.printf("Total Fuel Cost: \u20B9%.2f%n", totalFuelCost);

        scanner.close();
    }
}