import java.util.Scanner;
import java.util.Random;

public class VoteEligibility {

    public static int[] generateStudentAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        Random random = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = 10 + random.nextInt(90);
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            results[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return results;
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
            int[] ages = generateStudentAges(numStudents);
            String[][] eligibility = checkVotingEligibility(ages);
            String[] headers = {"Age", "Can Vote"};
            System.out.println("Student voting eligibility:");
            displayTable(eligibility, headers);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        sc.close();
    }
}
