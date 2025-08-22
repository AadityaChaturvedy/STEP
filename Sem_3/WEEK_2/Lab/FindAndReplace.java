import java.util.Scanner;
import java.util.ArrayList;

public class FindAndReplace {

    public static ArrayList<Integer> findOccurrences(String text, String toFind) {
        ArrayList<Integer> occurrences = new ArrayList<>();
        int index = text.indexOf(toFind);
        while (index != -1) {
            occurrences.add(index);
            index = text.indexOf(toFind, index + 1);
        }
        return occurrences;
    }

    public static String replaceSubstring(String text, String toFind, String toReplace) {
        ArrayList<Integer> occurrences = findOccurrences(text, toFind);
        if (occurrences.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        for (int index : occurrences) {
            result.append(text.substring(lastIndex, index));
            result.append(toReplace);
            lastIndex = index + toFind.length();
        }
        result.append(text.substring(lastIndex));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text = scanner.nextLine();

        System.out.println("Enter the substring to find:");
        String toFind = scanner.nextLine();

        System.out.println("Enter the replacement string:");
        String toReplace = scanner.nextLine();

        String result = replaceSubstring(text, toFind, toReplace);
        System.out.println("Original text: " + text);
        System.out.println("Text after replacement: " + result);

        scanner.close();
    }
}