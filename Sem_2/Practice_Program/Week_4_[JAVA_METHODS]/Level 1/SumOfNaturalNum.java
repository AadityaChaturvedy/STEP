import java.util.Scanner;

class SumOfNaturalNum{

	public static int SumOfNum(int n)
	{
		int sum = 0;

		for(int i = 0; i <= n; i++)
		{
			sum += i;
		}

		return sum;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int num = input.nextInt();

		System.out.printf("The sum of %d natural numbers is : %d", num, SumOfNum(num));
	}
}