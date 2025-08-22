class ProfitLossCalculator{
	public static void main(String[] args){

		int costprice = 129;
		int sellingprice = 191;

		double profit = sellingprice - costprice;
		double profitPercentage = (profit/(double)costprice) * 100.0;

		System.out.printf("The Cost Price in INR %d and Selling Price in INR %d\nThe Profit in INR %.2f and the Profit Percentange is %.2f%%%n", costprice, sellingprice, profit, profitPercentage);
	} 
}