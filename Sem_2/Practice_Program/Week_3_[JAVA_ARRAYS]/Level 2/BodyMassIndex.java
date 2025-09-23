import java.util.Scanner;

class BodyMassIndex{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of persons: ");
		int numPerson = input.nextInt();

		double[][] personInfo = new double[numPerson][4];

		double weight = 0;
		double height = 0.0;

		for(int i = 0; i < numPerson; i++)
		{
			//Weight, Height, BMI, weightStatus
			
			System.out.print("Enter weight: ");
			weight = input.nextDouble();

			System.out.print("Enter height: ");
			height = input.nextDouble();


			personInfo[i][0] = weight;
			personInfo[i][1] = height;

			personInfo[i][2] = weight / (height * height);
		}

		for(int i = 0; i < numPerson; i++)
		{
			System.out.printf("Weight: %.2f, Height: %.2f, BMI: %.2f, Status: ", personInfo[i][0], personInfo[i][1], personInfo[i][2]);

			if(personInfo[i][2] <= 18.4)
			{
				System.out.println("Underweight");
			}else if(personInfo[i][2] >= 18.5 && personInfo[i][2] <= 24.9)
			{
				System.out.println("Normal");
			}else if(personInfo[i][2] >= 25.0 && personInfo[i][2] <= 39.9)
			{
				System.out.println("Overweight");
			}else if(personInfo[i][2] >= 40.0)
			{
				System.out.println("Obese");
			}
		}
	}
}