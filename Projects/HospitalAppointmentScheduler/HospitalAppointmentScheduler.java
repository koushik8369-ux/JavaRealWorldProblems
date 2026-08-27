import java.util.ArrayList;
import java.util.Scanner;

class Patient {

    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    public Doctor(int doctorId, String name,
                  String specialization, double consultationFee) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}

class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentTime;
    private String status;

    public Appointment(int appointmentId,
                       Patient patient,
                       Doctor doctor,
                       String appointmentTime) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentTime = appointmentTime;
        this.status = "BOOKED";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void cancelAppointment() {
        if (status.equals("BOOKED")) {
            status = "CANCELLED";
        }
    }

    public void reschedule(String newTime) {
        if (status.equals("BOOKED")) {
            appointmentTime = newTime;
        }
    }

    public void displayAppointment() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("        APPOINTMENT DETAILS");
        System.out.println("========================================");

        System.out.println("Appointment ID : " + appointmentId);

        System.out.println("----------------------------------------");

        System.out.println("Patient ID     : " + patient.getPatientId());
        System.out.println("Patient Name   : " + patient.getName());
        System.out.println("Patient Age    : " + patient.getAge());

        System.out.println("----------------------------------------");

        System.out.println("Doctor ID      : " + doctor.getDoctorId());
        System.out.println("Doctor Name    : " + doctor.getName());
        System.out.println("Specialization : " + doctor.getSpecialization());

        System.out.printf(
                "Consultation   : ₹%.2f%n",
                doctor.getConsultationFee()
        );

        System.out.println("----------------------------------------");

        System.out.println("Appointment Time : " + appointmentTime);
        System.out.println("Status           : " + status);

        System.out.println("========================================");
    }
}

public class HospitalAppointmentScheduler {

    private static final ArrayList<Appointment> appointments =
            new ArrayList<>();

    private static int nextAppointmentId = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            displayMenu();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    bookAppointment(sc);
                    break;

                case 2:
                    viewAllAppointments();
                    break;

                case 3:
                    searchAppointment(sc);
                    break;

                case 4:
                    rescheduleAppointment(sc);
                    break;

                case 5:
                    cancelAppointment(sc);
                    break;

                case 6:
                    displaySummary();
                    break;

                case 7:
                    System.out.println();
                    System.out.println(
                            "Thank you for using the Hospital Appointment Scheduler."
                    );
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 7);

        sc.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("   HOSPITAL APPOINTMENT SCHEDULER");
        System.out.println("========================================");
        System.out.println("1. Book Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Search Appointment");
        System.out.println("4. Reschedule Appointment");
        System.out.println("5. Cancel Appointment");
        System.out.println("6. Appointment Summary");
        System.out.println("7. Exit");
        System.out.println("========================================");
    }

    private static void bookAppointment(Scanner sc) {

        System.out.println();
        System.out.println("========== BOOK APPOINTMENT ==========");

        System.out.print("Enter patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter patient name: ");
        String patientName = sc.nextLine();

        System.out.print("Enter patient age: ");
        int patientAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter doctor name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Enter consultation fee: ");
        double consultationFee = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter appointment time: ");
        String appointmentTime = sc.nextLine();

        if (patientId <= 0) {
            System.out.println("Invalid patient ID.");
            return;
        }

        if (patientName.trim().isEmpty()) {
            System.out.println("Patient name cannot be empty.");
            return;
        }

        if (patientAge <= 0) {
            System.out.println("Invalid patient age.");
            return;
        }

        if (doctorId <= 0) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        if (doctorName.trim().isEmpty()) {
            System.out.println("Doctor name cannot be empty.");
            return;
        }

        if (specialization.trim().isEmpty()) {
            System.out.println("Specialization cannot be empty.");
            return;
        }

        if (consultationFee <= 0) {
            System.out.println("Invalid consultation fee.");
            return;
        }

        if (appointmentTime.trim().isEmpty()) {
            System.out.println("Appointment time cannot be empty.");
            return;
        }

        Patient patient = new Patient(
                patientId,
                patientName,
                patientAge
        );

        Doctor doctor = new Doctor(
                doctorId,
                doctorName,
                specialization,
                consultationFee
        );

        Appointment appointment = new Appointment(
                nextAppointmentId,
                patient,
                doctor,
                appointmentTime
        );

        appointments.add(appointment);

        System.out.println();
        System.out.println("Appointment booked successfully!");
        System.out.println("Appointment ID: " + nextAppointmentId);

        nextAppointmentId++;
    }

    private static void viewAllAppointments() {

        if (appointments.isEmpty()) {
            System.out.println();
            System.out.println("No appointments found.");
            return;
        }

        System.out.println();
        System.out.println("========== ALL APPOINTMENTS ==========");

        for (Appointment appointment : appointments) {
            appointment.displayAppointment();
        }
    }

    private static void searchAppointment(Scanner sc) {

        System.out.print("Enter appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId() == id) {

                appointment.displayAppointment();
                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    private static void rescheduleAppointment(Scanner sc) {

        System.out.print("Enter appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId() == id) {

                if (appointment.getStatus().equals("CANCELLED")) {
                    System.out.println(
                            "Cancelled appointments cannot be rescheduled."
                    );
                    return;
                }

                System.out.print("Enter new appointment time: ");
                String newTime = sc.nextLine();

                if (newTime.trim().isEmpty()) {
                    System.out.println("Appointment time cannot be empty.");
                    return;
                }

                appointment.reschedule(newTime);

                System.out.println(
                        "Appointment rescheduled successfully."
                );

                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    private static void cancelAppointment(Scanner sc) {

        System.out.print("Enter appointment ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Appointment appointment : appointments) {

            if (appointment.getAppointmentId() == id) {

                if (appointment.getStatus().equals("CANCELLED")) {
                    System.out.println(
                            "Appointment is already cancelled."
                    );
                    return;
                }

                appointment.cancelAppointment();

                System.out.println(
                        "Appointment cancelled successfully."
                );

                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    private static void displaySummary() {

        int booked = 0;
        int cancelled = 0;

        for (Appointment appointment : appointments) {

            if (appointment.getStatus().equals("BOOKED")) {
                booked++;
            } else if (appointment.getStatus().equals("CANCELLED")) {
                cancelled++;
            }
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("       APPOINTMENT SUMMARY");
        System.out.println("========================================");
        System.out.println("Total Appointments : " + appointments.size());
        System.out.println("Booked             : " + booked);
        System.out.println("Cancelled          : " + cancelled);
        System.out.println("========================================");
    }
}