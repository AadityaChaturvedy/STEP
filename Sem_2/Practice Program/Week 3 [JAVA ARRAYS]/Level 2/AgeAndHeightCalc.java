import java.util.Arrays;
import java.util.Scanner;

class AgeAndHeightCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Input ages
        System.out.println("Enter the ages(in years): ");
        int[] age = new int[3];
        for (int i = 0; i < 3; i++) {
            age[i] = input.nextInt();
        }

        // Input heights
        System.out.println("Enter the heights(in cm): ");
        int[] height = new int[3];
        for (int i = 0; i < 3; i++) {
            height[i] = input.nextInt();
        }

        // Find youngest and tallest
        int youngestAge = Arrays.stream(age).min().getAsInt();
        int tallestHeight = Arrays.stream(height).max().getAsInt();

        // Display results
        System.out.println("The youngest is: " + names[indexOf(age, youngestAge)]);
        System.out.println("The tallest is: " + names[indexOf(height, tallestHeight)]);
    }

    // Helper method to find index
    public static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}