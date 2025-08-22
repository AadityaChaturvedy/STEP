import java.util.Scanner;

class PrintingOddEven
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int loopNum = input.nextInt();

		if(loopNum > 0)
		{
			for(int i = 0; i <= loopNum; i++)
			{
				if (i % 2 == 0)
					System.out.printf("%d is Odd.\n",i);
				else
					System.out.printf("%d is Even.\n",i);
			}
		}
		else
			System.out.println("The entered number is not a Natural Number.");
	}
}