/**
 * ===========================================================================
 * MAIN CLASS - UseCase2PalindromeCheckerApp
 * ===========================================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 *
 * This use case introduces fundamental comparison logic
 * before using advanced data structures.
 *
 * @author Aaditya Chaturvedy
 * @version 2.0
 */

import java.util.Scanner;

public class UseCase2PalindromeCheckerApp {
    /**
     * Application entry point for UC2
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Boolean palindrome = true;

        System.out.printf("Input text: ");
        String text = scanner.next();

        int length = text.length();

        for(int i = 0; i < length / 2; i++){
            if(text.charAt(i) != text.charAt(length - i - 1)){
                palindrome = false;
                break;
            }
        }

        System.out.printf("Is it a Palindrome? : %s", palindrome);
    }
}
