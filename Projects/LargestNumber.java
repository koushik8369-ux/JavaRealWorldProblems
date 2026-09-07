import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = {12, 45, 7, 89, 34};

        int sum = 0;
        int largest = numbers[0];
        int smallest = numbers[0];
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {

            sum += numbers[i];

            if (numbers[i] > largest) {
                largest = numbers[i];
            }

            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }

            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        double average = (double) sum / numbers.length;

        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        boolean found = false;
        int position = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                found = true;
                position = i;
                break;
            }
        }

        System.out.println("\n=== Array Analysis V4 ===");
        System.out.println("Total Elements = " + numbers.length);
        System.out.println("Sum = " + sum);
        System.out.println("Largest Number = " + largest);
        System.out.println("Smallest Number = " + smallest);
        System.out.println("Average = " + average);
        System.out.println("Even Numbers Count = " + evenCount);
        System.out.println("Odd Numbers Count = " + oddCount);

        if (found) {
            System.out.println("Number found at index: " + position);
        } else {
            System.out.println("Number not found in the array.");
        }

        scanner.close();
    }
}