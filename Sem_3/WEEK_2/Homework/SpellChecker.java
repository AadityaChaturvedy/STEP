import java.util.Scanner;
import java.util.ArrayList;

public class SpellChecker {

    // Splits the sentence into words without using the split() method
    public static ArrayList<String> splitSentence(String sentence) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words;
    }

    // Calculates a simple string distance
    public static int calculateDistance(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return Math.abs(word1.length() - word2.length());
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    // Finds the closest matching word from the dictionary
    public static String findClosestWord(String word, String[] dictionary) {
        String suggestion = "";
        int minDistance = Integer.MAX_VALUE;
        for (String dictWord : dictionary) {
            int distance = calculateDistance(word.toLowerCase(), dictWord);
            if (distance < minDistance) {
                minDistance = distance;
                suggestion = dictWord;
            }
        }
        return (minDistance <= 2) ? suggestion : "No suggestion";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dictionary = {"hello", "world", "java", "programming", "is", "fun"};

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        ArrayList<String> words = splitSentence(sentence);

        System.out.println("\n--- Spell Check Report ---");
        System.out.printf("%-15s %-15s %-15s\n", "Original Word", "Status", "Suggestion");
        System.out.println("-------------------------------------------------");

        for (String word : words) {
            boolean isCorrect = false;
            for (String dictWord : dictionary) {
                if (word.equalsIgnoreCase(dictWord)) {
                    isCorrect = true;
                    break;
                }
            }

            if (isCorrect) {
                System.out.printf("%-15s %-15s %-15s\n", word, "Correct", "-");
            } else {
                String suggestion = findClosestWord(word, dictionary);
                System.out.printf("%-15s %-15s %-15s\n", word, "Misspelled", suggestion);
            }
        }
        scanner.close();
    }
}