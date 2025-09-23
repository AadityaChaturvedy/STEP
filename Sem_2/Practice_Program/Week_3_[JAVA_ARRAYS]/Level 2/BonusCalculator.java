import java.util.Scanner;

class BonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Enter salary for Employee " + (i + 1) + ": ");
                salary[i] = input.nextDouble();
                System.out.print("Enter years of service for Employee " + (i + 1) + ": ");
                yearsOfService[i] = input.nextDouble();

                if (salary[i] > 0 && yearsOfService[i] >= 0)
                    break;
                else
                    System.out.println("Invalid input! Enter again.");
            }
        }

        for (int i = 0; i < 10; i++) {
            bonus[i] = (yearsOfService[i] > 5) ? (salary[i] * 0.05) : (salary[i] * 0.02);
            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nBonus details for each employee:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + " - Old Salary: $" + salary[i] + 
                               ", Bonus: $" + bonus[i] + ", New Salary: $" + newSalary[i]);
        }

        System.out.println("\nTotal Bonus Payout: $" + totalBonus);
        System.out.println("Total Old Salary: $" + totalOldSalary);
        System.out.println("Total New Salary: $" + totalNewSalary);
    }
}