import java.util.Arrays;

public class NumberChecker2 {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        int temp = Math.abs(number);x
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigits(int number) {
        if (number == 0) return new int[]{0};
        int numDigits = countDigits(number);
        int[] digits = new int[numDigits];
        int temp = Math.abs(number);
        for (int i = numDigits - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        if (digits == null) {
            return new int[0];
        }
        int n = digits.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = digits[n - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) return false;
        int[] originalDigits = getDigits(number);
        int[] reversedDigits = reverseDigits(originalDigits);
        return areArraysEqual(originalDigits, reversedDigits);
    }

    public static boolean isDuckNumber(int number) {
        if (number <= 0) {
             return false;
        }
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numPalindromeDuck = 101;
        int numPalindromeNotDuck = 121;
        int numNotPalindromeDuck = 120;
        int numNotPalindromeNotDuck = 123;
        int numSingleDigit = 5;
        int numZero = 0;
        int numNegative = -121;

        int[] testNumbers = {numPalindromeDuck, numPalindromeNotDuck, numNotPalindromeDuck, numNotPalindromeNotDuck, numSingleDigit, numZero, numNegative};

        for (int testNumber : testNumbers) {
            System.out.println("--- Testing Number: " + testNumber + " ---");

            int count = countDigits(testNumber);
            System.out.println("Digit Count: " + count);

            int[] digits = getDigits(testNumber);
            System.out.println("Digits Array: " + Arrays.toString(digits));

            int[] reversedDigits = reverseDigits(digits);
            System.out.println("Reversed Digits Array: " + Arrays.toString(reversedDigits));

            boolean arraysEqual = areArraysEqual(digits, reversedDigits);
            System.out.println("Are Original and Reversed Arrays Equal? " + arraysEqual);

            boolean palindrome = isPalindrome(testNumber);
            System.out.println("Is Palindrome? " + palindrome);

            boolean duck = isDuckNumber(testNumber);
            System.out.println("Is Duck Number? " + duck);

            System.out.println();
        }
    }
}
