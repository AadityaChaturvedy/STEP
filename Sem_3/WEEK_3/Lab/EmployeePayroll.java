class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int empCounter = 1;

    // For part-time
    private double hourlyRate;
    private int hoursWorked;

    // For contract
    private double contractAmount;

    // Constructor for full-time
    public Employee(String empName, String department, double baseSalary, double bonus) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary + bonus;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    // Constructor for part-time
    public Employee(String empName, String department, double hourlyRate, int hoursWorked) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    // Constructor for contract
    public Employee(String empName, String department, double contractAmount) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.contractAmount = contractAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    // Static method to generate unique employee ID
    public static String generateEmpId() {
        String id = String.format("E%03d", empCounter);
        empCounter++;
        return id;
    }

    // Overloaded calculateSalary methods
    public double calculateSalary() { // Full-Time
        if (empType.equals("Full-Time")) {
            return baseSalary;
        } else if (empType.equals("Part-Time")) {
            return calculateSalary(hourlyRate, hoursWorked);
        } else if (empType.equals("Contract")) {
            return calculateSalary(contractAmount);
        }
        return 0;
    }

    public double calculateSalary(double hourlyRate, int hoursWorked) { // Part-Time
        return hourlyRate * hoursWorked;
    }

    public double calculateSalary(double contractAmount) { // Contract
        return contractAmount;
    }

    // Overloaded calculateTax methods
    public double calculateTax() { // Full-Time
        if (empType.equals("Full-Time")) {
            return calculateTax(baseSalary, 0.2); // 20% tax
        } else if (empType.equals("Part-Time")) {
            return calculateTax(calculateSalary(hourlyRate, hoursWorked), 0.1); // 10% tax
        } else if (empType.equals("Contract")) {
            return calculateTax(contractAmount, 0.05); // 5% tax
        }
        return 0;
    }

    public double calculateTax(double salary, double rate) {
        return salary * rate;
    }

    // Pay slip
    public void generatePaySlip() {
        System.out.println("----- Pay Slip -----");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        double salary = calculateSalary();
        double tax = calculateTax();
        System.out.println("Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + (salary - tax));
        System.out.println("--------------------");
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("--------------------");
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static void generatePayrollReport(Employee[] employees) {
        System.out.println("=== Company Payroll Report ===");
        for (Employee emp : employees) {
            emp.generatePaySlip();
        }
        System.out.println("Total Employees: " + getTotalEmployees());
        System.out.println("==============================");
    }
}

public class EmployeePayroll {
    public static void main(String[] args) {
        // Create employees
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Alice", "IT", 50000, 5000); // Full-Time
        employees[1] = new Employee("Bob", "HR", 200, 80);       // Part-Time
        employees[2] = new Employee("Charlie", "Finance", 30000); // Contract

        // Demonstrate method overloading
        for (Employee emp : employees) {
            emp.displayEmployeeInfo();
            emp.generatePaySlip();
        }

        // Generate company-wide payroll report
        Employee.generatePayrollReport(employees);
    }
}