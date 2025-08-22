import java.util.Scanner;

class NumberOfRoundsCalculator{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the three sides of the triangle (in m) : ");

		int side1 = input.nextInt();
		int side2 = input.nextInt();
		int side3 = input.nextInt();

		int total_side_length = side1 + side2 + side3;

		double number_of_rounds = 5000.0/total_side_length;

		System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km.", number_of_rounds);

	}
}