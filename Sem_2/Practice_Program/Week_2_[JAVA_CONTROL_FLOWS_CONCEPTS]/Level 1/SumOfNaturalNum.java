import java.util.Scanner;

class SumOfNaturalNum{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a natural number: ");
		int number = input.nextInt();

		if (number > 0){
			int SumOfN = 0;
		
			for (int i = 0; i <= number; i++)
			{
				SumOfN += i;
			}
		
			System.out.printf("The sum of %d natural number is %d.",number,SumOfN);
		}else{
			System.out.printf("The number %d is not a natural number.",number);
		}
	}

}