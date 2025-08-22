import java.util.Scanner;

class TemperatureConversionFTC{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the temperature in fahrenheit: ");
		int farenheit = input.nextInt();

		double celsiusResult = (farenheit - 32) * 5.0/9.0;

		System.out.printf("The %d fahrenheit is %.2f celsius.",farenheit,celsiusResult);

	}
}