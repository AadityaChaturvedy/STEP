import java.util.Scanner;

public class UniqueCharFrequency {

    public static char[] findUniqueCharacters(String text) {
        String uniqueStr = "";
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (uniqueStr.indexOf(currentChar) == -1) {
                uniqueStr += currentChar;
            }
        }
        return uniqueStr.toCharArray();
    }

    public static String[][] findFrequencies(String text) {
        char[] uniqueChars = findUniqueCharacters(text);
        int[] frequencies = new int[256];

        for (char ch : text.toCharArray()) {
            frequencies[ch]++;
        }

        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = "'" + ch + "'";
            result[i][1] = String.valueOf(frequencies[ch]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[][] frequencies = findFrequencies(text);

        System.out.println("Character frequencies:");
        for (String[] entry : frequencies) {
            System.out.println(entry[0] + ": " + entry[1]);
        }
        scanner.close();
    }
}
