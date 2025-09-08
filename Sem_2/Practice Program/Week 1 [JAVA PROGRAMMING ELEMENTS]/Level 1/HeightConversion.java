import java.util.Scanner;

class HeightConversion{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter height in centimeters: ");
		int height = input.nextInt();

		double inch = height / 2.54;
		double feet = inch / 12;

		System.out.printf("Your Height in cm is %d while in feet is %.2f and inches is %.2f", height, feet, inch);
	}
}