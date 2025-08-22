import java.util.Scanner;

class FactorialFinderWhileLoop{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		int factorial = 1;

		System.out.println("Enter a number: ");
		int num = input.nextInt();
		int i = 1;

		while(i <= num)
		{
			factorial = factorial * i;
			i++;
		}

		System.out.println("The factorial of the entered number is: " + factorial);

	}

}