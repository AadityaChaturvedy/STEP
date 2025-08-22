import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                result.append((char) ('a' + (character - 'a' + shift) % 26));
            } else if (character >= 'A' && character <= 'Z') {
                result.append((char) ('A' + (character - 'A' + shift) % 26));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String text = scanner.nextLine();

        System.out.println("Enter the shift value:");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(text, shift);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}