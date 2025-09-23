import java.util.Scanner;

public class BmiCalculator {

    public static String[][] getBmiReport(double[][] measurements) {
        String[][] report = new String[measurements.length][4];
        for (int i = 0; i < measurements.length; i++) {
            double weight = measurements[i][0];
            double heightInCm = measurements[i][1];
            double[] bmiAndStatus = calculateBmi(weight, heightInCm);
            
            report[i][0] = String.format("%.2f cm", heightInCm);
            report[i][1] = String.format("%.2f kg", weight);
            report[i][2] = String.format("%.2f", bmiAndStatus[0]);
            report[i][3] = getBmiStatus(bmiAndStatus[0]);
        }
        return report;
    }

    public static double[] calculateBmi(double weight, double heightInCm) {
        double heightInM = heightInCm / 100.0;
        double bmi = weight / (heightInM * heightInM);
        return new double[]{bmi};
    }

    public static String getBmiStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 39.9) return "Overweight";
        return "Obese";
    }

    public static void displayReport(String[][] report) {
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-15s %-15s %-10s %-15s%n", "Height", "Weight", "BMI", "Status");
        System.out.println("----------------------------------------------------------");
        for (String[] personData : report) {
            System.out.printf("%-15s %-15s %-10s %-15s%n", 
                personData[0], personData[1], personData[2], personData[3]);
        }
        System.out.println("----------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] measurements = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Enter weight in kg: ");
            measurements[i][0] = scanner.nextDouble();
            System.out.print("Enter height in cm: ");
            measurements[i][1] = scanner.nextDouble();
        }

        String[][] report = getBmiReport(measurements);
        displayReport(report);
        scanner.close();
    }
}
