import java.util.Scanner;

class PowerFinder
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number and power: ");

		int number = input.nextInt();
		int power = input.nextInt();

		int result = 1;

		for(int i = 1; i <= power; i++)
		{
			result *= number;
		}

		System.out.println("The result is: " + result);
	}
}