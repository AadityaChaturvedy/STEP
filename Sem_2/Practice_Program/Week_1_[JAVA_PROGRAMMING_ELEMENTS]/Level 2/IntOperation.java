import java.util.Scanner;

class IntOperation{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter three numbers separated by space: ");
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();

		int Operation1 = a + b * c;
		int Operation2 = a * b + c;
		double Operation3 = c + a / (double)b;
		int Operation4 = a % b + c;

		System.out.printf("The results of Int Operations are %d, %d, %.2f, and %d.",Operation1, Operation2, Operation3, Operation4);

	}
}