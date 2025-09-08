import java.util.Scanner;

public class UnitConvertor {

    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter conversion type (e.g., YARDS_TO_FEET): ");
        String conversion = input.nextLine().toUpperCase();

        System.out.print("Enter value to convert: ");
        double value = input.nextDouble();

        switch (conversion) {
            case "YARDS_TO_FEET" -> System.out.printf("%.2f Yards => %.2f Feet\n", value, convertYardsToFeet(value));
            case "FEET_TO_YARDS" -> System.out.printf("%.2f Feet => %.2f Yards\n", value, convertFeetToYards(value));
            case "METERS_TO_INCHES" -> System.out.printf("%.2f Meters => %.2f Inches\n", value, convertMetersToInches(value));
            case "INCHES_TO_METERS" -> System.out.printf("%.2f Inches => %.2f Meters\n", value, convertInchesToMeters(value));
            case "INCHES_TO_CM" -> System.out.printf("%.2f Inches => %.2f CM\n", value, convertInchesToCentimeters(value));
            case "FAHRENHEIT_TO_CELSIUS" -> System.out.printf("%.2f °F => %.2f °C\n", value, convertFahrenheitToCelsius(value));
            case "CELSIUS_TO_FAHRENHEIT" -> System.out.printf("%.2f °C => %.2f °F\n", value, convertCelsiusToFahrenheit(value));
            case "POUNDS_TO_KILOGRAMS" -> System.out.printf("%.2f Pounds => %.2f Kilograms\n", value, convertPoundsToKilograms(value));
            case "KILOGRAMS_TO_POUNDS" -> System.out.printf("%.2f Kilograms => %.2f Pounds\n", value, convertKilogramsToPounds(value));
            case "GALLONS_TO_LITERS" -> System.out.printf("%.2f Gallons => %.2f Liters\n", value, convertGallonsToLiters(value));
            case "LITERS_TO_GALLONS" -> System.out.printf("%.2f Liters => %.2f Gallons\n", value, convertLitersToGallons(value));
            default -> System.out.println("Invalid conversion type. Please try something valid, sir.");
        }

        input.close();
    }
}
