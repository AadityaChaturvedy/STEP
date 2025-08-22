import java.util.Scanner;

public class EmailAnalyzer {

    public static boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');
        return atPos > 0 && dotPos > atPos && email.indexOf('@') == email.lastIndexOf('@');
    }

    public static void analyzeEmail(String email) {
        if (isValidEmail(email)) {
            System.out.println("Email is valid.");
            int atPos = email.indexOf('@');
            String username = email.substring(0, atPos);
            String domain = email.substring(atPos + 1);
            System.out.println("Username: " + username);
            System.out.println("Domain: " + domain);
        } else {
            System.out.println("Email is invalid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email address to analyze:");
        String email = scanner.nextLine();
        analyzeEmail(email);
        scanner.close();
    }
}