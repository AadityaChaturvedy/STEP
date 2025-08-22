import java.util.Scanner;

class SimpleInterestCalculator{

	public static double SimpleInterestCalc(double principal, double rate, double time){
		return (double) principal * rate * time / 100;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		double principal = 0, rate = 0, time = 0;

		System.out.println("Enter principal amount, rate of interest and time of loan: ");

		principal = input.nextDouble();
		rate = input.nextDouble();
		time = input.nextDouble();

		double simpleInterest = SimpleInterestCalc(principal,rate,time);

		System.out.println("Simple Interest: " + simpleInterest);
	}
}