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

        System.out.print("Enter Number of Transactions: ");
        int numberOfTransactions = sc.nextInt();

        int successfulTransactions = 0;
        int failedTransactions = 0;

        for (int i = 1; i <= numberOfTransactions; i++) {

            System.out.println();
            System.out.println("----- Transaction " + i + " -----");

            System.out.print("Enter Recharge Amount: ");
            double rechargeAmount = sc.nextDouble();

            String transactionId = "TXN" + transactionNumber;
            transactionNumber++;

            if (rechargeAmount <= 0) {

                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Status: FAILED");
                System.out.println("Reason: Invalid Recharge Amount");

                failedTransactions++;

            } else if (rechargeAmount > walletBalance) {

                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Status: FAILED");
                System.out.println("Reason: Insufficient Wallet Balance");

                failedTransactions++;

            } else {

                walletBalance = walletBalance - rechargeAmount;

                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Status: SUCCESS");
                System.out.println("Recharge Amount: ₹" + rechargeAmount);
                System.out.println("Remaining Balance: ₹" + walletBalance);

                successfulTransactions++;
            }
        }

        System.out.println();
        System.out.println("========== SUMMARY ==========");
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Successful Transactions: " + successfulTransactions);
        System.out.println("Failed Transactions: " + failedTransactions);
        System.out.println("Final Wallet Balance: ₹" + walletBalance);
        System.out.println("==============================");

        sc.close();
    }
}