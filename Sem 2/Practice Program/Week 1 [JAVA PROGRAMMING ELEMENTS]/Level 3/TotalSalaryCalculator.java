import java.util.Scanner;

class TotalSalaryCalculator{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the salary and bonus: ");
		int salary = input.nextInt();
		int bonus = input.nextInt();

		int totalSalary = salary + bonus;

		System.out.printf("The salary in INR %d and bonus is INR %d . Hence Total Income is INR %d.",salary, bonus, totalSalary);

	}
}