import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a sentence with mixed formatting
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // 1. trim() - Remove extra spaces at start/end
        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        // 2. replace() - Replace all spaces with underscores
        String underscores = trimmed.replace(' ', '_');
        System.out.println("Spaces replaced with underscores: " + underscores);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("Removed digits: " + noDigits);

        // 4. split() - Split sentence into words array
        String[] words = trimmed.split("\\s+");
        System.out.println("Words array: " + Arrays.toString(words));

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("Joined with | : " + joined);

        // Remove all punctuation
        String noPunct = removePunctuation(trimmed);
        System.out.println("No punctuation: " + noPunct);

        // Capitalize first letter of each word
        String capitalized = capitalizeWords(trimmed);
        System.out.println("Capitalized: " + capitalized);

        // Reverse the order of words
        String reversed = reverseWordOrder(trimmed);
        System.out.println("Reversed word order: " + reversed);

        // Count word frequency
        countWordFrequency(trimmed);

        scanner.close();
    }

    // Method to remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    // Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    // Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.trim().toLowerCase().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll("\\p{Punct}", "");
            if (word.isEmpty()) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}