import java.util.Scanner;

public class GymMembershipSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== GYM MEMBERSHIP SYSTEM =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String memberName = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter Membership Plan (Basic/Standard/Premium): ");
        String membershipPlan = sc.nextLine();

        int monthlyFee;

        if (membershipPlan.equalsIgnoreCase("Basic")) {
            monthlyFee = 500;

        } else if (membershipPlan.equalsIgnoreCase("Standard")) {
            monthlyFee = 800;

        } else if (membershipPlan.equalsIgnoreCase("Premium")) {
            monthlyFee = 1200;

        } else {
            System.out.println("Invalid membership plan!");
            sc.close();
            return;
        }

        System.out.println("\n===== GYM MEMBER DETAILS =====");
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Membership Plan: " + membershipPlan);
        System.out.println("Monthly Fee: ₹" + monthlyFee);

        sc.close();
    }
}