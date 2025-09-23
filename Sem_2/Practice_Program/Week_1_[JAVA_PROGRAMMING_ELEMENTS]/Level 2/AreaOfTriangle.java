import java.util.Scanner;

class AreaOfTriangle{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter base(in cm): ");
		double base = input.nextDouble();

		System.out.println("Enter height(in cm): ");
		double height = input.nextDouble();

		double AreaInCm = 0.5 * base * height;
		double AreaInSq = AreaInCm / 2.54 / 2.54;

		System.out.printf("The Area of the triangle in sq inches is %.2f and in sq cm is %.2f", AreaInSq, AreaInCm);
	}
}