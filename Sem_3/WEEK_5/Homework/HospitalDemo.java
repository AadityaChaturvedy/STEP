package Homework;

import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId, patientDNA, bloodType;
    private final String[] allergies, medicalHistory;
    private final LocalDate birthDate;

    public MedicalRecord(String recId, String dna, String[] allg, String[] hist, LocalDate birth, String blood) {
        if(recId == null || dna==null || birth==null || allg==null || hist==null || blood==null)
            throw new IllegalArgumentException("Data incomplete/HIPAA not met");
        recordId = recId; patientDNA = dna;
        allergies = allg.clone(); medicalHistory = hist.clone();
        birthDate = birth; bloodType = blood;
    }
    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }
    public final boolean isAllergicTo(String sub) {
        for (String s : allergies) if (s.equalsIgnoreCase(sub)) return true;
        return false;
    }
    public String toString() { return "[MedicalRecord:" + recordId + ", DOB:" + birthDate + "]"; }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName, emergencyContact, insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;
    Patient(String id, MedicalRecord m) { // Emergency (minimal)
        this(id, m, "Temp", "", "", 0, "");
    }
    Patient(String id, MedicalRecord m, String name, String emer, String ins, int room, String doc) {
        if(id==null||m==null) throw new IllegalArgumentException("Privacy fail!");
        patientId = id; medicalRecord = m; currentName = name; emergencyContact = emer;
        insuranceInfo = ins; roomNumber = room; attendingPhysician = doc;
    }
    // Transfer admission
    Patient(String id, MedicalRecord m, String name) {
        this(id, m, name, "", "", 0, "");
    }
    public String getCurrentName() { return currentName; }
    public void setCurrentName(String n) { this.currentName = n; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String c) { this.emergencyContact = c; }
    public String getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(String i) { this.insuranceInfo = i; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int r) { roomNumber = r; }
    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String a) { attendingPhysician = a; }
    String getBasicInfo() { return "PatientID:" + patientId + ", Name:" + currentName + ", Room:" + roomNumber; }
    public String getPublicInfo() { return "Name:" + currentName + ", Room:" + roomNumber; }
    public String toString() { return "Patient[" + patientId + ", Name:" + currentName + ", Audit:" + new Date() + "]"; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
}

class Doctor {
    private final String licenseNumber, specialty;
    private final Set<String> certifications;
    public Doctor(String lic, String spec, Set<String> certs) {
        licenseNumber = lic; specialty = spec; certifications = Set.copyOf(certs);
    }
    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
}

class Nurse {
    private final String nurseId, shift;
    private final List<String> qualifications;
    public Nurse(String id, String shift, List<String> q) {
        nurseId = id; this.shift = shift; qualifications = List.copyOf(q);
    }
    public String getNurseId() { return nurseId; }
    public String getShift() { return shift; }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;
    public Administrator(String id, List<String> perms) {
        adminId = id; accessPermissions = List.copyOf(perms);
    }
    public String getAdminId() { return adminId; }
}

class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();
    public static final String POLICY_PRIVACY = "STRICT";
    boolean admitPatient(Object pat, Object staff) {
        if(validateStaffAccess(staff, pat)) {
            patientRegistry.put(((Patient)pat).getBasicInfo(), pat);
            return true;
        }
        return false;
    }
    private boolean validateStaffAccess(Object s, Object p) {
        // Only Doctor or Nurse can admit a Patient (basic demo privacy logic)
        return (s instanceof Doctor || s instanceof Nurse) && p instanceof Patient;
    }
    String getPatientPublicInfo(String id) {
        Patient p = (Patient)patientRegistry.get(id);
        return p != null ? p.getPublicInfo() : "Not found";
    }
    String getPatientRegistryAudit() {
        return "Registry: " + patientRegistry.keySet();
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalRecord rec = new MedicalRecord("R1", "DNA1234", new String[]{"Penicillin"}, new String[]{"Asthma"}, LocalDate.of(1990,1,1), "O+");
        Patient p = new Patient("P1", rec, "Alice", "Bob", "InsuranceX", 401, "Dr. Smith");
        Doctor d = new Doctor("LIC2021", "Cardiology", Set.of("BLS","ACLS"));
        Nurse n = new Nurse("N1001", "Night", List.of("RN"));
        HospitalSystem hs = new HospitalSystem();
        hs.admitPatient(p, d); // Doctor admits patient
        System.out.println(hs.getPatientPublicInfo(p.getBasicInfo()));
        System.out.println(rec.isAllergicTo("penicillin")); // true
        System.out.println(p);
        System.out.println(hs.getPatientRegistryAudit());
    }
}

