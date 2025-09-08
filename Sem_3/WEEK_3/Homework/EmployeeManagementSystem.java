import java.util.*;

abstract class Employee {
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary;
    protected String joinDate;
    protected boolean[] attendanceRecord; // 30 days
    protected int leavesTaken;
    protected double bonus;

    // Static variables
    public static int totalEmployees = 0;
    public static String companyName = "Tech Solutions Inc.";
    public static double totalSalaryExpense = 0.0;
    public static int workingDaysPerMonth = 22;

    public Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[30];
        this.leavesTaken = 0;
        this.bonus = 0.0;
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30) {
            attendanceRecord[day - 1] = present;
            if (!present) leavesTaken++;
        }
    }

    public abstract double calculateSalary();

    public double calculateBonus() {
        int presentDays = 0;
        for (int i = 0; i < workingDaysPerMonth; i++) {
            if (attendanceRecord[i]) presentDays++;
        }
        // Bonus: 10% of baseSalary if attendance >= 95%, else 5%
        double attendanceRate = presentDays * 100.0 / workingDaysPerMonth;
        bonus = attendanceRate >= 95 ? baseSalary * 0.10 : baseSalary * 0.05;
        return bonus;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Company: " + companyName);
        System.out.println("Employee: " + empName + " (" + empId + ")");
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Leaves Taken: " + leavesTaken);
        System.out.println("Total Salary (with bonus): $" + (salary + bonus));
    }

    public void requestLeave(int days) {
        leavesTaken += days;
        System.out.println(empName + " requested " + days + " days leave. Total leaves: " + leavesTaken);
    }

    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getBaseSalary() { return baseSalary; }
    public int getLeavesTaken() { return leavesTaken; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }

    @Override
    public double calculateSalary() {
        // Full-time: baseSalary minus $100 per leave
        double salary = baseSalary - (leavesTaken * 100);
        totalSalaryExpense += salary;
        return salary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate, int hoursWorked) {
        super(empId, empName, department, designation, baseSalary, joinDate);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        // Part-time: baseSalary is hourly rate * hoursWorked
        double salary = baseSalary * hoursWorked;
        totalSalaryExpense += salary;
        return salary;
    }
}

class ContractEmployee extends Employee {
    private int contractDays;

    public ContractEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate, int contractDays) {
        super(empId, empName, department, designation, baseSalary, joinDate);
        this.contractDays = contractDays;
    }

    @Override
    public double calculateSalary() {
        // Contract: baseSalary per day * contractDays
        double salary = baseSalary * contractDays;
        totalSalaryExpense += salary;
        return salary;
    }
}

class Department {
    private String deptId;
    private String deptName;
    private Employee manager;
    private Employee[] employees;
    private double budget;

    public Department(String deptId, String deptName, Employee manager, Employee[] employees, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = employees;
        this.budget = budget;
    }

    public String getDeptId() { return deptId; }
    public String getDeptName() { return deptName; }
    public Employee getManager() { return manager; }
    public Employee[] getEmployees() { return employees; }
    public double getBudget() { return budget; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Sample employees
        Employee[] employees = new Employee[6];
        employees[0] = new FullTimeEmployee("E001", "Alice", "IT", "Developer", 4000, "2022-01-10");
        employees[1] = new FullTimeEmployee("E002", "Bob", "HR", "HR Manager", 4500, "2021-03-15");
        employees[2] = new PartTimeEmployee("E003", "Charlie", "IT", "Support", 25, "2023-02-01", 80);
        employees[3] = new ContractEmployee("E004", "Diana", "Finance", "Consultant", 100, "2022-11-05", 20);
        employees[4] = new FullTimeEmployee("E005", "Ethan", "Finance", "Accountant", 3800, "2020-07-20");
        employees[5] = new PartTimeEmployee("E006", "Fiona", "HR", "Recruiter", 30, "2023-05-01", 60);

        // Sample departments
        Department[] departments = new Department[3];
        departments[0] = new Department("D01", "IT", employees[0], new Employee[]{employees[0], employees[2]}, 20000);
        departments[1] = new Department("D02", "HR", employees[1], new Employee[]{employees[1], employees[5]}, 15000);
        departments[2] = new Department("D03", "Finance", employees[4], new Employee[]{employees[3], employees[4]}, 18000);

        // Mark attendance for demonstration
        for (Employee e : employees) {
            for (int d = 1; d <= Employee.workingDaysPerMonth; d++) {
                e.markAttendance(d, true); // All present
            }
        }
        employees[0].markAttendance(5, false); // Alice absent on day 5
        employees[1].markAttendance(10, false); // Bob absent on day 10
        employees[4].markAttendance(3, false); // Ethan absent on day 3

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- " + Employee.companyName + " HR Menu ---");
            System.out.println("1. Generate pay slip for employee");
            System.out.println("2. Request leave");
            System.out.println("3. Company payroll expense");
            System.out.println("4. Department-wise expenses");
            System.out.println("5. Attendance report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    Employee emp = null;
                    for (Employee e : employees) {
                        if (e.getEmpName().equalsIgnoreCase(name)) emp = e;
                    }
                    if (emp == null) { System.out.println("Employee not found."); break; }
                    emp.generatePaySlip();
                    break;
                case 2:
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    emp = null;
                    for (Employee e : employees) {
                        if (e.getEmpName().equalsIgnoreCase(name)) emp = e;
                    }
                    if (emp == null) { System.out.println("Employee not found."); break; }
                    System.out.print("Enter number of leave days: ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    emp.requestLeave(days);
                    break;
                case 3:
                    double payroll = calculateCompanyPayroll(employees);
                    System.out.printf("Total Company Payroll Expense: $%.2f\n", payroll);
                    break;
                case 4:
                    getDepartmentWiseExpenses(departments);
                    break;
                case 5:
                    getAttendanceReport(employees);
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

    // Static methods
    public static double calculateCompanyPayroll(Employee[] employees) {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary() + e.calculateBonus();
        }
        return total;
    }

    public static void getDepartmentWiseExpenses(Department[] departments) {
        System.out.println("\n--- Department-wise Salary Expenses ---");
        for (Department d : departments) {
            double deptTotal = 0;
            for (Employee e : d.getEmployees()) {
                deptTotal += e.calculateSalary() + e.calculateBonus();
            }
            System.out.printf("Department: %s | Manager: %s | Expense: $%.2f | Budget: $%.2f\n",
                d.getDeptName(), d.getManager().getEmpName(), deptTotal, d.getBudget());
        }
    }

    public static void getAttendanceReport(Employee[] employees) {
        System.out.println("\n--- Attendance Report ---");
        for (Employee e : employees) {
            int present = 0;
            for (int i = 0; i < Employee.workingDaysPerMonth; i++) {
                if (e.attendanceRecord[i]) present++;
            }
            double rate = present * 100.0 / Employee.workingDaysPerMonth;
            System.out.printf("%s (%s): Present %d/%d days (%.2f%%), Leaves: %d\n",
                e.getEmpName(), e.getDesignation(), present, Employee.workingDaysPerMonth, rate, e.getLeavesTaken());
        }
    }
}