import java.util.Scanner;
public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Ask user to enter a sentence with mixed formatting
        System.out.println("Please enter a sentence with mixed formatting:");
        String input = scanner.nextLine();

        // TODO: Process the input using the following methods:
        // 1. trim() - Remove extra spaces
        String trimmedInput = input.trim();

        // 2. replace() - Replace all spaces with underscores
        String underscoredInput = trimmedInput.replace(" ", "_");

        // 3. replaceAll() - Remove all digits using regex
        String noDigitsInput = underscoredInput.replaceAll("\\d", "");

        // 4. split() - Split sentence into words array
        String[] wordsArray = noDigitsInput.split("_");

        // 5. join() - Rejoin words with " | " separator
        String joinedInput = String.join(" | ", wordsArray);

        // Output the processed input
        System.out.println("Trimmed Input: " + trimmedInput);
        System.out.println("Underscored Input: " + underscoredInput);
        System.out.println("No Digits Input: " + noDigitsInput);
        System.out.println("Words Array: " + String.join(", ", wordsArray));
        System.out.println("Processed Input: " + joinedInput);

        // TODO: Create additional processing methods:
        // - Remove all punctuation
        String noPunctuationInput = removePunctuation(joinedInput);
        // - Capitalize first letter of each word
        String capitalizedInput = capitalizeWords(noPunctuationInput);
        // - Reverse the order of words
        String reversedInput = reverseWordOrder(capitalizedInput);
        // - Count word frequency
        countWordFrequency(reversedInput);

        // Output the additional processed inputs
        System.out.println("No Punctuation Input: " + noPunctuationInput);
        System.out.println("Capitalized Input: " + capitalizedInput);
        System.out.println("Reversed Input: " + reversedInput);
        System.out.println("Word Frequency Count:");

        scanner.close();
        }

        // TODO: Method to remove punctuation
        public static String removePunctuation(String text) {
        // Your code here
        return text.replaceAll("[^a-zA-Z0-9_ ]", "");
        }

        // TODO: Method to capitalize each word
        public static String capitalizeWords(String text) {
        // Your code here
            String[] words = text.split(" ");
            StringBuilder capitalizedText = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    capitalizedText.append(Character.toUpperCase(word.charAt(0)))
                                .append(word.substring(1)).append(" ");
                }
            }
            return capitalizedText.toString().trim();
        }

        // TODO: Method to reverse word order
        public static String reverseWordOrder(String text) {
            String[] words = text.split(" ");
            StringBuilder reversed = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i]);
                if (i != 0) {
                    reversed.append(" ");
                }
            }
            return reversed.toString();
        }

        // TODO: Method to count word frequency
        public static void countWordFrequency(String text) {
            // Your code here
            String[] words = text.split(" ");
            
    }
}