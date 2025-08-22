import java.util.Scanner;

public class NumberAnalyzer {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Enter number %d: ", (i + 1));
            numbers[i] = scanner.nextInt();

            if (isPositive(numbers[i])) {
                System.out.print("Positive ");
                if (isEven(numbers[i])) {
                    System.out.println("and Even");
                } else {
                    System.out.println("and Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }

        System.out.println("\nComparing first and last number:");
        int result = compare(numbers[0], numbers[4]);

        if (result == 1) {
            System.out.println("First number is greater than last number.");
        } else if (result == 0) {
            System.out.println("First and last numbers are equal.");
        } else {
            System.out.println("First number is less than last number.");
        }

        scanner.close();
    }
}
