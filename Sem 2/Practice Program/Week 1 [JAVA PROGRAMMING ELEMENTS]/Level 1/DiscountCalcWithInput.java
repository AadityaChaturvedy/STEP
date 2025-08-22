import java.util.Scanner;

class DiscountCalcWithInput{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		//Fee
		System.out.println("Enter the fee: ");
		int fee = input.nextInt();

		//Discount
		System.out.println("Enter the discount percentage: ");
		int discountPercent = input.nextInt();

		//Discount Calculation
		int discountedAmount = fee * discountPercent / 100;
		int discountedFee = fee - discountedAmount;

		System.out.printf("The discount amount is INR %d and final discounted fee is INR %d.", discountedAmount, discountedFee);
	}
}