import java.util.Scanner;

public class GymMembershipSystem {

    static int memberId;
    static String memberName;
    static int age;
    static String phoneNumber;
    static String membershipPlan;
    static int monthlyFee;

    static boolean memberRegistered = false;

    public static void registerMember(Scanner sc) {

        System.out.println("\n===== REGISTER MEMBER =====");

        System.out.print("Enter Member ID: ");
        memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        memberName = sc.nextLine();

        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        phoneNumber = sc.nextLine();

        System.out.print(
                "Enter Membership Plan (Basic/Standard/Premium): ");
        membershipPlan = sc.nextLine();

        if (membershipPlan.equalsIgnoreCase("Basic")) {

            monthlyFee = 500;

        } else if (membershipPlan.equalsIgnoreCase("Standard")) {

            monthlyFee = 800;

        } else if (membershipPlan.equalsIgnoreCase("Premium")) {

            monthlyFee = 1200;

        } else {

            System.out.println("Invalid membership plan!");
            return;
        }

        memberRegistered = true;

        System.out.println(
                "\nMember registered successfully!");
    }

    public static void viewMemberDetails() {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== MEMBER DETAILS =====");

        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Membership Plan: " + membershipPlan);
        System.out.println("Monthly Fee: ₹" + monthlyFee);
    }

    public static void checkMembershipFee() {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== MEMBERSHIP FEE =====");

        System.out.println(
                "Plan: " + membershipPlan);

        System.out.println(
                "Monthly Fee: ₹" + monthlyFee);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\n===== GYM MEMBERSHIP SYSTEM =====");

            System.out.println("1. Register Member");
            System.out.println("2. View Member Details");
            System.out.println("3. Check Membership Fee");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerMember(sc);
                    break;

                case 2:
                    viewMemberDetails();
                    break;

                case 3:
                    checkMembershipFee();
                    break;

                case 4:

                    System.out.println(
                            "Thank you for using Gym Membership System!");

                    sc.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice!");
            }
        }
    }
}