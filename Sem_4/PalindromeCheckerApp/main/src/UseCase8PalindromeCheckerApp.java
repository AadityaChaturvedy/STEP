/**
 * ===========================================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ===========================================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a LinkedList.
 *
 * Characters are added to the list and then compared
 * by removing elements from both ends:
 *
 * - removeFirst()
 * - removeLast()
 *
 * This demonstrates how LinkedList supports
 * double-ended operations for symmetric validation.
 *
 * @author Aaditya Chaturvedy
 * @version 8.0
 */

import java.util.LinkedList;

public class UseCase8PalindromeCheckerApp {
    /**
     * Application entry point for UC8
     *
     * @param args Command-line arguments
     */

    public static void main(String[] args){
        // Define the input string
        String input = "level";

        // Create a LinkedList to store characters
        LinkedList<Character> list = new LinkedList<>();

        // Add each character to the linked list
        for (char c : input.toCharArray()) {
            list.add(c);
        }

        // Flag to track palindrome state
        boolean isPalindrome = true;

        // Compare until only one or zero elements remain
        while (list.size() > 1) {
            if(list.removeFirst() != list.removeLast()){
                isPalindrome = false;
                break;
            }
        }

        System.out.printf("Input : %s", input);
        System.out.printf("\nIs it a Palindrome? : %s", isPalindrome);
    }

}
