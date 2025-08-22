import java.util.Scanner;

public class VowelAndConsonant {

    public static int checkCharacterType(char ch) {
        char lowerCh = ch;
        if (ch >= 65 && ch <= 90) {
            lowerCh = (char) (ch + 32);
        }

        if (lowerCh >= 97 && lowerCh <= 122) {
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            int type = checkCharacterType(text.charAt(i));
            if (type == 1) {
                vowelCount++;
            } else if (type == -1) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
        sc.close();
    }
}
