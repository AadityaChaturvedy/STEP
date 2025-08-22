import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeLogic1(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeLogic2(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    public static boolean isPalindromeLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        String reversedText = new String(reversed);
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String text = scanner.nextLine().toLowerCase();

        System.out.println("Using Logic 1 (Iterative): " + (isPalindromeLogic1(text) ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Using Logic 2 (Recursive): " + (isPalindromeLogic2(text, 0, text.length() - 1) ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Using Logic 3 (Reverse and Compare): " + (isPalindromeLogic3(text) ? "Palindrome" : "Not a Palindrome"));
        
        scanner.close();
    }
}
