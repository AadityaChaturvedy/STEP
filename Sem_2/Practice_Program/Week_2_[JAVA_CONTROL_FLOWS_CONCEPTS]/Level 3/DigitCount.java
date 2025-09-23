import java.util.Scanner;

class DigitCount{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int num = input.nextInt();
		int count = 0;

		while(num > 0){
			count += 1;
			num /= 10;
		}

		System.out.println("The number of digits are: " + count);

	}
}