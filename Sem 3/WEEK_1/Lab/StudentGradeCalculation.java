import java.util.Scanner;
import java.util.Random;

public class StudentGradeCalculation{

    public static int[][] generatePCMScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + random.nextInt(90);
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double percentage = (double) total / 300 * 100;
            stats[i][0] = total;
            stats[i][1] = (double) total / 3;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[] calculateGrades(double[] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double p = percentages[i];
            if (p >= 90) {
                grades[i] = "A";
            } else if (p >= 80) {
                grades[i] = "B";
            } else if (p >= 70) {
                grades[i] = "C";
            } else if (p >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
        return grades;
    }

    public static void displayTable(String[][] data, String[] headers) {
        for (String header : headers) {
            System.out.printf("%-15s", header);
        }
        System.out.println();
        for (String[] row : data) {
            for (String cell : row) {
                System.out.printf("%-15s", cell);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        try {
            int numStudents = sc.nextInt();
            int[][] scores = generatePCMScores(numStudents);
            double[][] stats = calculateStats(scores);
            double[] percentages = new double[numStudents];
            for (int i = 0; i < numStudents; i++) {
                percentages[i] = stats[i][2];
            }
            String[] grades = calculateGrades(percentages);
            String[][] scorecard = new String[numStudents][7];
            for (int i = 0; i < numStudents; i++) {
                scorecard[i][0] = String.valueOf(i + 1);
                scorecard[i][1] = String.valueOf(scores[i][0]);
                scorecard[i][2] = String.valueOf(scores[i][1]);
                scorecard[i][3] = String.valueOf(scores[i][2]);
                scorecard[i][4] = String.valueOf(stats[i][0]);
                scorecard[i][5] = String.valueOf(stats[i][2]);
                scorecard[i][6] = grades[i];
            }
            String[] headers = {"Student", "Physics", "Chemistry", "Math", "Total", "Percentage", "Grade"};
            System.out.println("\n--- Student Scorecard ---");
            displayTable(scorecard, headers);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        sc.close();
    }
}
