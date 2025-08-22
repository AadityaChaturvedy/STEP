import java.util.Scanner;
    public class TextProcessor{

    public static String cleanInput(String input) {

        String cleaned = input.trim().replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : cleaned.toCharArray()) {
            if (capitalize && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                capitalize = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
            if (c == '.' || c == '!' || c == '?') {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    public static void analyzeText(String text) {
        
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        int sentenceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') sentenceCount++;
        }

        int charCount = 0;
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) charCount++;
        }

        String longestWord = "";
        for (String w : words) {
            String cleanW = w.replaceAll("[^a-zA-Z]", "");
            if (cleanW.length() > longestWord.length()) longestWord = cleanW;
        }

        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) freq[Character.toLowerCase(c)]++;
        }

        char mostCommon = ' ';
        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq && i != ' ') {
                maxFreq = freq[i];
                mostCommon = (char) i;
            }
        }

        System.out.println("Word count: " + wordCount);
        System.out.println("Sentence count: " + sentenceCount);
        System.out.println("Character count (no spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommon + "' (" + maxFreq + " times)");
    }

    public static String[] getWordsSorted(String text) {

        String cleaned = text.replaceAll("[.,!?;:]", "");
        String[] words = cleaned.trim().split("\\s+");
        java.util.Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned text: " + cleaned);

        System.out.println("\n--- Text Analysis ---");
        analyzeText(cleaned);

        System.out.println("\n--- Words in Alphabetical Order ---");
        String[] sortedWords = getWordsSorted(cleaned);
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search for (or 'exit' to quit): ");
        String search = scanner.nextLine().trim();
        while (!search.equalsIgnoreCase("exit")) {
            boolean found = false;
            for (String word : sortedWords) {
                if (word.equalsIgnoreCase(search)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Word '" + search + "' found in text.");
            } else {
                System.out.println("Word '" + search + "' NOT found in text.");
            }
            System.out.print("Enter another word to search for (or 'exit' to quit): ");
            search = scanner.nextLine().trim();
        }
        scanner.close();
    }
}