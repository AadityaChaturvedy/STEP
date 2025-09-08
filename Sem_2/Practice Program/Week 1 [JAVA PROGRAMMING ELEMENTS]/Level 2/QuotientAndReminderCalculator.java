import java.util.Scanner;

class QuotientAndReminderCalculator{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the first number: ");
		int number1 = input.nextInt();

		System.out.println("Enter the second number: ");
		int number2 = input.nextInt();

		double Quotient = (double)number1 / number2;
		int Reminder = number1 % number2;

		System.out.printf("The Quotient is %.2f and Reminder is %d of two number %d and %d.",Quotient,Reminder,number1,number2);

	}
}