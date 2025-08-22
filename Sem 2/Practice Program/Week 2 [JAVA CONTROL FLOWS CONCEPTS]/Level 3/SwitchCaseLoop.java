import java.util.Scanner;

class SwitchCaseLoop{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		double first, second, result = 0;
		char op;

		System.out.println("Enter first and second number: ");
		first = input.nextDouble();
		second = input.nextDouble();

		System.out.println("Enter the operator (+, -, *, /): ");
		op = input.next().charAt(0);

		switch(op){
			case '+':
				result = first + second;
				System.out.println("The sum of the two value is: " + result);
				break;

			case '-':
				result = first - second;
				System.out.println("The subtraction of the two value is: " + result);
				break;

			case '*':
				result = first * second;
				System.out.println("The multiplication of the two value is: " + result);
				break;

			case '/':
				if (second != 0){
					result = first / second;
					System.out.println("The division of the two value is: " + result);
				} else{
					System.out.println("Error: Division by 0 is not allowed.");
				}

			default:
				System.out.println("Invalid operator! Please use +, -, *, or /.");
		}

		input.close();
	}
}