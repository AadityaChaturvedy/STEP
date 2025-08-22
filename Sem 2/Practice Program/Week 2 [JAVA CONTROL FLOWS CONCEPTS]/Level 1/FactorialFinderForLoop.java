import java.util.Scanner;

class FactorialFinderForLoop{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		int factorial = 1;

		System.out.println("Enter a number: ");
		int num = input.nextInt();

		for(int i = 1; i <= num; i++)
		{
			factorial *= i;
		}

		System.out.println("The factorial of the entered number is: " + factorial);

	}

}