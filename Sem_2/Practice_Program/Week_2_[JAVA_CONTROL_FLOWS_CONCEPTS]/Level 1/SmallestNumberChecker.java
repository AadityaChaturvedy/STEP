import java.util.Scanner;

class SmallestNumberChecker{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter three numbers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();

		if(number1 < number2 && number1 < number3){
			System.out.println("The first number is smallest.");
		}else{
			System.out.println("The first number is not the smallest.");
		}
	}

}