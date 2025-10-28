import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses{
    public static boolean isBalanced(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("The string is empty or null.");
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character a = stack.pop();
                if ((ch == ')' && a != '(') ||
                    (ch == '}' && a != '{') ||
                    (ch == ']' && a != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();
        if (isBalanced(input)) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
        scanner.close();
    }
}