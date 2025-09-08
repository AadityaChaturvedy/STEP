import java.util.Scanner;

class TemperatureConversionCTF{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the temepratue in celsius: ");
		int celsius = input.nextInt();

		double farenheitResult = (celsius * 9.0/5.0) + 32;

		System.out.printf("The %d celsius is %.2f fahrenheit.",celsius,farenheitResult);

	}
}