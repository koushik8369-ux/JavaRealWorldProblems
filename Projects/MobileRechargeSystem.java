import java.util.Scanner;

public class MobileRechargeSystem {

    static int transactionNumber = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MOBILE WALLET =====");

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.print("Enter Initial Wallet Balance: ");
        double walletBalance = sc.nextDouble();

        int successfulTransactions = 0;
        int failedTransactions = 0;
        double totalRechargeAmount = 0;

        while (true) {

            System.out.println();
            System.out.println("===== MOBILE WALLET =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Recharge Mobile");
            System.out.println("3. Transaction Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("Current Wallet Balance: ₹" + walletBalance);
                    break;

                case 2:

                    System.out.println();
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
                        totalRechargeAmount =
                                totalRechargeAmount + rechargeAmount;

                        successfulTransactions++;

                        System.out.println("Transaction ID: " + transactionId);
                        System.out.println("Status: SUCCESS");
                        System.out.println(
                                "Recharge Amount: ₹" + rechargeAmount);
                        System.out.println(
                                "Remaining Balance: ₹" + walletBalance);
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("========== TRANSACTION SUMMARY ==========");
                    System.out.println("Mobile Number: " + mobileNumber);
                    System.out.println(
                            "Successful Transactions: "
                                    + successfulTransactions);
                    System.out.println(
                            "Failed Transactions: "
                                    + failedTransactions);
                    System.out.println(
                            "Total Amount Recharged: ₹"
                                    + totalRechargeAmount);
                    System.out.println(
                            "Current Wallet Balance: ₹"
                                    + walletBalance);
                    System.out.println("==========================================");

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Mobile Recharge System!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}