import java.util.Scanner;

class SumOfNumbersUntilZeroNegative{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		double total = 0.0, numberSelected = 0;

		while (true)
		{
			System.out.println("Enter number: ");
			numberSelected = input.nextDouble();

			if(numberSelected <= 0)
				break;
			else
				total += numberSelected;
			
		}

		System.out.println("The sum of the numbers entered: " + total);

	}
}