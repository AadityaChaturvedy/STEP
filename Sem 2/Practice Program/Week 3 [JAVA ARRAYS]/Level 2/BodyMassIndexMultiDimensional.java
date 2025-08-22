import java.util.Scanner;

class BodyMassIndexMultiDimensional{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of persons: ");
		int number = input.nextInt();

		double[][] personData = new double[number][4];
		String[] weightStatus = new String[number];

		double weight = 0;
		double height = 0.0;

		for(int i = 0; i < number; i++)
		{
			//Weight, Height, BMI, weightStatus
			
			System.out.print("Enter weight: ");
			weight = input.nextDouble();

			System.out.print("Enter height: ");
			height = input.nextDouble();


			personData[i][0] = weight;
			personData[i][1] = height;

			personData[i][2] = weight / (height * height);

			if(personData[i][2] <= 18.4)
			{
				weightStatus[i] = "Underweight";
			}else if(personData[i][2] >= 18.5 && personData[i][2] <= 24.9)
			{
				weightStatus[i] = "Normal";
			}else if(personData[i][2] >= 25.0 && personData[i][2] <= 39.9)
			{
				weightStatus[i] = "Overweight";
			}else if(personData[i][2] >= 40.0)
			{
				weightStatus[i] = "Obese";
			}
		}

		for(int i = 0; i < number; i++)
		{
			System.out.printf("Weight: %.2f, Height: %.2f, BMI: %.2f, Status: %s\n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
		}
	}
}