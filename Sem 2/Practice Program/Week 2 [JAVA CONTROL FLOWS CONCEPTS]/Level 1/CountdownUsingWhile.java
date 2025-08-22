import java.util.Scanner;

class CountdownUsingWhile{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the starting number: ");
		int number = input.nextInt();
		int i = 0;

		System.out.println("\nCountdown: ");

		while(number > i)
		{
			System.out.println(number);
			number--;
		}
	}
}