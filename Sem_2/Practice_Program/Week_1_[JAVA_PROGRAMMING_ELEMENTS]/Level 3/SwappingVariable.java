import java.util.Scanner;

class SwappingVariable{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter first number: ");
		int number1 = input.nextInt();

		System.out.println("Enter second number: ");
		int number2 = input.nextInt();

		int tempnum = number1;
		number1 = number2;
		number2 = tempnum;

		System.out.printf("The swapped numbers are %d and %d.", number1,number2);

	}
}