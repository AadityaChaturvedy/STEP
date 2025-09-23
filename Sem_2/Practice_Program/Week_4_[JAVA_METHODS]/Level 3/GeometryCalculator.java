import java.util.InputMismatchException;
import java.util.Scanner;

public class GeometryCalculator {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        double sumOfSquares = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
        double distance = Math.sqrt(sumOfSquares);
        return distance;
    }

    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return null;
        }
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        System.out.println("--- Geometry Calculator ---");

        while (true) {
            try {
                System.out.print("Enter x-coordinate of the first point (x1): ");
                x1 = input.nextDouble();
                System.out.print("Enter y-coordinate of the first point (y1): ");
                y1 = input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                input.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter x-coordinate of the second point (x2): ");
                x2 = input.nextDouble();
                System.out.print("Enter y-coordinate of the second point (y2): ");
                y2 = input.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                input.next();
            }
        }

        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance: %.4f\n", distance);

        double[] lineParams = calculateLineEquation(x1, y1, x2, y2);

        if (lineParams == null) {
            System.out.printf("Line Equation: Vertical line x = %.4f\n", x1);
        } else {
            double slope = lineParams[0];
            double yIntercept = lineParams[1];
            System.out.printf("Line Equation: y = %.4fx %c %.4f\n",
                    slope, (yIntercept >= 0 ? '+' : '-'), Math.abs(yIntercept));
        }

        input.close();
    }
}
