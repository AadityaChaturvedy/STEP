import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    private static final int NUM_SUBJECTS = 3; // Physics, Chemistry, Maths
    private static final int MAX_SCORE = 100; // Max score per subject

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][NUM_SUBJECTS];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                scores[i][j] = random.nextInt(MAX_SCORE); // 0 to 99
            }
        }
        return scores;
    }

    public static double[][] calculateMetrics(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3]; // 0:Total, 1:Average, 2:Percentage

        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                total += scores[i][j];
            }

            double average = (double) total / NUM_SUBJECTS;
            double percentage = ((double) total / (NUM_SUBJECTS * MAX_SCORE)) * 100.0;

            // Round average and percentage to 2 decimal places
            double roundedAverage = Math.round(average * 100.0) / 100.0;
            double roundedPercentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = roundedAverage;
            results[i][2] = roundedPercentage;
        }
        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        int numStudents = scores.length;

        System.out.println("\n--- Student Scorecard ---");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("Student#\tPhysics\t\tChemistry\tMaths\t\tTotal\t\tAverage\t\tPercentage%%\n");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%.0f\t\t%.2f\t\t%.2f\n",
                    (i + 1),
                    scores[i][0], // Physics
                    scores[i][1], // Chemistry
                    scores[i][2], // Maths
                    results[i][0], // Total
                    results[i][1], // Average
                    results[i][2]  // Percentage
            );
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numStudents = 0;

        System.out.println("--- Student Score Calculator ---");
        while (true) {
            System.out.print("Enter the number of students: ");
            try {
                numStudents = input.nextInt();
                if (numStudents > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number of students.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Consume invalid input
            }
        }

        int[][] studentScores = generateScores(numStudents);
        double[][] calculatedResults = calculateMetrics(studentScores);
        displayScorecard(studentScores, calculatedResults);

        input.close();
    }
}
