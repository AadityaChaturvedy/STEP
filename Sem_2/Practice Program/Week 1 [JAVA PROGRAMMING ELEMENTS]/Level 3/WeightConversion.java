import java.util.Scanner;

class WeightConversion{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the weight for conversion(in pounds): ");

		int pounds = input.nextInt();

		double kilograms = pounds / 2.2;

		System.out.printf("The weight of the person in pounds is %d and in kg is %.2f", pounds, kilograms);

	}

}