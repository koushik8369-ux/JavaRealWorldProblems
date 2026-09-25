import java.util.ArrayList;
import java.util.Scanner;

public class GymMembershipSystem {

    static ArrayList<Member> members = new ArrayList<>();

    public static int getMonthlyFee(String plan) {

        if (plan.equalsIgnoreCase("Basic")) {
            return 500;

        } else if (plan.equalsIgnoreCase("Standard")) {
            return 800;

        } else if (plan.equalsIgnoreCase("Premium")) {
            return 1200;
        }

        return -1;
    }

    public static boolean memberExists(int memberId) {

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return true;
            }
        }

        return false;
    }

    public static void registerMember(Scanner sc) {

        System.out.println("\n===== REGISTER MEMBER =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        if (memberExists(memberId)) {

            System.out.println(
                    "Member ID already exists!");

            return;
        }

        System.out.print("Enter Member Name: ");
        String memberName = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print(
                "Enter Membership Plan (Basic/Standard/Premium): ");

        String membershipPlan = sc.nextLine();

        int monthlyFee =
                getMonthlyFee(membershipPlan);

        if (monthlyFee == -1) {

            System.out.println(
                    "Invalid membership plan!");

            return;
        }

        Member member = new Member(
                memberId,
                memberName,
                age,
                phoneNumber,
                membershipPlan,
                monthlyFee
        );

        members.add(member);

        System.out.println(
                "Member registered successfully!");
    }

    public static void viewAllMembers() {

        if (members.isEmpty()) {

            System.out.println(
                    "\nNo members registered.");

            return;
        }

        System.out.println(
                "\n===== ALL MEMBERS =====");

        for (Member member : members) {
            member.displayDetails();
        }
    }

    public static Member searchMember(Scanner sc) {

        System.out.print(
                "Enter Member ID: ");

        int memberId = sc.nextInt();
        sc.nextLine();

        for (Member member : members) {

            if (member.getMemberId() == memberId) {

                return member;
            }
        }

        return null;
    }

    public static void searchMemberMenu(Scanner sc) {

        System.out.println("\n===== SEARCH MEMBER =====");

        Member member = searchMember(sc);

        if (member != null) {

            System.out.println(
                    "\n===== MEMBER FOUND =====");

            member.displayDetails();

        } else {

            System.out.println(
                    "Member not found!");
        }
    }

    public static void updateMember(Scanner sc) {

        System.out.println("\n===== UPDATE MEMBER =====");

        Member member = searchMember(sc);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        System.out.println("\n1. Update Name");
        System.out.println("2. Update Phone Number");
        System.out.println("3. Update Membership Plan");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:

                System.out.print(
                        "Enter New Name: ");

                String newName = sc.nextLine();

                member.setMemberName(newName);

                System.out.println(
                        "Name updated successfully!");

                break;

            case 2:

                System.out.print(
                        "Enter New Phone Number: ");

                String newPhone = sc.nextLine();

                member.setPhoneNumber(newPhone);

                System.out.println(
                        "Phone number updated successfully!");

                break;

            case 3:

                System.out.print(
                        "Enter New Plan (Basic/Standard/Premium): ");

                String newPlan = sc.nextLine();

                int newFee =
                        getMonthlyFee(newPlan);

                if (newFee == -1) {

                    System.out.println(
                            "Invalid membership plan!");

                } else {

                    member.setMembershipPlan(
                            newPlan,
                            newFee
                    );

                    System.out.println(
                            "Membership plan updated successfully!");
                }

                break;

            default:

                System.out.println(
                        "Invalid choice!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\n===== GYM MEMBERSHIP SYSTEM =====");

            System.out.println("1. Register Member");
            System.out.println("2. View All Members");
            System.out.println("3. Search Member");
            System.out.println("4. Update Member");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerMember(sc);
                    break;

                case 2:
                    viewAllMembers();
                    break;

                case 3:
                    searchMemberMenu(sc);
                    break;

                case 4:
                    updateMember(sc);
                    break;

                case 5:

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