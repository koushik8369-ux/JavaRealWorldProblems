import java.util.Scanner;

public class GymMembershipSystem {

    static int memberId;
    static String memberName;
    static int age;
    static String phoneNumber;
    static String membershipPlan;
    static int monthlyFee;

    static int membershipMonths = 0;
    static int totalRenewalAmount = 0;

    static int totalDays = 0;
    static int attendedDays = 0;

    static int paymentCounter = 1;
    static int totalPaid = 0;

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

        membershipMonths = 0;
        totalRenewalAmount = 0;
        totalDays = 0;
        attendedDays = 0;
        totalPaid = 0;
        paymentCounter = 1;

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

        System.out.println(
                "Membership Duration: "
                        + membershipMonths + " month(s)");

        System.out.println(
                "Total Paid: ₹" + totalPaid);
    }

    public static void checkMembershipFee() {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== MEMBERSHIP FEE =====");

        System.out.println("Plan: " + membershipPlan);
        System.out.println("Monthly Fee: ₹" + monthlyFee);
    }

    public static void renewMembership(Scanner sc) {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== RENEW MEMBERSHIP =====");

        System.out.print(
                "Enter number of months to renew: ");

        int renewalMonths = sc.nextInt();
        sc.nextLine();

        if (renewalMonths <= 0) {

            System.out.println(
                    "Invalid number of months!");

            return;
        }

        int renewalAmount =
                monthlyFee * renewalMonths;

        membershipMonths += renewalMonths;
        totalRenewalAmount += renewalAmount;

        System.out.println(
                "\n===== RENEWAL SUCCESSFUL =====");

        System.out.println(
                "Plan: " + membershipPlan);

        System.out.println(
                "Duration: " + renewalMonths + " month(s)");

        System.out.println(
                "Monthly Fee: ₹" + monthlyFee);

        System.out.println(
                "Renewal Amount: ₹" + renewalAmount);

        System.out.println(
                "Total Membership Duration: "
                        + membershipMonths + " month(s)");
    }

    public static void markAttendance(Scanner sc) {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== MARK ATTENDANCE =====");

        System.out.print(
                "Did the member attend today? (yes/no): ");

        String attendance = sc.nextLine();

        if (attendance.equalsIgnoreCase("yes")) {

            totalDays++;
            attendedDays++;

            System.out.println(
                    "Attendance marked successfully.");

        } else if (attendance.equalsIgnoreCase("no")) {

            totalDays++;

            System.out.println(
                    "Absent recorded.");

        } else {

            System.out.println(
                    "Invalid attendance input.");
        }
    }

    public static void viewAttendance() {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== ATTENDANCE SUMMARY =====");

        System.out.println(
                "Total Days: " + totalDays);

        System.out.println(
                "Attended Days: " + attendedDays);

        System.out.println(
                "Absent Days: " + (totalDays - attendedDays));

        if (totalDays > 0) {

            double percentage =
                    ((double) attendedDays / totalDays) * 100;

            System.out.printf(
                    "Attendance Percentage: %.2f%%%n",
                    percentage);

        } else {

            System.out.println(
                    "Attendance Percentage: 0.00%");
        }
    }

    public static void makePayment(Scanner sc) {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println("\n===== MAKE PAYMENT =====");

        System.out.print("Enter Payment Amount: ₹");
        int paymentAmount = sc.nextInt();
        sc.nextLine();

        if (paymentAmount <= 0) {

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

        String paymentId =
                String.format("P%03d", paymentCounter);

        paymentCounter++;

        totalPaid += paymentAmount;

        System.out.println(
                "\n===== PAYMENT SUCCESSFUL =====");

        System.out.println(
                "Payment ID: " + paymentId);

        System.out.println(
                "Amount Paid: ₹" + paymentAmount);

        System.out.println(
                "Payment Type: " + paymentType);

        System.out.println(
                "Payment Status: Successful");

        System.out.println(
                "Total Paid: ₹" + totalPaid);
    }

    public static void viewPaymentSummary() {

        if (!memberRegistered) {

            System.out.println(
                    "\nNo member registered yet.");

            return;
        }

        System.out.println(
                "\n===== PAYMENT SUMMARY =====");

        System.out.println(
                "Member: " + memberName);

        System.out.println(
                "Total Amount Paid: ₹" + totalPaid);

        System.out.println(
                "Payments Made: " + (paymentCounter - 1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\n===== GYM MEMBERSHIP SYSTEM =====");

            System.out.println("1. Register Member");
            System.out.println("2. View Member Details");
            System.out.println("3. Check Membership Fee");
            System.out.println("4. Renew Membership");
            System.out.println("5. Mark Attendance");
            System.out.println("6. View Attendance");
            System.out.println("7. Make Payment");
            System.out.println("8. View Payment Summary");
            System.out.println("9. Exit");

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
                    renewMembership(sc);
                    break;

                case 5:
                    markAttendance(sc);
                    break;

                case 6:
                    viewAttendance();
                    break;

                case 7:
                    makePayment(sc);
                    break;

                case 8:
                    viewPaymentSummary();
                    break;

                case 9:

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