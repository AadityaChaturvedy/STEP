import java.util.Scanner;

public class IndexBoundsException{

	public static char ExceptionTest(String str)
	{
		return str.charAt(100);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String text = input.nextLine();

		try{
			System.out.println(ExceptionTest(text));
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("StringIndexOutOfBoundsException => " + e.getMessage());
		}

		System.out.println(text.charAt(100));
	}
}