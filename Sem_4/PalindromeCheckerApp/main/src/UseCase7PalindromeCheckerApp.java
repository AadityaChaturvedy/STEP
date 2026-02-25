/**
 * ===========================================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ===========================================================================
 *
 * Use Case 7: Deque Based Optimized Palindrome Checke
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue).
 *
 * Characters are inserted into the deque and then
 * compared by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This avoids reversing the string and provides an
 * efficient front-to-back comparison approach.
 *
 * This use case demonstrates optimal bidirectional
 * traversal using Deque.
 *
 * @author Aaditya Chaturvedy
 * @version 7.0
 */

import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase7PalindromeCheckerApp {
    /**
     * Application entry point for UC7
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args){
        // Define the input string
        String input = "refer";

        // Create a Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to the deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        // Flag to track palindrome result
        boolean isPalindrome = true;

        // Continue comparison while more than one element exists
        while (deque.size() > 1) {
            if(deque.removeFirst() != deque.removeLast()){
                isPalindrome = false;
                break;
            }
        }

        System.out.printf("Input : %s", input);
        System.out.printf("\nIs it a Palindrome? : %s", isPalindrome);
    }

}
