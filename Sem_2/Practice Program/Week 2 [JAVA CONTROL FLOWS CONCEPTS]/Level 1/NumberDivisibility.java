import java.util.Scanner;

class NumberDivisibility{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		// Getting input from the User
		System.out.println("Enter a number to check divisibility by 5: ");
		int number = input.nextInt();

		if(number%5 != 0){
			
			System.out.println("The number is not divisible by 5");
		
		}else{
			
			System.out.println("The number is divisible by 5");
		
		}
		

	}

}