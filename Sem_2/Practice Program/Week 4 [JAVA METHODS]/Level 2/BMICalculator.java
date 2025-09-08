import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weight, double heightCm) {
        double heightMeters = heightCm / 100;
        return weight / (heightMeters * heightMeters);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] statuses = new String[10];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter weight (kg) of person %d: ", i + 1);
            data[i][0] = scanner.nextDouble();

            System.out.printf("Enter height (cm) of person %d: ", i + 1);
            data[i][1] = scanner.nextDouble();

            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            statuses[i] = determineBMIStatus(data[i][2]);
        }

        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n",
                    i + 1, data[i][0], data[i][1], data[i][2], statuses[i]);
        }

        scanner.close();
    }
}
