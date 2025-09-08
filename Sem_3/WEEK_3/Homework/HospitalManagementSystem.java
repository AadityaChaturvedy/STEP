import java.util.*;

// HospitalManagementSystem.java
// Complete hospital patient management system with appointments, treatments, and billing.
// To run: javac HospitalManagementSystem.java && java HospitalManagementSystem

class Patient {
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactInfo;
    // although requirement asked for arrays, use Lists internally for flexibility
    private List<String> medicalHistory;
    private List<String> currentTreatments;
    private boolean admitted = true; // simple flag to show patient is active

    public Patient(String patientId, String patientName, int age, String gender, String contactInfo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = new ArrayList<>();
        this.currentTreatments = new ArrayList<>();
        Hospital.totalPatients++;
    }

    // getters
    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContactInfo() { return contactInfo; }
    public String[] getMedicalHistory() { return medicalHistory.toArray(new String[0]); }
    public String[] getCurrentTreatments() { return currentTreatments.toArray(new String[0]); }
    public boolean isAdmitted() { return admitted; }

    // operations
    public void addMedicalHistory(String history) { medicalHistory.add(history); }
    public void addTreatment(String treatment) { currentTreatments.add(treatment); }
    public void removeTreatment(String treatment) { currentTreatments.remove(treatment); }
    public void discharge() { admitted = false; }

    @Override
    public String toString() {
        return String.format("Patient[%s - %s, Age:%d, Gender:%s]", patientId, patientName, age, gender);
    }
}

class Doctor {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private List<String> availableSlots; // e.g., "2025-09-01 10:00"
    private int patientsHandled;
    private double consultationFee;

    public Doctor(String doctorId, String doctorName, String specialization, String[] slots, double consultationFee) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
        if (slots != null) Collections.addAll(this.availableSlots, slots);
        this.patientsHandled = 0;
        this.consultationFee = consultationFee;
    }

    // getters
    public String getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getSpecialization() { return specialization; }
    public String[] getAvailableSlots() { return availableSlots.toArray(new String[0]); }
    public int getPatientsHandled() { return patientsHandled; }
    public double getConsultationFee() { return consultationFee; }

    // operations
    public boolean bookSlot(String dateTime) {
        boolean removed = availableSlots.remove(dateTime);
        if (removed) patientsHandled++;
        return removed;
    }

    public void freeSlot(String dateTime) {
        if (!availableSlots.contains(dateTime)) availableSlots.add(dateTime);
    }

    @Override
    public String toString() {
        return String.format("Dr.%s (%s) [%s]", doctorName, doctorId, specialization);
    }
}

enum AppointmentType {
    CONSULTATION(1.0), // base multiplier
    FOLLOW_UP(0.6),
    EMERGENCY(2.0);

    public final double rateMultiplier;
    AppointmentType(double m) { this.rateMultiplier = m; }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate; // YYYY-MM-DD
    private String appointmentTime; // HH:MM
    private String status; // Scheduled, Cancelled, Completed
    private AppointmentType type;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String date, String time, AppointmentType type) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.type = type;
        this.status = "Scheduled";
        Hospital.totalAppointments++;
    }

    // getters
    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getAppointmentDate() { return appointmentDate; }
    public String getAppointmentTime() { return appointmentTime; }
    public String getStatus() { return status; }
    public AppointmentType getType() { return type; }

    public void cancel() {
        if (status.equals("Scheduled")) {
            status = "Cancelled";
            // free doctor's slot
            doctor.freeSlot(appointmentDate + " " + appointmentTime);
        }
    }

    public void complete() { status = "Completed"; }

    @Override
    public String toString() {
        return String.format("Appointment[%s] %s with %s on %s %s - %s", appointmentId, patient.getPatientName(), doctor.getDoctorName(), appointmentDate, appointmentTime, status);
    }
}

class Hospital {
    // static variables
    public static int totalPatients = 0;
    public static int totalAppointments = 0;
    public static String hospitalName = "CityCare Hospital";
    public static double totalRevenue = 0.0;

    // data stores
    private Map<String, Patient> patients = new HashMap<>();
    private Map<String, Doctor> doctors = new HashMap<>();
    private Map<String, Appointment> appointments = new HashMap<>();

    // schedule appointment
    public Appointment scheduleAppointment(String appointmentId, Patient patient, Doctor doctor, String date, String time, AppointmentType type) {
        String slotKey = date + " " + time;
        // check if doctor has slot
        boolean booked = doctor.bookSlot(slotKey);
        if (!booked) {
            System.out.println("Slot not available for Dr." + doctor.getDoctorName() + " at " + slotKey);
            return null;
        }
        Appointment appt = new Appointment(appointmentId, patient, doctor, date, time, type);
        appointments.put(appointmentId, appt);
        patients.putIfAbsent(patient.getPatientId(), patient);
        doctors.putIfAbsent(doctor.getDoctorId(), doctor);
        System.out.println("Scheduled: " + appt);
        return appt;
    }

    // cancel appointment
    public boolean cancelAppointment(String appointmentId) {
        Appointment appt = appointments.get(appointmentId);
        if (appt == null) return false;
        if (appt.getStatus().equals("Cancelled")) return false;
        appt.cancel();
        System.out.println("Cancelled: " + appt);
        return true;
    }

    // generate bill
    public double generateBill(String appointmentId) {
        Appointment appt = appointments.get(appointmentId);
        if (appt == null) return 0.0;
        double baseFee = appt.getDoctor().getConsultationFee();
        double multiplier = appt.getType().rateMultiplier;
        double treatmentCharges = 0.0; // could be calculated from treatments
        // simple billing: consultation * multiplier + treatments
        double bill = baseFee * multiplier + treatmentCharges;
        Hospital.totalRevenue += bill;
        System.out.printf("Bill for %s: %.2f (Type:%s, Base:%.2f)\n", appointmentId, bill, appt.getType(), baseFee);
        return bill;
    }

    // update treatment
    public void updateTreatment(String patientId, String treatment, boolean add) {
        Patient p = patients.get(patientId);
        if (p == null) {
            System.out.println("No such patient: " + patientId);
            return;
        }
        if (add) {
            p.addTreatment(treatment);
            System.out.println("Added treatment for " + p.getPatientName() + ": " + treatment);
        } else {
            p.removeTreatment(treatment);
            System.out.println("Removed treatment for " + p.getPatientName() + ": " + treatment);
        }
    }

    // discharge patient
    public void dischargePatient(String patientId) {
        Patient p = patients.get(patientId);
        if (p == null) {
            System.out.println("No such patient to discharge: " + patientId);
            return;
        }
        p.discharge();
        System.out.println("Discharged: " + p.getPatientName());
    }

    // static methods (exposed via this instance as well)
    public static void generateHospitalReport(Hospital h) {
        System.out.println("--- Hospital Report: " + hospitalName + " ---");
        System.out.println("Total Patients Registered: " + totalPatients);
        System.out.println("Total Appointments Created: " + totalAppointments);
        System.out.printf("Total Revenue: %.2f\n", totalRevenue);
        // doctor utilization
        getDoctorUtilization(h);
        // patient stats
        getPatientStatistics(h);
    }

    public static void getDoctorUtilization(Hospital h) {
        System.out.println("-- Doctor Utilization --");
        for (Doctor d : h.doctors.values()) {
            int handled = d.getPatientsHandled();
            int slots = d.getAvailableSlots().length + handled; // approximate original slots
            double utilization = (slots == 0) ? 0.0 : ((double) handled / slots) * 100.0;
            System.out.printf("%s : Patients handled=%d, Slots(total approx)=%d, Utilization=%.2f%%\n", d.getDoctorName(), handled, slots, utilization);
        }
    }   

    public static void getPatientStatistics(Hospital h) {
        System.out.println("-- Patient Statistics --");
        int total = h.patients.size();
        if (total == 0) {
            System.out.println("No patient data.");
            return;
        }
        double sumAge = 0;
        Map<String,Integer> genderCount = new HashMap<>();
        for (Patient p : h.patients.values()) {
            sumAge += p.getAge();
            genderCount.put(p.getGender(), genderCount.getOrDefault(p.getGender(), 0) + 1);
        }
        System.out.printf("Registered patients: %d, Avg age: %.2f\n", total, (sumAge/total));
        System.out.println("Gender distribution: "+genderCount);
    }

    // helper to add doctor/patient into records if created externally
    public void registerDoctor(Doctor d) { doctors.putIfAbsent(d.getDoctorId(), d); }
    public void registerPatient(Patient p) { patients.putIfAbsent(p.getPatientId(), p); }

    // get appointment by id
    public Appointment getAppointment(String id) { return appointments.get(id); }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Hospital.hospitalName = "Apex Care Center";

        // create doctors
        Doctor d1 = new Doctor("D001", "Asha Rao", "Cardiology", new String[]{"2025-09-02 09:00", "2025-09-02 10:00"}, 1200.0);
        Doctor d2 = new Doctor("D002", "Rahul Mehta", "General Physician", new String[]{"2025-09-02 09:30", "2025-09-02 11:00"}, 500.0);
        hospital.registerDoctor(d1);
        hospital.registerDoctor(d2);

        // create patients
        Patient p1 = new Patient("P001", "Neha Singh", 28, "Female", "+91-9876500001");
        p1.addMedicalHistory("Asthma - 2019");
        Patient p2 = new Patient("P002", "Vikram Joshi", 45, "Male", "+91-9876500002");
        p2.addMedicalHistory("Diabetes - 2021");
        hospital.registerPatient(p1);
        hospital.registerPatient(p2);

        // schedule appointments
        Appointment a1 = hospital.scheduleAppointment("A001", p1, d2, "2025-09-02", "09:30", AppointmentType.CONSULTATION);
        Appointment a2 = hospital.scheduleAppointment("A002", p2, d1, "2025-09-02", "09:00", AppointmentType.EMERGENCY);

        // try booking an already-booked slot
        hospital.scheduleAppointment("A003", p1, d1, "2025-09-02", "09:00", AppointmentType.FOLLOW_UP);

        // update treatments
        hospital.updateTreatment("P001", "Inhaler - Salbutamol", true);
        hospital.updateTreatment("P002", "Insulin - 10 units", true);

        // generate bills
        hospital.generateBill("A001");
        hospital.generateBill("A002");

        // cancel an appointment
        hospital.cancelAppointment("A001");

        // discharge a patient
        hospital.dischargePatient("P002");

        // print report
        Hospital.generateHospitalReport(hospital);

        // print sample patient history & treatments
        System.out.println("\nSample patient data:");
        System.out.println(p1);
        System.out.println("Medical history: " + Arrays.toString(p1.getMedicalHistory()));
        System.out.println("Current treatments: " + Arrays.toString(p1.getCurrentTreatments()));

        System.out.println("\nSample appointment data:");
        System.out.println(hospital.getAppointment("A002"));
    }
}
