import java.util.Scanner;

class Armstrong{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a numebr: ");
		int number = input.nextInt();
		input.close();

		int originalNumber = number;
		int sum = 0;

		while(number > 0){
			sum += Math.pow(number % 10,3);
			number /= 10;
		}

		if (sum == originalNumber){
			System.out.println("The number is an Armstrong number.");
		}else{
			System.out.println("The number is not an Armstrong Number.");
		}
	}
}