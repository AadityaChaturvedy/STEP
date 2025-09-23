import java.util.Scanner;

class SmallestAndLargestCalc{

	public static int[] findSmallestAndLargest(int number1, int number2, int number3)
	{
		int minimumNum = Math.min(number1, Math.min(number2, number3));
		int maximumNum = Math.max(number1, Math.max(number2, number3));

		return new int[]{minimumNum, maximumNum};
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter 3 numbers for comparison: ");

		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();

		int[] minMax = findSmallestAndLargest(number1, number2, number3);

		System.out.println("The minimum number is: " + minMax[0]);
		System.out.println("The maximum number is: " + minMax[1]);
	}
}