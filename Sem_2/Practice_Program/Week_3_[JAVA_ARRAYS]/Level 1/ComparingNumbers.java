import java.util.Scanner;

class ComparingNumbers
{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		int[] numberArray = new int[5];

		for(int i = 0; i < 5; i++)
		{
			System.out.print("Enter a number: ");
			numberArray[i] = input.nextInt();
		}

		for(int i = 0; i < 5; i++)
		{
			if (numberArray[i] > 0 && numberArray[i] % 2 == 0)
				System.out.printf("The entered number %d is positive and even.\n",numberArray[i]);
			else if (numberArray[i] > 0 && numberArray[i] % 2 != 0)
				System.out.printf("The entered number %d is positive and odd.\n",numberArray[i]);
			else if (numberArray[i] < 0)
				System.out.printf("The entered number %d is negative.\n",numberArray[i]);
			else
				System.out.println("The entered number is 0.");
		}

		if(numberArray[0] > numberArray[4])
			System.out.println("First number is greater than the last number.");
		else if(numberArray[0] < numberArray[4])
			System.out.println("First number is smaller than the last number.");
		else
			System.out.println("First number and the last number is equal.");

	}
}