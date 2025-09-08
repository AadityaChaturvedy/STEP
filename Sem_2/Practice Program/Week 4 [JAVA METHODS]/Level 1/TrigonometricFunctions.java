import java.util.Scanner;

class TrigonometricFunctions{

	public static double[] calculateTrigonometricFunctions(double angle)
	{
		double radians = angle * Math.PI / 180;
		double sine = Math.sin(radians);
		double cosine = Math.cos(radians);
		double tangent = Math.tan(radians);

		return new double[]{sine, cosine, tangent};
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter angle(in degrees): ");

		double angle = input.nextDouble();

		double[] trigonometricValues = calculateTrigonometricFunctions(angle);

		double sine = trigonometricValues[0];
		double cosine = trigonometricValues[1];
		double tangent = trigonometricValues[2];

		System.out.printf("The trigonometric values are as follow: \nSine: %.2f\nCosine: %.2f\nTangent: %.2f", sine, cosine, tangent);
	}
}