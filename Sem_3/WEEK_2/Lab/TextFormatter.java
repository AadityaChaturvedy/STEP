import java.util.Scanner;
import java.util.ArrayList;

public class TextFormatter {

    public static ArrayList<String> splitIntoWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words;
    }

    public static String justifyText(String text, int width) {
        ArrayList<String> words = splitIntoWords(text);
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > width) {
                result.append(currentLine).append("\n");
                currentLine.setLength(0);
            }
            if (currentLine.length() > 0) {
                currentLine.append(" ");
            }
            currentLine.append(word);
        }
        result.append(currentLine);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to format:");
        String text = scanner.nextLine();

        System.out.println("Enter the desired line width:");
        int width = scanner.nextInt();

        String justifiedText = justifyText(text, width);
        System.out.println("\nFormatted Text:");
        System.out.println(justifiedText);

        scanner.close();
    }
}