import java.util.Scanner;

class FizzBuzzFor
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		if(number > 0)
		{
			System.out.println("\nOutput: ");

			for(int i = 1; i <= number; i++)
			{
				if(i % 3 == 0 && i % 5 != 0)
					System.out.println("Fizz");
				else if(i % 3 != 0 && i % 5 == 0)
					System.out.println("Buzz");
				else if(i % 3 == 0 && i % 5 == 0)
					System.out.println("FizzBuzz");
				else
					System.out.println(i);
			}
		}
		else
		{
			System.out.println("The number inputed is not a positive integer.");
		}
	}
}