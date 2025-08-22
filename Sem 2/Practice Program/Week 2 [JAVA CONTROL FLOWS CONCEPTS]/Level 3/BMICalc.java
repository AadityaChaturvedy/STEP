import java.util.Scanner;

class BMICalc{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.println("Enter weight(in kgs) and height(in meter): ");

		int weight = input.nextInt();
		double height = input.nextDouble();

		double BMI = weight / (height * height);

		if(BMI <= 18.4){
			System.out.println("Underweight");
		}else if(BMI <= 24.9 && BMI >= 18.5){
			System.out.println("Normal");
		}else if(BMI <= 39.9 && BMI >= 25.0){
			System.out.println("Overweight");
		}else if(BMI >= 40.0){
			System.out.println("Obese");
		}
	}
}