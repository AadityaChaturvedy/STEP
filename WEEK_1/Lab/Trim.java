import java.util.Scanner;

public class Trim {

    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String text = sc.nextLine();
        int[] trimIndices = findTrimIndices(text);
        String customTrimmed = createSubstring(text, trimIndices[0], trimIndices[1]);
        String builtInTrimmed = text.trim();
        System.out.println("Original String: '" + text + "'");
        System.out.println("Trimmed (custom): '" + customTrimmed + "'");
        System.out.println("Trimmed (built-in): '" + builtInTrimmed + "'");
        System.out.println("Do they match? " + compareStrings(customTrimmed, builtInTrimmed));
        sc.close();
    }
}
