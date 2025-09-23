import java.util.Scanner;

public class NumberFormatExceptionDemo{

	public static int NumFormatExpt(String text)
	{
		return Integer.parseInt(text);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = input.nextLine();

		try{
			NumFormatExpt(str);
		}catch(NumberFormatException e)
		{
			System.out.println("NumberFormatException: " + e.getMessage());
		}

		try{
			NumFormatExpt(str);
		}catch(RuntimeException e)
		{
			System.out.println("Runtime exception caught: " + e.getMessage());
		}		
	}
}