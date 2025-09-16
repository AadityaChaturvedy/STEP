import java.time.LocalDate;
import java.util.*;

public class HospitalManagementSystem {

    // ---------- Immutable MedicalRecord ----------
    public static final class MedicalRecord {
        private final String recordId;
        private final String patientDNA;
        private final String[] allergies;
        private final String[] medicalHistory;
        private final LocalDate birthDate;
        private final String bloodType;

        public MedicalRecord(String recordId,
                             String patientDNA,
                             String[] allergies,
                             String[] medicalHistory,
                             LocalDate birthDate,
                             String bloodType) {
            if (recordId == null || recordId.isBlank())
                throw new IllegalArgumentException("recordId required");
            if (patientDNA == null || patientDNA.isBlank())
                throw new IllegalArgumentException("patientDNA required");
            if (birthDate == null)
                throw new IllegalArgumentException("birthDate required");
            if (bloodType == null || bloodType.isBlank())
                throw new IllegalArgumentException("bloodType required");

            this.recordId = recordId;
            this.patientDNA = patientDNA;
            this.allergies = (allergies == null) ? new String[0] : allergies.clone();
            this.medicalHistory = (medicalHistory == null) ? new String[0] : medicalHistory.clone();
            this.birthDate = birthDate;
            this.bloodType = bloodType;
        }

        public String getRecordId() { return recordId; }
        public String getPatientDNA() { return patientDNA; }
        public String[] getAllergies() { return allergies.clone(); }
        public String[] getMedicalHistory() { return medicalHistory.clone(); }
        public LocalDate getBirthDate() { return birthDate; }
        public String getBloodType() { return bloodType; }

        public final boolean isAllergicTo(String substance) {
            if (substance == null) return false;
            for (String a : allergies) if (a.equalsIgnoreCase(substance)) return true;
            return false;
        }

        @Override
        public String toString() { return "MedicalRecord[" + recordId + ", bloodType=" + bloodType + "]"; }
    }

    // ---------- Patient ----------
    public static class Patient {
        private final String patientId;
        private final MedicalRecord medicalRecord;

        private String currentName;
        private String emergencyContact;
        private String insuranceInfo;

        private int roomNumber;
        private String attendingPhysician;

        public Patient(String currentName, String emergencyContact) {
            this(generateTempId(), null, currentName, emergencyContact, null, -1, "Triage");
        }

        public Patient(String patientId,
                       MedicalRecord medicalRecord,
                       String currentName,
                       String emergencyContact,
                       String insuranceInfo,
                       int roomNumber,
                       String attendingPhysician) {
            if (patientId == null || patientId.isBlank()) throw new IllegalArgumentException("patientId");
            if (currentName == null || currentName.isBlank()) throw new IllegalArgumentException("Name required");

            this.patientId = patientId;
            this.medicalRecord = medicalRecord;
            this.currentName = currentName;
            this.emergencyContact = emergencyContact;
            this.insuranceInfo = insuranceInfo;
            this.roomNumber = roomNumber;
            this.attendingPhysician = attendingPhysician;
        }

        public Patient(MedicalRecord existingRecord, String currentName, int roomNumber, String physician) {
            this(generatePersistentId(), existingRecord, currentName, null, null, roomNumber, physician);
        }

        private static String generateTempId() { return "TMP-" + UUID.randomUUID(); }
        private static String generatePersistentId() { return "PAT-" + UUID.randomUUID(); }

        String getBasicInfo() {
            return "ID:" + patientId + " Name:" + currentName + " Room:" + (roomNumber < 0 ? "N/A" : roomNumber);
        }

        public String getPublicInfo() {
            return "Name: " + currentName + " Room: " + (roomNumber < 0 ? "Unassigned" : roomNumber);
        }

        public String getPatientId() { return patientId; }
        public MedicalRecord getMedicalRecord() { return medicalRecord; }

        public String getCurrentName() { return currentName; }
        public void setCurrentName(String currentName) {
            if (currentName == null || currentName.isBlank()) throw new IllegalArgumentException("Invalid name");
            this.currentName = currentName;
        }

        public String getEmergencyContact() { return emergencyContact; }
        public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

        public String getInsuranceInfo() { return insuranceInfo; }
        public void setInsuranceInfo(String insuranceInfo) { this.insuranceInfo = insuranceInfo; }

        public int getRoomNumber() { return roomNumber; }
        public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

        public String getAttendingPhysician() { return attendingPhysician; }
        public void setAttendingPhysician(String attendingPhysician) { this.attendingPhysician = attendingPhysician; }

        @Override
        public String toString() {
            return "Patient[" + patientId + "] name=" + currentName +
                    " room=" + (roomNumber < 0 ? "N/A" : roomNumber) +
                    " physician=" + attendingPhysician;
        }
    }

    // ---------- Staff ----------
    public static class Doctor {
        private final String licenseNumber;
        private final String specialty;

        public Doctor(String licenseNumber, String specialty) {
            this.licenseNumber = licenseNumber;
            this.specialty = specialty;
        }

        public String getLicenseNumber() { return licenseNumber; }
        public String getSpecialty() { return specialty; }
    }

    public static class Nurse {
        private final String nurseId;
        private final String shift;

        public Nurse(String nurseId, String shift) {
            this.nurseId = nurseId;
            this.shift = shift;
        }

        public String getNurseId() { return nurseId; }
        public String getShift() { return shift; }
    }

    public static class Administrator {
        private final String adminId;
        private final List<String> accessPermissions;

        public Administrator(String adminId, List<String> accessPermissions) {
            this.adminId = adminId;
            this.accessPermissions = new ArrayList<>(accessPermissions);
        }
    }

    // ---------- HospitalSystem ----------
    public static class HospitalSystem {
        private final Map<String, Object> patientRegistry = new HashMap<>();

        public boolean admitPatient(Object patient, Object staff) {
            if (!(patient instanceof Patient)) return false;
            if (!validateStaffAccess(staff, patient)) return false;
            patientRegistry.put(((Patient) patient).getPatientId(), patient);
            return true;
        }

        private boolean validateStaffAccess(Object staff, Object patient) {
            return (staff instanceof Doctor) || (staff instanceof Administrator);
        }
    }

    // Demo main
    public static void main(String[] args) {
        MedicalRecord mr = new MedicalRecord("MR1", "DNA123",
                new String[]{"Peanuts"}, new String[]{"Asthma"}, LocalDate.of(2000,1,1), "O+");
        Patient p1 = new Patient(mr, "Alice", 101, "Dr. Smith");
        Doctor d1 = new Doctor("DOC123", "Cardiology");

        HospitalSystem hs = new HospitalSystem();
        System.out.println("Admit status: " + hs.admitPatient(p1, d1));
        System.out.println(p1.getPublicInfo());
    }
}
