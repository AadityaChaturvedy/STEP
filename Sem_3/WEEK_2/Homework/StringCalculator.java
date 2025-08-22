import java.util.ArrayList;
import java.util.Scanner;

public class StringCalculator {

    public static double evaluateExpression(String expression) {
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        
        // Parse numbers and operators
        String currentNumber = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                currentNumber += c;
            } else {
                numbers.add(Double.parseDouble(currentNumber));
                currentNumber = "";
                operators.add(c);
            }
        }
        numbers.add(Double.parseDouble(currentNumber));

        // Handle multiplication and division first
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*' || operators.get(i) == '/') {
                double result = (operators.get(i) == '*') ? numbers.get(i) * numbers.get(i + 1) : numbers.get(i) / numbers.get(i + 1);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }
        
        // Handle addition and subtraction
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result += numbers.get(i + 1);
            } else if (operators.get(i) == '-') {
                result -= numbers.get(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression (e.g., 10+5*2-3):");
        String expression = scanner.nextLine().replaceAll("\\s", "");
        
        try {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid expression format.");
        }
        scanner.close();
    }
}