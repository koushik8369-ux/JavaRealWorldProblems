import java.util.Scanner;

public class MobileRechargeSystem {

    static int transactionNumber = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MOBILE RECHARGE SYSTEM =====");

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.print("Enter Wallet Balance: ");
        double walletBalance = sc.nextDouble();

        System.out.print("Enter Recharge Amount: ");
        double rechargeAmount = sc.nextDouble();

        String transactionId = "TXN" + transactionNumber;
        transactionNumber++;

        System.out.println();

        if (rechargeAmount <= 0) {

            System.out.println("========== TRANSACTION RECEIPT ==========");
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Recharge Amount: ₹" + rechargeAmount);
            System.out.println("Status: FAILED");
            System.out.println("Reason: Invalid Recharge Amount");
            System.out.println("=========================================");

        } else if (rechargeAmount > walletBalance) {

            System.out.println("========== TRANSACTION RECEIPT ==========");
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Recharge Amount: ₹" + rechargeAmount);
            System.out.println("Status: FAILED");
            System.out.println("Reason: Insufficient Wallet Balance");
            System.out.println("=========================================");

        } else {

            walletBalance = walletBalance - rechargeAmount;

            System.out.println("========== TRANSACTION RECEIPT ==========");
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Recharge Amount: ₹" + rechargeAmount);
            System.out.println("Status: SUCCESS");
            System.out.println("Remaining Wallet Balance: ₹" + walletBalance);
            System.out.println("=========================================");
        }

        sc.close();
    }
}