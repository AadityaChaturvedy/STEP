import java.util.Scanner;

public class CompareStrings{

	public static boolean compareCharacters(String str1, String str2)
	{
		int length = str1.length();

		if(str1.length() != str2.length()){
			return false;
		}else{
			for(int i = 0; i < length; i++)
			{
				if(str1.charAt(i) != str2.charAt(i)){
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter string 1: ");
		String str1 = input.nextLine();

		System.out.println("Enter string 2: ");
		String str2 = input.nextLine();

		if (str1.equals(str2)){
			System.out.println("The two entered strings are same.");
		}else{
			System.out.println("The two entered strings are NOT same.");
		}

		System.out.println("Comparison using charAt(): ");

		System.out.println("The two string are same: " + compareCharacters(str1, str2));
	}
}