/**
 * ===========================================================================
 * MAIN CLASS - UseCase1PalindromeApp
 * ===========================================================================
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Palindrome Checker Management System.
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message
 * - Shows application version
 *
 * No palindrome logic is implemented yet.
 *
 * The goal is to establish a clear startup flow.
 *
 * @author Aaditya Chaturvedy
 * @version 1.0
 */

public class UseCase1PalindromeApp {
    /**
     * Application entry point.
     *
     * This is the first method exeecuted by the JVM
     * when the program starts.
     * @param args
     */
    public static void main(String[] args){

        double version = 1.0;

        System.out.printf("Welcome to the Palindrome Checker Management System");
        System.out.printf("\nVersion : %s", version);
        System.out.printf("\nSystem initialized successfully");

    }
}
