public class StringManipulation{
public static void main(String[] args) {
    String str1 = "Java Programming";
    String str2 = new String("Java Programming");
    char[] str3 = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};

    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));

    System.out.println("\"Code is poetry\"");
    System.out.println("- Unknown");
    }
}
