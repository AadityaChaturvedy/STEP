import java.util.Scanner;

public class WordInArray {

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

    public static String[][] getWordsAndLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findStringLength(words[i]));
        }
        return result;
    }

    public static void displayTable(String[][] data, String[] headers) {
        for (String header : headers) {
            System.out.printf("%-15s", header);
        }
        System.out.println();
        for (String[] row : data) {
            for (String cell : row) {
                System.out.printf("%-15s", cell);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();
        String[] words = splitTextIntoWords(text);
        String[][] wordsAndLengths = getWordsAndLengths(words);
        String[] headers = {"Word", "Length"};
        System.out.println("Words and their lengths:");
        displayTable(wordsAndLengths, headers);
        sc.close();
    }
}
