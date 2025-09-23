import java.util.Scanner;

class PrimeNumber{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int num = input.nextInt();

		if(num <= 1){
			System.out.println("Not a prime number.");
		}else{
			boolean isPrime = true;

			for(int i = 2; i * i <= num; i++){
				if (num % i == 0){
					isPrime = false;
					break;
				}
			}

			if(isPrime){
				System.out.println("It is a prime number.");
			}else{
				System.out.println("Not a prime number.");
			}
		}
	}
}