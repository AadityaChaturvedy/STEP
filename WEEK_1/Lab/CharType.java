import java.util.Scanner;

public class CharType {

    public static int checkCharacterType(char ch) {
        char lowerCh = ch;
        if (ch >= 65 && ch <= 90) {
            lowerCh = (char) (ch + 32);
        }

        if (lowerCh >= 97 && lowerCh <= 122) {
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            int type = checkCharacterType(ch);
            if (type == 1) {
                result[i][1] = "Vowel";
            } else if (type == -1) {
                result[i][1] = "Consonant";
            } else {
                result[i][1] = "Not a Letter";
            }
        }
        return result;
    }

    public static void displayTable(String[][] data, String[] headers) {
        for (String header : headers) {
            System.out.printf("%-15s", header);
        }
        System.out.println();
        for (String[] row : data) {
            for (String cell : row) {
                System.out.printf("%-15s", cell);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String[][] characterTypes = getCharacterTypes(text);
        String[] headers = {"Character", "Type"};
        System.out.println("Character types:");
        displayTable(characterTypes, headers);
        sc.close();
    }
}
