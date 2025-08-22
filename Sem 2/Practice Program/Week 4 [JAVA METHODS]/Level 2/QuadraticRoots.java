import java.util.Scanner;

public class QuadraticRoots {
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{}; // No real roots
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 2) {
            System.out.printf("Two real roots: %.2f and %.2f\n", roots[0], roots[1]);
        } else if (roots.length == 1) {
            System.out.printf("One real root: %.2f\n", roots[0]);
        } else {
            System.out.println("No real roots. Discriminant is negative.");
        }
        input.close();
    }
}