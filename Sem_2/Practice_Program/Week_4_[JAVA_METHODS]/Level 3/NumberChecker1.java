import java.util.Arrays;

public class NumberChecker1 {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        int temp = Math.abs(number);
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

    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumSquareDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        if (number == 0) return false; // Or handle as per definition preference
        int sum = sumDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            if (digit >= 0 && digit <= 9) {
                freq[digit]++;
            }
        }

        int countNonZero = 0;
        for(int f : freq) {
            if (f > 0) {
                countNonZero++;
            }
        }

        int[][] result = new int[countNonZero][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int testNumber = 126;

        int count = countDigits(testNumber);
        System.out.println("Number: " + testNumber);
        System.out.println("Digit Count: " + count);

        int[] digits = getDigits(testNumber);
        System.out.println("Digits Array: " + Arrays.toString(digits));

        int sum = sumDigits(digits);
        System.out.println("Sum of Digits: " + sum);

        int sumSq = sumSquareDigits(digits);
        System.out.println("Sum of Squares of Digits: " + sumSq);

        boolean harshad = isHarshad(testNumber, digits);
        System.out.println("Is Harshad Number? " + harshad);

        int[][] frequency = digitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int[] row : frequency) {
            System.out.println("  Digit " + row[0] + ": " + row[1] + " times");
        }

        // Test with zero
        int zeroTest = 0;
        System.out.println("\nNumber: " + zeroTest);
        System.out.println("Digit Count: " + countDigits(zeroTest));
        int[] zeroDigits = getDigits(zeroTest);
        System.out.println("Digits Array: " + Arrays.toString(zeroDigits));
        System.out.println("Sum of Digits: " + sumDigits(zeroDigits));
        System.out.println("Sum of Squares of Digits: " + sumSquareDigits(zeroDigits));
        System.out.println("Is Harshad Number? " + isHarshad(zeroTest, zeroDigits));
        int[][] zeroFrequency = digitFrequency(zeroDigits);
         System.out.println("Digit Frequency:");
        for (int[] row : zeroFrequency) {
            System.out.println("  Digit " + row[0] + ": " + row[1] + " times");
        }
    }
}
