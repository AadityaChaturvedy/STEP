import java.util.Scanner;

class SimpleInterestCalculator{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the principal amount, rate of interest and time: ");

		int principal = input.nextInt();
		double rate = input.nextDouble();
		int time = input.nextInt();

		double interest = principal * rate * time / 100;

		System.out.printf("The Simple Interest is %.2f for Principal %d , Rate of Interest %.2f and Time %d years.", interest, principal, rate, time);

	}

}