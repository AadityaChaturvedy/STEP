import java.util.Scanner;

public class CharacterFrequencyCounter {

    public static String[][] findCharacterFrequencies(String text) {
        int[] freq = new int[256];
        int uniqueCharCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 0) {
                uniqueCharCount++;
            }
            freq[ch]++;
        }
        
        String[][] result = new String[uniqueCharCount][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = "'" + ch + "'";
                result[index][1] = String.valueOf(freq[ch]);
                index++;
                freq[ch] = 0; 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[][] frequencies = findCharacterFrequencies(text);

        System.out.println("Character frequencies:");
        for (String[] entry : frequencies) {
            System.out.println(entry[0] + ": " + entry[1]);
        }
        scanner.close();
    }
}
