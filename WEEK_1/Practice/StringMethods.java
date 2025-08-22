import java.util.Scanner;
public class StringMethods{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your favorite programming language: ");
        String progLang = scanner.nextLine();
        
        System.out.println("Enter a sentence about your programming experience: ");
        String progExp = scanner.nextLine();

        // 1. Extract first and last name separately
        String[] nameParts = name.trim().split("\\s+");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        // 2. Count total characters in the sentence (excluding spaces)
        int charCount = progExp.replace(" ", "").length();

        // 3. Convert programming language to uppercase
        progLang.toUpperCase();

        // 4. Display a formatted summary
        System.out.println("---------Summary---------");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favourite Language (uppercase): " + progLang);
        System.out.println("Experience Sentence: " + progExp);
        System.out.println("Total Characters (excluding spaces): " + charCount);

        scanner.close();
    }
}