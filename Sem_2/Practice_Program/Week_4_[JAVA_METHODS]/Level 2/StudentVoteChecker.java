import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.printf("Enter age for Student %d: ", i + 1);
            ages[i] = input.nextInt();
            boolean result = canStudentVote(ages[i]);

            if (ages[i] < 0) {
                System.out.println("Invalid age entered! Cannot vote.");
            } else {
                System.out.println("Can vote: " + result);
            }
        }

        input.close();
    }
}
