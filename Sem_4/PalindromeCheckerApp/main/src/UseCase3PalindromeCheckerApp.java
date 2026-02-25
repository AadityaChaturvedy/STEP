/**
 * ===========================================================================
 * MAIN CLASS - UseCase3PalindromeCheckerApp
 * ===========================================================================
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 *
 * This introduces transformation-based validation.
 *
 * @author Aaditya Chaturvedy
 * @version 3.0
 */

import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {
    /**
     * Application entry point for UC3
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Boolean palindrome = true;

        System.out.printf("Input text: ");
        String text = scanner.next();
        String reverseText = new String();

        int length = text.length();

        for(int i = text.length() - 1; i >= 0; i--){
            reverseText += text.charAt(i);
        }

        if (!text.equals(reverseText)) palindrome = false;

        System.out.printf("Is it a Palindrome? : %s", palindrome);
    }
}
