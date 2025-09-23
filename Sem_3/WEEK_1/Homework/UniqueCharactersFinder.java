import java.util.Scanner;

public class UniqueCharactersFinder {

    public static int getTextLength(String text) {
        int length = 0;
        try {
            for (length = 0; ; length++) {
                text.charAt(length);
            }
        } catch (StringIndexOutOfBoundsException e) {
            return length;
        }
    }

    public static char[] findUniqueCharacters(String text) {
        int textLength = getTextLength(text);
        char[] uniqueCharsTemp = new char[textLength];
        int uniqueCount = 0;

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCharsTemp[uniqueCount++] = currentChar;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueCharsTemp[i];
        }
        return uniqueChars;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        char[] unique = findUniqueCharacters(text);

        System.out.print("Unique characters are: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }
        System.out.println();
        scanner.close();
    }
}
