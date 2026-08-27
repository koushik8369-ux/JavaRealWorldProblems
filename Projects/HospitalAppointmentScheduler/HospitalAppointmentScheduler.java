import java.util.Scanner;

public class HospitalAppointmentScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String patientName = "";
        int patientAge = 0;
        String doctorName = "";
        String appointmentTime = "";

        int choice;

        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("     HOSPITAL APPOINTMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointment");
            System.out.println("3. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter patient name: ");
                    patientName = sc.nextLine();

                    System.out.print("Enter patient age: ");
                    patientAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter doctor name: ");
                    doctorName = sc.nextLine();

                    System.out.print("Enter appointment time: ");
                    appointmentTime = sc.nextLine();

                    if (patientName.trim().isEmpty()) {
                        System.out.println("Invalid patient name.");
                    } else if (patientAge <= 0) {
                        System.out.println("Invalid patient age.");
                    } else if (doctorName.trim().isEmpty()) {
                        System.out.println("Invalid doctor name.");
                    } else if (appointmentTime.trim().isEmpty()) {
                        System.out.println("Invalid appointment time.");
                    } else {
                        System.out.println();
                        System.out.println("Appointment booked successfully!");
                    }

                    break;

                case 2:

                    if (patientName.isEmpty()) {

                        System.out.println();
                        System.out.println("No appointment found.");

                    } else {

                        System.out.println();
                        System.out.println("========================================");
                        System.out.println("        APPOINTMENT DETAILS");
                        System.out.println("========================================");
                        System.out.println("Patient Name : " + patientName);
                        System.out.println("Patient Age  : " + patientAge);
                        System.out.println("Doctor Name  : " + doctorName);
                        System.out.println("Time         : " + appointmentTime);
                        System.out.println("Status       : BOOKED");
                        System.out.println("========================================");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("Thank you for using the system.");
                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}