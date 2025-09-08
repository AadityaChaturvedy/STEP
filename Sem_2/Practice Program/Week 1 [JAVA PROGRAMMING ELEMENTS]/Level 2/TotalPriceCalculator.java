import java.util.Scanner;

class TotalPriceCalculator{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the unit price: ");
		int unitPrice = input.nextInt();

		System.out.println("Enter the quantity: ");
		int quantity = input.nextInt();

		int totalPrice = unitPrice * quantity;

		System.out.printf("The total purchase price is INR %d if the quantity %d and unit price is INR %d.", totalPrice, quantity, unitPrice);

	}
}