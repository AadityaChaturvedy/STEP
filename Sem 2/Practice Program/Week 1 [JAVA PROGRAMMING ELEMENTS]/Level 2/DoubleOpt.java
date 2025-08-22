import java.util.Scanner;

class DoubleOpt{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter three numbers separated by space: ");
		
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();

		double Operation1 = a + b * c;
		double Operation2 = a * b + c;
		double Operation3 = c + a / b;
		double Operation4 = a % b + c;

		System.out.printf("The results of Int Operations are %.2f, %.2f, %.2f, and %.2f.",Operation1, Operation2, Operation3, Operation4);

	}
}