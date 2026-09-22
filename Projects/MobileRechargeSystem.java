import java.util.Scanner;

public class MobileRechargeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MOBILE RECHARGE SYSTEM =====");

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.print("Enter Wallet Balance: ");
        double walletBalance = sc.nextDouble();

        System.out.print("Enter Recharge Amount: ");
        double rechargeAmount = sc.nextDouble();

        System.out.println();

        if (rechargeAmount <= 0) {

            System.out.println("Invalid Recharge Amount!");

        } else if (rechargeAmount > walletBalance) {

            System.out.println("Insufficient Wallet Balance!");
            System.out.println("Recharge Failed.");

        } else {

            walletBalance = walletBalance - rechargeAmount;

            System.out.println("Recharge Successful!");
            System.out.println("----------------------------");
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Recharge Amount: ₹" + rechargeAmount);
            System.out.println("Remaining Balance: ₹" + walletBalance);
            System.out.println("----------------------------");
        }

        sc.close();
    }
}