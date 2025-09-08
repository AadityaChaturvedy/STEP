import java.util.Scanner;

class CountdownUsingFor{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the starting number: ");
		int number = input.nextInt();

		System.out.println("\nCountdown: ");

		for(int i = number; i >= 1; i--)
		{
			System.out.println(i);
		}
	}
}