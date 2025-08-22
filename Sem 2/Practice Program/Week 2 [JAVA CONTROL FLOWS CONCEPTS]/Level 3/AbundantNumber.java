import java.util.Scanner;

class AbundantNumber{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number: ");
		int num = input.nextInt();

		int sumOfDivisior = 0;

		for(int i = 1; i <= num; i++){

			if(num % i == 0){
				sumOfDivisior += i;
			}
		}

		if(sumOfDivisior > num)
			System.out.println("The number is an Abundant Number.");
		else
			System.out.println("The number is not an Abundant Number.");
	} 
}