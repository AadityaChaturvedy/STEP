import java.util.Scanner;

public class LengthOfString {

    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.println("Length using custom method: " + findStringLength(text));
        System.out.println("Length using built-in method: " + text.length());
        sc.close();
    }
}