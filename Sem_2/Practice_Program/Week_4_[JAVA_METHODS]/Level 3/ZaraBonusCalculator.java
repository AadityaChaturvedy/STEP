import java.util.Random;

public class ZaraBonusCalculator {

    private static final int NUM_EMPLOYEES = 5;
    private static final double BONUS_RATE_HIGH = 0.05;
    private static final double BONUS_RATE_LOW = 0.02;
    private static final int SERVICE_THRESHOLD = 5;
    private static final int MIN_SALARY = 10000;
    private static final int MAX_SALARY = 99999;
    private static final int MAX_YEARS_SERVICE = 10;

    public static double[][] generateEmployeeData(int numEmployees) {
        double[][] employeeData = new double[numEmployees][2];
        Random random = new Random();

        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = random.nextInt(MAX_SALARY - MIN_SALARY + 1) + MIN_SALARY;
            employeeData[i][1] = random.nextInt(MAX_YEARS_SERVICE) + 1;
        }
        return employeeData;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        int numEmployees = employeeData.length;
        double[][] bonusData = new double[numEmployees][2];

        for (int i = 0; i < numEmployees; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusRate;
            double bonusAmount;
            double newSalary;

            if (yearsOfService > SERVICE_THRESHOLD) {
                bonusRate = BONUS_RATE_HIGH;
            } else {
                bonusRate = BONUS_RATE_LOW;
            }

            bonusAmount = oldSalary * bonusRate;
            newSalary = oldSalary + bonusAmount;

            bonusData[i][0] = bonusAmount;
            bonusData[i][1] = newSalary;
        }
        return bonusData;
    }

    public static void displayResults(double[][] employeeData, double[][] bonusData) {
        int numEmployees = employeeData.length;
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("--- Zara Employee Bonus Calculation ---");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-10s | %-12s | %-10s | %-12s | %-12s |\n",
                "Employee #", "Old Salary", "Years Svc", "Bonus Amt", "New Salary");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < numEmployees; i++) {
            double oldSalary = employeeData[i][0];
            int years = (int) employeeData[i][1];
            double bonus = bonusData[i][0];
            double newSalary = bonusData[i][1];

            System.out.printf("| %-10d | %,-12.2f | %-10d | %,-12.2f | %,-12.2f |\n",
                    (i + 1), oldSalary, years, bonus, newSalary);

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }
        System.out.println("--------------------------------------------------------------------");

        System.out.println("\n--- Company Bonus Summary ---");
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-20s | %-18s | %-15s |\n",
                "Total Old Salary", "Total Bonus Amount", "Total New Salary");
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %,-20.2f | %,-18.2f | %,-15.2f |\n",
                totalOldSalary, totalBonus, totalNewSalary);
        System.out.println("----------------------------------------------------------");
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(NUM_EMPLOYEES);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        displayResults(employeeData, bonusData);
    }
}
