import java.util.Scanner;

class SumOfNaturalNumForLoop{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		int SumOfI = 0;

		for (int i = 0; i <= number; i++)
		{
			SumOfI += i;
		}

		System.out.println("The result by calculating using while loop: " + SumOfI);

		System.out.printf("The result by calculating using formula is: %d", number*(number+1)/2);
	}

}