import java.util.Scanner;

class MeanHeight{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		double[] height = new double[11];
		double sum = 0.0;

		for(int i = 0; i < 11; i++)
		{
			System.out.print("Enter the height of a player: ");
			height[i] = input.nextDouble();
		}

		for(int i = 0; i < 11; i++)
		{
			sum += height[i];
		}

		double mean = sum / 11.0;

		System.out.print("The mean height of the football team: " + mean);
	}
}