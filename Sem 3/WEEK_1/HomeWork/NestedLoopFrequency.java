import java.util.Scanner;

public class NestedLoopFrequency {

    public static String[] findFrequencies(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        boolean[] visited = new boolean[chars.length];
        int uniqueCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            int count = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            freq[i] = count;
            uniqueCount++;
        }

        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                result[index++] = "'" + chars[i] + "': " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[] frequencies = findFrequencies(text);

        System.out.println("Character frequencies:");
        for (String entry : frequencies) {
            if (entry != null) {
                System.out.println(entry);
            }
        }
        scanner.close();
    }
}
