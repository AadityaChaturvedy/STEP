import java.util.Scanner;

public class CaseConverter {

    public static String toUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) (c - 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String toLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalize = true;
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalize = true;
                result.append(c);
            } else if (capitalize) {
                if (c >= 'a' && c <= 'z') {
                    result.append((char) (c - 32));
                } else {
                    result.append(c);
                }
                capitalize = false;
            } else {
                if (c >= 'A' && c <= 'Z') {
                    result.append((char) (c + 32));
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to convert:");
        String inputText = scanner.nextLine();

        System.out.println("Original: " + inputText);
        System.out.println("Uppercase: " + toUpperCase(inputText));
        System.out.println("Lowercase: " + toLowerCase(inputText));
        System.out.println("Title Case: " + toTitleCase(inputText));
        
        scanner.close();
    }
}