import java.util.Scanner;

class FindingTheLargestNumber{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the three number: ");

		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();

		System.out.printf("Is the first number the largest ? : %s\n", number1 > number2 && number1 > number3);
		System.out.printf("Is the second number the largest ? : %s\n", number2 > number1 && number2 > number3);
		System.out.printf("Is the third number the largest ? : %s", number3 > number2 && number3 > number1);
		
	}
}