import java.util.Scanner;

class BonusCalculator
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the salary and number of years of service: ");

		int salary = input.nextInt();
		int yearsOfEmployment = input.nextInt();

		if (yearsOfEmployment > 5)
			System.out.println("The bonus amount is: " + (salary * 0.05));
		else
			System.out.println("Not eligible for bonus.");
	}
}