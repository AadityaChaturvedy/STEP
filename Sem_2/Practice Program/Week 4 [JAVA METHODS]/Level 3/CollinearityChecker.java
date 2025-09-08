import java.util.InputMismatchException;
import java.util.Scanner;

public class CollinearityChecker {

    private static final double EPSILON = 1e-9;

    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        boolean verticalAB = Math.abs(x2 - x1) < EPSILON;
        boolean verticalBC = Math.abs(x3 - x2) < EPSILON;

        if (verticalAB && verticalBC) {
            return true;
        }

        if (verticalAB || verticalBC) {
            return false;
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);

        return Math.abs(slopeAB - slopeBC) < EPSILON;
    }

    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double areaTimesTwo = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return Math.abs(areaTimesTwo) < EPSILON;
    }

    private static double getCoordinateInput(int pointNumber, char coordinateName, Scanner input) {
        double coordinate = 0;
        while (true) {
            try {
                System.out.printf("Enter %c-coordinate of point %d (%c%d): ", coordinateName, pointNumber, coordinateName, pointNumber);
                coordinate = input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
        return coordinate;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1, y1, x2, y2, x3, y3;

        System.out.println("--- Collinearity Checker ---");
        System.out.println("Enter the coordinates for three points:");

        x1 = getCoordinateInput(1, 'x', input);
        y1 = getCoordinateInput(1, 'y', input);

        x2 = getCoordinateInput(2, 'x', input);
        y2 = getCoordinateInput(2, 'y', input);

        x3 = getCoordinateInput(3, 'x', input);
        y3 = getCoordinateInput(3, 'y', input);

        boolean collinearSlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("\n--- Results for User Input ---");
        System.out.printf("Points: (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f)\n", x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear by Slope Method? " + collinearSlope);
        System.out.println("Collinear by Area Method?  " + collinearArea);

        System.out.println("\n--- Results for Sample Points A(2, 4), B(4, 6), C(6, 8) ---");
        double sx1 = 2, sy1 = 4, sx2 = 4, sy2 = 6, sx3 = 6, sy3 = 8;
        boolean sampleCollinearSlope = areCollinearBySlope(sx1, sy1, sx2, sy2, sx3, sy3);
        boolean sampleCollinearArea = areCollinearByArea(sx1, sy1, sx2, sy2, sx3, sy3);
        System.out.println("Collinear by Slope Method? " + sampleCollinearSlope);
        System.out.println("Collinear by Area Method?  " + sampleCollinearArea);

        input.close();
    }
}
