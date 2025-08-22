import java.util.Scanner;

public class PerformanceComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of iterations: ");
        int iterations = scanner.nextInt();

        // String concatenation
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime) + "ms");

        // StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + "ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + "ms");

        scanner.close();
    }
}