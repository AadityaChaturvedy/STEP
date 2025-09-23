import java.util.Scanner;

class SumOfNumRecursion{
	
	public static int NaturalNum(int num){

		if(num == 1)
			return 1;

		return num + NaturalNum(num - 1);
	}

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);

		System.out.printf("Enter a number: ");
		int number = input.nextInt();

		System.out.printf("Sum of %d natural number by recursion is: %d", number, NaturalNum(number));

		int sumOfNnumber = number * (number + 1) / 2;
		System.out.printf("\nSum of %d natural number by formula is: %d", number, sumOfNnumber);
	}
}