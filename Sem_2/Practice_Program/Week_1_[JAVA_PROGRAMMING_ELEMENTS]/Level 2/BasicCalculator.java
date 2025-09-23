import java.util.Scanner;

class BasicCalculator{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter first number: ");
		double number1 = input.nextDouble();

		System.out.println("Enter second number: ");
		double number2 = input.nextDouble();

		double addition = number1 + number2;
		double subtraction = number1 - number2;
		double multiplication = number1 * number2;
		double division = number1 / number2;

		System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %f and %f is %.2f , %.2f , %.2f and %.2f", number1, number2, addition, subtraction, multiplication, division);

	}
}