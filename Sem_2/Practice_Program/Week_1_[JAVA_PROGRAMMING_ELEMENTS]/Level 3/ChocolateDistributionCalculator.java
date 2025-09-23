import java.util.Scanner;

class ChocolateDistributionCalculator{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of chocolates and number of children : ");

		int numberOfChocolates = input.nextInt();
		int numberOfChildren = input.nextInt();

		int ChocolateRemaining = numberOfChocolates % numberOfChildren;

		int ChocolatePerChildren = (numberOfChocolates - ChocolateRemaining) / numberOfChildren;

		System.out.printf("The number of chocolates each child gets is %d and the number of remaining chocolates are %d .", ChocolatePerChildren, ChocolateRemaining);

	}

}