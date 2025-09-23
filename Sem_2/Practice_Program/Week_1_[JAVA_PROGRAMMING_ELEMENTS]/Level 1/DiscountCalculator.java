class DiscountCalculator{
	public static void main(String[] args){

		int fee = 125000;
		int discountPercent = 10;

		int discountedAmount = fee * discountPercent / 100;
		int discountedFee = fee - discountedAmount;

		System.out.printf("The discount amount is INR %d and final discounted fee is INR %d.", discountedAmount, discountedFee);
	}
}