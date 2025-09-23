import java.util.Arrays;

public class NumberChecker4 {

    private static long factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            if (fact < 0) {
                 System.err.println("Warning: Factorial overflow for " + n);
                 return -1;
            }
        }
        return fact;
    }

    public static int[] findFactors(int number) {
        if (number <= 0) {
            return new int[0];
        }

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        if (factors == null || factors.length == 0) {
            return -1;
        }
        int max = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > max) {
                max = factors[i];
            }
        }
        return max;
    }

    public static long sumFactors(int[] factors) {
        if (factors == null || factors.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productFactors(int[] factors) {
        if (factors == null || factors.length == 0) {
            return 1;
        }
        long product = 1;
        for (int factor : factors) {
            if (factor != 0 && product > Long.MAX_VALUE / factor) {
                 System.err.println("Warning: Product of factors overflow detected.");
                 return -1;
            }
             if (factor == 0) return 0;
            product *= factor;
        }
        return product;
    }

    public static double productCubeFactors(int[] factors) {
        if (factors == null || factors.length == 0) {
            return 1.0;
        }
        double productOfCubes = 1.0;
        for (int factor : factors) {
             if (factor == 0) return 0.0;
            double cube = Math.pow(factor, 3);
            if (Double.isInfinite(productOfCubes * cube)) {
                 System.err.println("Warning: Product of cube factors overflow detected (double limit).");
                 return Double.POSITIVE_INFINITY;
            }
            productOfCubes *= cube;
        }
        return productOfCubes;
    }

    private static long sumProperDivisors(int number) {
        if (number <= 1) {
            return 0;
        }
        int[] factors = findFactors(number);
        long sum = sumFactors(factors);
        return sum - number;
    }

    public static boolean isPerfect(int number) {
        if (number <= 1) return false;
        return sumProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
         if (number <= 1) return false;
        return sumProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
         if (number <= 1) return false;
        return sumProperDivisors(number) < number;
    }

    public static boolean isStrong(int number) {
        if (number < 0) return false;
        if (number == 0) return false;

        long sumOfFactorials = 0;
        int tempNumber = number;

        while (tempNumber > 0) {
            int digit = tempNumber % 10;
            long fact = factorial(digit);
            if (fact == -1) {
                 System.err.println("Error calculating factorial for digit " + digit);
                 return false;
            }
            sumOfFactorials += fact;
             if (sumOfFactorials < 0) {
                 System.err.println("Warning: Sum of factorials overflowed.");
                 return false;
             }
            tempNumber /= 10;
        }

        return sumOfFactorials == number;
    }

    public static void main(String[] args) {
        int[] testNumbers = {6};

        System.out.println("--- Number Property Checks (NumberChecker5) ---");

        for (int testNumber : testNumbers) {
            System.out.println("\n--- Testing Number: " + testNumber + " ---");

            if (testNumber <= 0) {
                System.out.println("Factors/Perfect/Abundant/Deficient checks typically apply to positive integers.");
                 System.out.println("Is Strong? " + isStrong(testNumber));
                continue;
            }

            int[] factors = findFactors(testNumber);
            System.out.println("Factors: " + Arrays.toString(factors));
            System.out.println("Greatest Factor: " + greatestFactor(factors));
            System.out.println("Sum of Factors: " + sumFactors(factors));
            System.out.println("Product of Factors: " + productFactors(factors));
            System.out.println("Product of Cube of Factors: " + productCubeFactors(factors));

            System.out.println("Is Perfect? " + isPerfect(testNumber));
            System.out.println("Is Abundant? " + isAbundant(testNumber));
            System.out.println("Is Deficient? " + isDeficient(testNumber));
            System.out.println("Is Strong? " + isStrong(testNumber));
        }
    }
}
