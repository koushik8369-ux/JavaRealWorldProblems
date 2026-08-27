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

    public void cancelAppointment() {
        status = "CANCELLED";
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient patient = null;
        Doctor doctor = null;
        Appointment appointment = null;

        int appointmentId = 1001;
        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("   HOSPITAL APPOINTMENT SCHEDULER");
            System.out.println("========================================");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointment");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

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

                    } else if (patientName.trim().isEmpty()) {

                        System.out.println("Patient name cannot be empty.");

                    } else if (patientAge <= 0) {

                        System.out.println("Invalid patient age.");

                    } else if (doctorId <= 0) {

                        System.out.println("Invalid doctor ID.");

                    } else if (doctorName.trim().isEmpty()) {

                        System.out.println("Doctor name cannot be empty.");

                    } else if (specialization.trim().isEmpty()) {

                        System.out.println("Specialization cannot be empty.");

                    } else if (consultationFee <= 0) {

                        System.out.println("Invalid consultation fee.");

                    } else if (appointmentTime.trim().isEmpty()) {

                        System.out.println("Appointment time cannot be empty.");

                    } else {

                        patient = new Patient(
                                patientId,
                                patientName,
                                patientAge
                        );

                        doctor = new Doctor(
                                doctorId,
                                doctorName,
                                specialization,
                                consultationFee
                        );

                        appointment = new Appointment(
                                appointmentId,
                                patient,
                                doctor,
                                appointmentTime
                        );

                        System.out.println();
                        System.out.println(
                                "Appointment booked successfully!"
                        );

                        System.out.println(
                                "Appointment ID: " + appointmentId
                        );

                        appointmentId++;
                    }

                    break;

                case 2:

                    if (appointment == null) {

                        System.out.println("No appointment found.");

                    } else {

                        appointment.displayAppointment();
                    }

                    break;

                case 3:

                    if (appointment == null) {

                        System.out.println("No appointment found.");

                    } else {

                        appointment.cancelAppointment();

                        System.out.println(
                                "Appointment cancelled successfully."
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                            "Thank you for using the system."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 4);

        sc.close();
    }
}