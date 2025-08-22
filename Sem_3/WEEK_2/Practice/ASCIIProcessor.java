import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // For each character in the string:
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            String type = classifyCharacter(ch);
            System.out.println("Character: '" + ch + "' | ASCII: " + ascii + " | Type: " + type);

            if (type.equals("Uppercase Letter") || type.equals("Lowercase Letter")) {
                char toggled = toggleCase(ch);
                System.out.println("  Toggle case: '" + toggled + "' | ASCII: " + (int) toggled);
                int diff = Math.abs(Character.toUpperCase(ch) - Character.toLowerCase(ch));
                System.out.println("  ASCII difference between cases: " + diff);
            }
        }

        // Create ASCII art using character codes
        System.out.println("\nASCII Art:");
        for (char ch : input.toCharArray()) {
            for (int i = 0; i < (int) ch % 10 + 1; i++) {
                System.out.print(ch);
            }
            System.out.print(" ");
        }
        System.out.println();

        // Implement a simple Caesar cipher using ASCII manipulation
        System.out.print("\nEnter Caesar cipher shift: ");
        int shift = scanner.nextInt();
        String ciphered = caesarCipher(input, shift);
        System.out.println("Caesar Cipher: " + ciphered);

        // Display ASCII table for a range
        System.out.println("\nASCII Table (65-90):");
        displayASCIITable(65, 90);

        // Convert string to ASCII array and back
        int[] asciiArr = stringToASCII(input);
        System.out.println("\nASCII Array: " + java.util.Arrays.toString(asciiArr));
        String fromAscii = asciiToString(asciiArr);
        System.out.println("String from ASCII Array: " + fromAscii);

        scanner.close();
    }

    // Method to classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    // Method to convert case using ASCII manipulation
    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) (ch + 32);
        } else if (Character.isLowerCase(ch)) {
            return (char) (ch - 32);
        }
        return ch;
    }

    // Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append((char) ((ch - 'A' + shift + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                sb.append((char) ((ch - 'a' + shift + 26) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Method to create ASCII table for a range
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " : " + (char) i);
        }
    }

    // Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = (int) text.charAt(i);
        }
        return arr;
    }

    // Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}