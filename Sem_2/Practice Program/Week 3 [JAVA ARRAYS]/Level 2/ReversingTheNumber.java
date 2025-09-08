import java.util.Scanner;

class ReversingTheNumber{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = input.nextInt();

		int temp = number;
		int countOfDigits = 0;

		while(temp != 0){
			temp /= 10;
			countOfDigits++;
		}

		int[] reversedArray = new int[countOfDigits];

		for(int i = 0; i < countOfDigits; i++){
			reversedArray[i] = number % 10;
			number /= 10;
		}

		System.out.println("The number of digits: " + countOfDigits);
		System.out.println("The digits are: ");

		for(int i = 0; i < countOfDigits; i++)
		{
			System.out.println(reversedArray[i]);
		}

		input.close();
	}
}