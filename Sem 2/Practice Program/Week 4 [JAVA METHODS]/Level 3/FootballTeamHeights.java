import java.util.Random;
import java.util.Arrays;

public class FootballTeamHeights {

    // Method to generate random heights
    public static void generateRandomHeights(int[] heights) {
        Random random = new Random();
        // Range 150 to 250 cms (inclusive) -> nextInt(101) gives 0-100, add 150
        int minHeight = 150;
        int maxHeight = 250;
        int range = maxHeight - minHeight + 1;

        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(range) + minHeight;
        }
    }

    // Method to find the sum of all elements
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int height : arr) {
            sum += height;
        }
        return sum;
    }

    // Method to find the mean height
    public static double calculateMean(int[] arr) {
        if (arr.length == 0) {
            return 0.0;
        }
        int sum = calculateSum(arr);
        // Use double division
        return (double) sum / arr.length;
    }

    // Method to find the shortest height
    public static int findShortest(int[] arr) {
        if (arr.length == 0) {
            // Or throw an exception for empty array
            return -1; // Indicate error or no data
        }
        int shortest = arr[0]; // Assume first is shortest initially
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < shortest) {
                shortest = arr[i];
            }
        }
        return shortest;
    }

    // Method to find the tallest height
    public static int findTallest(int[] arr) {
        if (arr.length == 0) {
            return -1; // Indicate error or no data
        }
        int tallest = arr[0]; // Assume first is tallest initially
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tallest) {
                tallest = arr[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        int teamSize = 11;
        int[] heights = new int[teamSize];

        // Generate heights
        generateRandomHeights(heights);
        System.out.println("Player Heights (cms): " + Arrays.toString(heights));

        // Calculate metrics
        int sum = calculateSum(heights);
        double mean = calculateMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display results
        System.out.println("\n--- Team Height Statistics ---");
        System.out.println("Sum of Heights: " + sum + " cms");
        System.out.printf("Mean Height: %.2f cms\n", mean);
        System.out.println("Shortest Player Height: " + shortest + " cms");
        System.out.println("Tallest Player Height: " + tallest + " cms");
    }
}
