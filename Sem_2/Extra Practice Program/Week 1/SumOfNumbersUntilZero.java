import java.util.Scanner;

class SumOfNumbersUntilZero{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		int numberSelected = 0, numberSum = 0;

		while (true)
		{
			System.out.println("Enter number: ");
			numberSelected = input.nextInt();

			if(numberSelected == 0)
				break;
			else
				numberSum += numberSelected;
			
		}

		System.out.println("The sum of the numbers entered: " + numberSum);

	}
}