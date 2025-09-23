import java.util.Scanner;

public class StringToLowercase{

	public static String ConvertToLowercase(String str)
	{
		String result = "";

		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
			{
				ch = (char)(ch + 32);
			}

			result += ch;
		}

		return result;
	}

	public static boolean CompareStrings(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}else
		{
			for(int i = 0; i < str1.length(); i++)
			{
				if(str1.charAt(i) != str2.charAt(i))
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = input.nextLine();

		String lowercaseStr = ConvertToLowercase(str);

		System.out.println("The two strings are equal: " + CompareStrings(str.toLowerCase(),lowercaseStr));
	}
}