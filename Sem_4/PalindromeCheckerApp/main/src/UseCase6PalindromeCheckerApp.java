/**
 * ===========================================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ===========================================================================
 *
 * Use Case 6: Stack Based Palindrome Checker
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queve (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * @author Aaditya Chaturvedy
 * @version 6.0
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {
    /**
     * Application entry point for UC6
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args){
        // Define the input string to validate
        String input = "civic";

        // Create a Queue to store characters in FIFO order
        Queue<Character> queue = new LinkedList<>();

        // Create a Stack to store characters in LIFO order
        Stack<Character> stack = new Stack<>();

        // Insert each character into both queue and stack
        for (char c : input.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Flag to track palindrome status
        boolean isPalindrome = true;

        // Compare characters until the queue becomes empty
        while (!queue.isEmpty()) {
            if(!queue.poll().equals(stack.pop())){
                isPalindrome = false;
                break;
            }
        }

        System.out.printf("Input : %s", input);
        System.out.printf("\nIs it a Palindrome? : %s", isPalindrome);
    }

}
