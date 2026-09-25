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

    public static Member findMember(int memberId) {

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    public static void registerMember(Scanner sc) {

        System.out.println("\n===== REGISTER MEMBER =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        if (findMember(memberId) != null) {

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

    public static void searchMemberMenu(Scanner sc) {

        System.out.println("\n===== SEARCH MEMBER =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

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

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        System.out.println("1. Update Name");
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

                    System.out.println(
                            "New Monthly Fee: ₹" + newFee);
                }

                break;

            default:

                System.out.println(
                        "Invalid choice!");
        }
    }

    public static void renewMembership(Scanner sc) {

        System.out.println("\n===== RENEW MEMBERSHIP =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        System.out.print(
                "Enter number of months: ");

        int months = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        if (months <= 0) {

            System.out.println(
                    "Invalid number of months!");

            return;
        }

        int renewalAmount =
                member.getMonthlyFee() * months;

        member.renewMembership(months);

        System.out.println(
                "\n===== RENEWAL SUCCESSFUL =====");

        System.out.println(
                "Member: " + member.getMemberName());

        System.out.println(
                "Plan: " + member.getMembershipPlan());

        System.out.println(
                "Duration Added: " + months + " month(s)");

        System.out.println(
                "Renewal Amount: ₹" + renewalAmount);

        System.out.println(
                "Total Duration: "
                        + member.getMembershipMonths()
                        + " month(s)");
    }

    public static void markAttendance(Scanner sc) {

        System.out.println("\n===== MARK ATTENDANCE =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        System.out.print(
                "Did the member attend today? (yes/no): ");

        String attendance = sc.nextLine();

        if (attendance.equalsIgnoreCase("yes")) {

            member.markAttendance(true);

            System.out.println(
                    "Attendance marked successfully.");

        } else if (attendance.equalsIgnoreCase("no")) {

            member.markAttendance(false);

            System.out.println(
                    "Absent recorded.");

        } else {

            System.out.println(
                    "Invalid attendance input.");
        }
    }

    public static void viewAttendance(Scanner sc) {

        System.out.println(
                "\n===== ATTENDANCE SUMMARY =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        int absentDays =
                member.getTotalDays()
                        - member.getAttendedDays();

        System.out.println(
                "Member: " + member.getMemberName());

        System.out.println(
                "Total Days: " + member.getTotalDays());

        System.out.println(
                "Attended Days: "
                        + member.getAttendedDays());

        System.out.println(
                "Absent Days: " + absentDays);

        System.out.printf(
                "Attendance Percentage: %.2f%%%n",
                member.getAttendancePercentage());
    }

    public static void makePayment(Scanner sc) {

        System.out.println("\n===== MAKE PAYMENT =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        System.out.print("Enter Payment Amount: ₹");
        int amount = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        if (amount <= 0) {

            System.out.println(
                    "Invalid payment amount!");

            return;
        }

        System.out.print(
                "Enter Payment Type (UPI/Card/Cash): ");

        String paymentType = sc.nextLine();

        if (!(paymentType.equalsIgnoreCase("UPI")
                || paymentType.equalsIgnoreCase("Card")
                || paymentType.equalsIgnoreCase("Cash"))) {

            System.out.println(
                    "Invalid payment type!");

            return;
        }

        member.makePayment(amount);

        String paymentId =
                String.format(
                        "P%03d",
                        member.getPaymentCount());

        System.out.println(
                "\n===== PAYMENT SUCCESSFUL =====");

        System.out.println(
                "Payment ID: " + paymentId);

        System.out.println(
                "Member: " + member.getMemberName());

        System.out.println(
                "Amount Paid: ₹" + amount);

        System.out.println(
                "Payment Type: " + paymentType);

        System.out.println(
                "Payment Status: Successful");

        System.out.println(
                "Total Paid: ₹"
                        + member.getTotalPaid());
    }

    public static void viewPaymentSummary(Scanner sc) {

        System.out.println(
                "\n===== PAYMENT SUMMARY =====");

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = findMember(memberId);

        if (member == null) {

            System.out.println(
                    "Member not found!");

            return;
        }

        System.out.println(
                "Member: " + member.getMemberName());

        System.out.println(
                "Payments Made: "
                        + member.getPaymentCount());

        System.out.println(
                "Total Amount Paid: ₹"
                        + member.getTotalPaid());
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
            System.out.println("5. Renew Membership");
            System.out.println("6. Mark Attendance");
            System.out.println("7. View Attendance");
            System.out.println("8. Make Payment");
            System.out.println("9. View Payment Summary");
            System.out.println("10. Exit");

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
                    renewMembership(sc);
                    break;

                case 6:
                    markAttendance(sc);
                    break;

                case 7:
                    viewAttendance(sc);
                    break;

                case 8:
                    makePayment(sc);
                    break;

                case 9:
                    viewPaymentSummary(sc);
                    break;

                case 10:

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