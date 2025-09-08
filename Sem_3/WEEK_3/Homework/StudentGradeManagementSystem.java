import java.util.*;

class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }
}

class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // [subject][exam]
    private double gpa;

    // Static variables
    public static int totalStudents = 0;
    public static String schoolName = "Green Valley School";
    public static String[] gradingScale = {"A", "B", "C", "D", "F"};
    public static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][3]; // Assume 3 exams per subject
        this.gpa = 0.0;
        totalStudents++;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getClassName() { return className; }
    public String[] getSubjects() { return subjects; }
    public double[][] getMarks() { return marks; }
    public double getGPA() { return gpa; }

    public void addMarks(String subject, int examIndex, double mark) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                marks[i][examIndex] = mark;
                return;
            }
        }
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double avg = count == 0 ? 0 : total / count;
        // GPA scale: 4.0 for >=90, 3.0 for >=80, 2.0 for >=70, 1.0 for >=60, 0 for <60
        if (avg >= 90) gpa = 4.0;
        else if (avg >= 80) gpa = 3.0;
        else if (avg >= 70) gpa = 2.0;
        else if (avg >= 60) gpa = 1.0;
        else gpa = 0.0;
    }

    public String getGrade(double percentage) {
        if (percentage >= 90) return gradingScale[0]; // A
        else if (percentage >= 80) return gradingScale[1]; // B
        else if (percentage >= 70) return gradingScale[2]; // C
        else if (percentage >= 60) return gradingScale[3]; // D
        else return gradingScale[4]; // F
    }

    public void generateReportCard() {
        calculateGPA();
        System.out.println("\n--- Report Card ---");
        System.out.println("School: " + schoolName);
        System.out.println("Student: " + studentName + " (" + studentId + ")");
        System.out.println("Class: " + className);
        System.out.printf("%-12s %-18s %-10s %-8s\n", "Subject", "Exam Scores", "Avg", "Grade");
        for (int i = 0; i < subjects.length; i++) {
            double sum = 0;
            StringBuilder scores = new StringBuilder();
            for (int j = 0; j < marks[i].length; j++) {
                sum += marks[i][j];
                scores.append(String.format("%.1f", marks[i][j]));
                if (j < marks[i].length - 1) scores.append(", ");
            }
            double avg = sum / marks[i].length;
            String grade = getGrade(avg);
            System.out.printf("%-12s %-18s %-10.2f %-8s\n", subjects[i], scores, avg, grade);
        }
        System.out.printf("GPA: %.2f\n", gpa);
        System.out.println("Promotion Eligible: " + (checkPromotionEligibility() ? "Yes" : "No"));
    }

    public boolean checkPromotionEligibility() {
        for (int i = 0; i < marks.length; i++) {
            double sum = 0;
            for (int j = 0; j < marks[i].length; j++) sum += marks[i][j];
            double avg = sum / marks[i].length;
            if (avg < passPercentage) return false;
        }
        return true;
    }

    // Static methods
    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Student[] students, String className) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null && s.getClassName().equalsIgnoreCase(className)) {
                s.calculateGPA();
                total += s.getGPA();
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public static Student[] getTopPerformers(Student[] students, int count) {
        Arrays.sort(students, (a, b) -> Double.compare(b.getGPA(), a.getGPA()));
        Student[] top = new Student[Math.min(count, students.length)];
        for (int i = 0; i < top.length; i++) top[i] = students[i];
        return top;
    }

    public static void generateSchoolReport(Student[] students) {
        Map<String, List<Student>> classMap = new HashMap<>();
        for (Student s : students) {
            if (s != null) {
                classMap.computeIfAbsent(s.getClassName(), k -> new ArrayList<>()).add(s);
            }
        }
        System.out.println("\n--- School Report ---");
        for (String className : classMap.keySet()) {
            List<Student> classStudents = classMap.get(className);
            double avg = 0;
            for (Student s : classStudents) {
                s.calculateGPA();
                avg += s.getGPA();
            }
            avg = classStudents.size() == 0 ? 0 : avg / classStudents.size();
            System.out.printf("Class: %s | Students: %d | Avg GPA: %.2f\n", className, classStudents.size(), avg);
        }
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        // Subjects
        Subject[] subjects = {
            new Subject("MATH101", "Mathematics", 4, "Dr. Smith"),
            new Subject("ENG102", "English", 3, "Ms. Johnson"),
            new Subject("SCI103", "Science", 4, "Dr. Lee"),
            new Subject("HIST104", "History", 2, "Mr. Brown")
        };
        String[] subjectNames = Arrays.stream(subjects).map(Subject::getSubjectName).toArray(String[]::new);

        // Students
        Student[] students = new Student[5];
        students[0] = new Student("S001", "Alice", "Grade 10", subjectNames);
        students[1] = new Student("S002", "Bob", "Grade 10", subjectNames);
        students[2] = new Student("S003", "Charlie", "Grade 11", subjectNames);
        students[3] = new Student("S004", "Diana", "Grade 11", subjectNames);
        students[4] = new Student("S005", "Ethan", "Grade 12", subjectNames);

        // Add marks (subject, examIndex, mark)
        students[0].addMarks("Mathematics", 0, 95);
        students[0].addMarks("Mathematics", 1, 88);
        students[0].addMarks("Mathematics", 2, 92);
        students[0].addMarks("English", 0, 85);
        students[0].addMarks("English", 1, 90);
        students[0].addMarks("English", 2, 87);
        students[0].addMarks("Science", 0, 78);
        students[0].addMarks("Science", 1, 82);
        students[0].addMarks("Science", 2, 80);
        students[0].addMarks("History", 0, 88);
        students[0].addMarks("History", 1, 90);
        students[0].addMarks("History", 2, 85);

        students[1].addMarks("Mathematics", 0, 65);
        students[1].addMarks("Mathematics", 1, 70);
        students[1].addMarks("Mathematics", 2, 68);
        students[1].addMarks("English", 0, 75);
        students[1].addMarks("English", 1, 72);
        students[1].addMarks("English", 2, 78);
        students[1].addMarks("Science", 0, 60);
        students[1].addMarks("Science", 1, 62);
        students[1].addMarks("Science", 2, 65);
        students[1].addMarks("History", 0, 70);
        students[1].addMarks("History", 1, 68);
        students[1].addMarks("History", 2, 72);

        students[2].addMarks("Mathematics", 0, 85);
        students[2].addMarks("Mathematics", 1, 88);
        students[2].addMarks("Mathematics", 2, 90);
        students[2].addMarks("English", 0, 80);
        students[2].addMarks("English", 1, 82);
        students[2].addMarks("English", 2, 85);
        students[2].addMarks("Science", 0, 88);
        students[2].addMarks("Science", 1, 90);
        students[2].addMarks("Science", 2, 92);
        students[2].addMarks("History", 0, 78);
        students[2].addMarks("History", 1, 80);
        students[2].addMarks("History", 2, 82);

        students[3].addMarks("Mathematics", 0, 55);
        students[3].addMarks("Mathematics", 1, 60);
        students[3].addMarks("Mathematics", 2, 58);
        students[3].addMarks("English", 0, 65);
        students[3].addMarks("English", 1, 62);
        students[3].addMarks("English", 2, 68);
        students[3].addMarks("Science", 0, 50);
        students[3].addMarks("Science", 1, 52);
        students[3].addMarks("Science", 2, 55);
        students[3].addMarks("History", 0, 60);
        students[3].addMarks("History", 1, 58);
        students[3].addMarks("History", 2, 62);

        students[4].addMarks("Mathematics", 0, 98);
        students[4].addMarks("Mathematics", 1, 95);
        students[4].addMarks("Mathematics", 2, 97);
        students[4].addMarks("English", 0, 92);
        students[4].addMarks("English", 1, 94);
        students[4].addMarks("English", 2, 96);
        students[4].addMarks("Science", 0, 90);
        students[4].addMarks("Science", 1, 92);
        students[4].addMarks("Science", 2, 94);
        students[4].addMarks("History", 0, 95);
        students[4].addMarks("History", 1, 97);
        students[4].addMarks("History", 2, 99);

        // Menu-driven system
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- " + Student.schoolName + " Grade Management Menu ---");
            System.out.println("1. Generate report card for a student");
            System.out.println("2. View class average GPA");
            System.out.println("3. View top performers");
            System.out.println("4. Generate school report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    Student found = null;
                    for (Student s : students) {
                        if (s.getStudentName().equalsIgnoreCase(name)) {
                            found = s;
                            break;
                        }
                    }
                    if (found != null) found.generateReportCard();
                    else System.out.println("Student not found.");
                    break;
                case 2:
                    System.out.print("Enter class name: ");
                    String className = sc.nextLine();
                    double avg = Student.calculateClassAverage(students, className);
                    System.out.printf("Average GPA for %s: %.2f\n", className, avg);
                    break;
                case 3:
                    System.out.print("Enter number of top performers: ");
                    int count = sc.nextInt();
                    sc.nextLine();
                    Student[] top = Student.getTopPerformers(students, count);
                    System.out.println("Top Performers:");
                    for (Student s : top) {
                        System.out.printf("%s (%s) - GPA: %.2f\n", s.getStudentName(), s.getClassName(), s.getGPA());
                    }
                    break;
                case 4:
                    Student.generateSchoolReport(students);
                    break;
                case 0:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}