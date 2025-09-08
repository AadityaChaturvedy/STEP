import java.util.Arrays; // Keep for main method example if needed, though not strictly required by the remaining methods

public class NumberChecker3 {

    // --- Core Number Property Checks ---

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        // Check for divisibility only up to the square root of the number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, it's prime
    }

    public static boolean isNeon(int number) {
        if (number < 0) return false; // Neon numbers are non-negative
        long square = (long)number * number; // Use long to avoid overflow
        long tempSquare = square;
        int sumOfSquareDigits = 0;

        // Calculate sum of digits of the square directly
        if (tempSquare == 0) {
            sumOfSquareDigits = 0;
        } else {
             while (tempSquare > 0) {
                sumOfSquareDigits += (int)(tempSquare % 10);
                tempSquare /= 10;
            }
        }

        return sumOfSquareDigits == number;
    }

    public static boolean isSpy(int number) {
         if (number < 0) return false; // Spy numbers are non-negative

        int sum = 0;
        long product = 1;
        int tempNumber = number;
        boolean isZero = (number == 0); // Handle 0 separately

        if (isZero) {
            sum = 0;
            product = 0; // Define product of digits of 0 as 0
        } else {
             // Calculate sum and product of digits directly
            while (tempNumber > 0) {
                int digit = tempNumber % 10;
                sum += digit;
                product *= digit;
                tempNumber /= 10;
            }
             // If the original number had a 0 digit, the product should be 0
             // Check if the number contains a 0 digit if product is non-zero
             if (product != 0) {
                 tempNumber = number; // Reset tempNumber
                 while (tempNumber > 0) {
                     if (tempNumber % 10 == 0) {
                         product = 0; // Correct product if a zero exists
                         break;
                     }
                     tempNumber /= 10;
                 }
             }
        }


        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        if (number < 0) return false; // Automorphic numbers are non-negative
        long square = (long)number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        // Check if the square string ends with the number string
        return squareStr.endsWith(numStr);
    }

    public static boolean isBuzz(int number) {
        // Check if divisible by 7 OR if the last digit is 7
        return number % 7 == 0 || Math.abs(number) % 10 == 7;
    }

    // --- Updated Main Method ---

    public static void main(String[] args) {
        int[] testNumbers = {
            121, 101, 17, 9
        };

        System.out.println("--- Testing Number Properties ---");
        for (int testNumber : testNumbers) {
            System.out.println("\nNumber: " + testNumber);
            System.out.println("  Is Prime?      " + isPrime(testNumber));
            System.out.println("  Is Neon?       " + isNeon(testNumber));
            System.out.println("  Is Spy?        " + isSpy(testNumber)); // Corrected logic
            System.out.println("  Is Automorphic? " + isAutomorphic(testNumber));
            System.out.println("  Is Buzz?       " + isBuzz(testNumber));
        }
    }
}
