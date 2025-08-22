import java.util.Scanner;

class WindChillCalc{
	public static double calculateWindChill(double temperature, double windSpeed)
	{
		double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed,0.16);

		return windChill;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter temperatue(in F) and wind speed(in mph): ");
		
		double temperature = input.nextDouble();
		double windSpeed = input.nextDouble();

		System.out.println("The Wind Chill is: " + calculateWindChill(temperature, windSpeed));
	}
}