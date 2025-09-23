import java.util.Scanner;

class AthleteTriangular{

	public static double roundCalc(int side1, int side2, int side3){
		int totalDistance = side1 + side2 + side3;
		double rounds = 5000.0 / totalDistance;
		return rounds;
	}

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the sides of the triangle(in m): ");
		
		int side1 = input.nextInt();
		int side2 = input.nextInt();
		int side3 = input.nextInt();

		System.out.printf("The number of rounds needed to complete 5km run: %.2f", roundCalc(side1, side2, side3));

	}
}