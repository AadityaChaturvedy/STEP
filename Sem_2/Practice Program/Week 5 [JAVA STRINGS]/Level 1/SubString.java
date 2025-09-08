import java.util.Scanner;

public class SubString{

	public static String manualSubstring(String str, int startIndex, int endIndex ){
		String result = "";
		for(int i = startIndex; i < endIndex; i++){
			result += str.charAt(i);
		}
		return result;
	}

	public static Boolean compareStrings(String str, String substr){

		if (str.length() != substr.length()) return false;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != substr.charAt(i)) return false;
		}

		return true;

	}

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter string: ");
		String str = input.nextLine();

		System.out.println("Enter start and end index: ");
		int startIndex = input.nextInt();
		int endIndex = input.nextInt();

		String manualSub = manualSubstring(str, startIndex, endIndex);
		String builtInSub = str.substring(startIndex, endIndex);

		boolean isEqual = compareStrings(manualSub, builtInSub);

		System.out.println("\nManual Substring using charAt(): " + manualSub);
        System.out.println("Built-in Substring: " + builtInSub);
		System.out.println("Are both the substrings same: " + isEqual);

		input.close();
	}
}