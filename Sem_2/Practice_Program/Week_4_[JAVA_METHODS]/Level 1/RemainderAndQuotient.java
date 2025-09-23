import java.util.Scanner;

class RemainderAndQuotient{

	public static int[] findRemainderAndQuotient(int number, int divisor)
	{
		int remainder = number % divisor;
		int quotient = number / divisor;

		return new int[]{remainder, quotient};
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number and divisor: ");

		int number = input.nextInt();
		int divisor = input.nextInt();

		int[] RemainderAndQuotient = findRemainderAndQuotient(number, divisor);

		System.out.println("Remainder is: " + RemainderAndQuotient[0]);
		System.out.println("Quotient is: " + RemainderAndQuotient[1]);

	}
}