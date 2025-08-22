import java.util.Scanner;
import java.util.Arrays;

public class SplittingSentence {

    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitTextIntoWords(String text) {
        int wordCount = 0;
        boolean inWord = false;
        int len = findStringLength(text);
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) {
                    words[wordIndex++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        if (start < len) {
            words[wordIndex] = text.substring(start, len);
        }
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] customSplit = splitTextIntoWords(text);
        String[] builtInSplit = text.split(" ");
        System.out.println("Words from custom method: " + Arrays.toString(customSplit));
        System.out.println("Words from built-in method: " + Arrays.toString(builtInSplit));
        System.out.println("Do the arrays match? " + compareStringArrays(customSplit, builtInSplit));
        sc.close();
    }
}
