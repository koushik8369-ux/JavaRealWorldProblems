public class LargestNumber {

    public static void main(String[] args) {

        int[] numbers = {12, 45, 7, 89, 34};

        int sum = 0;
        int largest = numbers[0];
        int smallest = numbers[0];

        for (int i = 0; i < numbers.length; i++) {

            sum = sum + numbers[i];

            if (numbers[i] > largest) {
                largest = numbers[i];
            }

            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        double average = (double) sum / numbers.length;

        System.out.println("=== Array Analysis ===");
        System.out.println("Sum = " + sum);
        System.out.println("Largest Number = " + largest);
        System.out.println("Smallest Number = " + smallest);
        System.out.println("Average = " + average);
    }
}