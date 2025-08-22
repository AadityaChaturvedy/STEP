import java.util.Scanner;
import java.util.Arrays;

class StoringAndSortingDigitImproved {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int maxDigit = 10;
        int[] intStore = new int[maxDigit]; 
        int index = 0;

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                intStore = Arrays.copyOf(intStore, maxDigit);
            }

            intStore[index] = number % 10;
            number /= 10; 
            index++;
        }

        int largestDigit = 0;
        int secondLargestDigit = 0;

        for (int i = 0; i < index; i++) {
            if (intStore[i] > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = intStore[i];
            } else if (intStore[i] > secondLargestDigit && intStore[i] != largestDigit) {
                secondLargestDigit = intStore[i];
            }
        }

        System.out.printf("Largest Digit: %d\n", largestDigit);
        if (index > 1) {
            System.out.printf("Second Largest Digit: %d\n", secondLargestDigit);
        } else {
            System.out.println("No second largest digit found.");
        }

        input.close();
    }
}