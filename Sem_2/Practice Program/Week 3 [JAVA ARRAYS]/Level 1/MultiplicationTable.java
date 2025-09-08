import java.util.Scanner;

class MultiplicationTable
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = input.nextInt();

		int[] multiplication = new int[10];

		for(int i = 0; i < 10; i++)
		{
			multiplication[i] = number * (i+1);
		}

		for(int i = 0; i < 10; i++)
		{
			System.out.printf("%d * %d = %d\n",number,i+1,multiplication[i]);
		}
	} 
}