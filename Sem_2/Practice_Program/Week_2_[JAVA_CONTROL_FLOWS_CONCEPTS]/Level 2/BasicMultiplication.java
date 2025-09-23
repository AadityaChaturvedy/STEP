import java.util.Scanner;

class BasicMultiplication
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number from 6 to 9: ");
		int number = input.nextInt();

		for(int i = 1; i <= 10; i++)
		{
			System.out.printf("%d * %d = %d\n",number, i, number * i);
		}
	}
}