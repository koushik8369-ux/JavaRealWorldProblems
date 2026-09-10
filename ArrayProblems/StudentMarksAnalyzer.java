public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        int[] marks = { 78, 85, 67, 92, 74 };

        int total = 0;
        int highest = marks[0];
        int lowest = marks[0];

        System.out.print("Marks: ");

        for (int i = 0; i < marks.length; i++) {

            System.out.print(marks[i] + " ");

            total = total + marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        double average = (double) total / marks.length;

        System.out.println();

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
    }
}