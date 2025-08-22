import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {

    // Analyzes and scores password strength
    public static String analyzePassword(String password) {
        int score = 0;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        // Add points for length
        if (password.length() >= 8) {
            score += (password.length() - 8) * 2;
        }

        for (char c : password.toCharArray()) {
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else hasSpecial = true;
        }

        if (hasUpper) score += 10;
        if (hasLower) score += 10;
        if (hasDigit) score += 10;
        if (hasSpecial) score += 10;
        
        // Deduct points for common patterns
        if (password.toLowerCase().contains("123") || password.toLowerCase().contains("abc")) {
            score -= 5;
        }

        if (score > 50) return "Strong";
        if (score > 20) return "Medium";
        return "Weak";
    }

    // Generates a strong password
    public static String generateStrongPassword(int length) {
        if (length < 8) length = 8; // Ensure minimum length for strength
        StringBuilder password = new StringBuilder();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()";
        String allChars = upper + lower + digits + special;
        Random random = new Random();

        // Ensure at least one of each character type
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the characters for better randomness
        List<Character> chars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : chars) {
            shuffledPassword.append(c);
        }
        return shuffledPassword.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password to analyze:");
        String passwordToAnalyze = scanner.nextLine();
        System.out.println("Password strength: " + analyzePassword(passwordToAnalyze));

        System.out.println("\nEnter desired length for a new password:");
        int length = scanner.nextInt();
        System.out.println("Generated strong password: " + generateStrongPassword(length));
        
        scanner.close();
    }
}