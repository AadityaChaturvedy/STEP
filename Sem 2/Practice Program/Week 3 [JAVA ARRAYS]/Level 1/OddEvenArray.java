import java.util.Scanner;

class OddEvenArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("The entered number is not a natural number.");
            return;
        }

        int evenSize = number / 2; 
        int oddSize = (number % 2 == 0) ? evenSize : evenSize + 1;

        int[] evenArray = new int[evenSize];
        int[] oddArray = new int[oddSize];

        int evenIndex = 0, oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex++] = i;
            } else {
                oddArray[oddIndex++] = i;
            }
        }

        System.out.println("Even Array: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.println();

        System.out.println("Odd Array: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();
    }
}