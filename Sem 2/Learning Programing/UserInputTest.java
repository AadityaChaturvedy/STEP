import java.util.Scanner;

class UserInputTest{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter first number: ");
		int num1 = input.nextInt();

		System.out.println("Enter second number: ");
		int num2 = input.nextInt();

		int num3 = num1 + num2;

		System.out.println("The sum of the two entered numbers is: " + num3);

		input.close();
	}
}