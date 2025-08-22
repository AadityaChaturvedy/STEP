import java.util.Scanner;

class FrequencyOfDigit{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int number = input.nextInt();
		int temp = number;
		int count = 0;

		while(temp > 0)
		{
			temp = temp / 10;
			count++;
		}

		int[] digits = new int[10];
		int[] digitList = new int[count];

		for(int i = 0; i < count; i++)
		{
			digitList[i] = number % 10;
			number = number / 10;
		}

		for(int i = 0; i < count; i++)
		{
			digits[digitList[i]] += 1;
		}

		for(int i = 0; i < 10; i++)
		{
			System.out.printf("The number %d occured: %d \n", i, digits[i]);
		}

	}
}