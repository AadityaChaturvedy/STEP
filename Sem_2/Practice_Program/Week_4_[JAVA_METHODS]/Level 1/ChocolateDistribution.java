import java.util.Scanner;

class ChocolateDistribution{

	public static int[] findRemainderAndQuotient(int number, int divisor)
	{
		int remainder = number % divisor;
		int quotient = number / divisor;

		return new int[]{remainder, quotient};
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Number Of Chocolates and Children: ");

		int numberOfChocolates = input.nextInt();
		int numberOfChildren = input.nextInt();

		int[] RemainderAndQuotient = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

		System.out.println("Number of Chocolates remaining: " + RemainderAndQuotient[0]);
		System.out.println("Number of Chocolates each child will get is: " + RemainderAndQuotient[1]);

	}
}