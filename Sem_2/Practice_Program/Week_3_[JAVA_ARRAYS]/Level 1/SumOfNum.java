import java.util.Scanner;

class SumOfNum{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		double[] numberArray = new double[10];
		double sum = 0.0;
		int index = 0;

		while(true)
		{	
			System.out.print("Enter a number: ");
			double valueInput = input.nextDouble();

			if(valueInput > 0 && index != 10)
			{
				numberArray[index] = valueInput;
				index++;
			}else{
				break;
			}
		}

		for(int i = 0; i < 5; i++)
		{
			sum += numberArray[i];
		}

		System.out.println("The sum of entered numbers is: " + sum);

	}
}