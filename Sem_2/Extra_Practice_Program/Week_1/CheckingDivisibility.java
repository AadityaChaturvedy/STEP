import java.util.Scanner;

class CheckingDivisibility{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number to check divisibility: ");
		int number = input.nextInt();

		System.out.printf("Is the number %d divisible by 5? %s",number,number%5==0);
	}

}