import java.util.Scanner;

class HarshadNumber{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = input.nextInt();
		int originalNum = num;
		int sum = 0;

		while(num > 0){
			sum += num%10;
			num /= 10;
		}

		if(originalNum % sum == 0){
			System.out.println("The entered number is a Harshad Number.");
		}else{
			System.out.println("The entered number is not a Harshad Number.");
		}
	}
}