import java.util.Scanner;
import java.util.Arrays;

public class StringToChar{

	public static char[] stringArray(String str){

		char[] ArrayOfStr = new char[str.length()];

		for(int i = 0; i < str.length(); i++)
		{
			ArrayOfStr[i] = str.charAt(i);
		}

		return ArrayOfStr;
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		String str = "testString";
		char[] strArray1 = str.toCharArray();
		char[] strArray2 = stringArray(str);

		if(Arrays.equals(strArray1,strArray2))
			System.out.println("The two array are same.");
		else
			System.out.println("The two array are not same.");

	}
}