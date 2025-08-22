import java.util.Scanner;

class SumOfNaturalNumWhileLoop{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		int i = 0, SumOfI = 0;

		while(i <= number)
		{
			SumOfI += i;
			i++;
		}

		System.out.println("The result by calculating using while loop: " + SumOfI);

		System.out.printf("The result by calculating using formula is: %d", number*(number+1)/2);
	}

}