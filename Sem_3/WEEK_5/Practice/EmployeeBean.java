import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    // Default constructor
    public EmployeeBean() {}

    // Parameterized constructor
    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    // Getters & Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String id) { this.employeeId = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String name) { this.firstName = name; }

    public String getLastName() { return lastName; }
    public void setLastName(String name) { this.lastName = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be positive");
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String dept) { this.department = dept; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date date) { this.hireDate = date; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }

    // Computed properties
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFormattedSalary() {
        return "$" + String.format("%.2f", salary);
    }

    // Derived setter
    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }

    // Override toString
    @Override
    public String toString() {
        return getFullName() + " (" + employeeId + ") - " + getFormattedSalary();
    }

    // Override equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean emp = (EmployeeBean) o;
        return Objects.equals(employeeId, emp.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E101");
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setSalary(50000);
        emp1.setDepartment("IT");
        emp1.setHireDate(new Date());
        emp1.setActive(true);

        System.out.println(emp1);
    }
}

// Utility class
class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        try {
            var methods = emp.getClass().getMethods();
            for (var m : methods) {
                if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
                    System.out.println(m.getName() + " = " + m.invoke(emp));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
