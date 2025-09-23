import java.util.Scanner;

class NumberChecker{

	public static int numCheck(int num)
	{
		if(num < 0)
			return -1;
		else if (num == 0)
			return 0;
		else
			return 1;
	}


	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int number = input.nextInt();

		System.out.printf("Output: %d", numCheck(number));
	}
}