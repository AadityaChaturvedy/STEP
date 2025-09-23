import java.util.Scanner;

class FizzBuzzWhile
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();
		int i = 1;

		if(number > 0)
		{
			System.out.println("\nOutput: ");

			while(i <= number)
			{
				if(i % 3 == 0 && i % 5 != 0)
					System.out.println("Fizz");
				else if(i % 3 != 0 && i % 5 == 0)
					System.out.println("Buzz");
				else if(i % 3 == 0 && i % 5 == 0)
					System.out.println("FizzBuzz");
				else
					System.out.println(i);

				i++;
			}
		}
		else
		{
			System.out.println("The number inputed is not a positive integer.");
		}
	}
}