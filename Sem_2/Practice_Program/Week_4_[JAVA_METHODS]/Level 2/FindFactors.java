import java.util.Scanner;

class FindFactors{

	public static int[] factors(int number)
	{
		int count = 0;

		for(int i = 1; i <= number; i++){
			if(number % i == 0){
				count++;
			}
		}

		int[] factors = new int[count];
		int index = 0;

		for(int i = 1; i <= number; i++){
			if(number % i == 0){
				factors[index++] = i;
			}
		}

		return factors;
	}

	public static void factorSum(int[] factors){
		int sum = 0;

		for(int factor : factors){
			sum += factor;
		}

		System.out.println("The sum of factors is: " + sum);
	}

	public static void factorProduct(int[] factors){
		int product = 1;

		for(int factor : factors){
			product *= factor;
		}

		System.out.println("The product of factors is: " + product);
	}

	public static void factorSumSquare(int[] factors){
		int sum = 0;

		for(int factor : factors){
			sum += Math.pow(factor,2);
		}

		System.out.println("The sum of square of factors is: " + sum);

	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number: ");
		int number = input.nextInt();

		int[] factors = factors(number);

		System.out.println("Factors: ");
		for(int factor : factors){
			System.out.println(factor + " ");
		}
		
		System.out.println();

		factorSum(factors);
		factorProduct(factors);
		factorSumSquare(factors);

		input.close();
	}
}