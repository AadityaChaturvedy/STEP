import java.util.Scanner;

class CheckNumberSign{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		if (number == 0)
			System.out.println("The number is: Zero.");
		else if (number * (-1) == number)
			System.out.println("The number is: Negative.");
		else
			System.out.println("The number is: Positive.");
	}
}