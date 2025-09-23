import java.util.Scanner;

class FizzBuzz
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();
		int i = 1;

		String[] result = new String[number+1];

		if(number > 0)
		{
			while(i <= number)
			{
				if(i % 3 == 0 && i % 5 != 0)
					result[i] = "Fizz";
				else if(i % 3 != 0 && i % 5 == 0)
					result[i] = "Buzz";
				else if(i % 3 == 0 && i % 5 == 0)
					result[i] = "FizzBuzz";
				else
					result[i] = Integer.toString(i);

				i++;
			}
		}
		else
		{
			System.out.println("The number inputed is not a positive integer.");
		}
		
		System.out.println("");

		for(int j = 1; j <= number; j++)
		{
			System.out.print(result[j] + " ");
		}
	}
}