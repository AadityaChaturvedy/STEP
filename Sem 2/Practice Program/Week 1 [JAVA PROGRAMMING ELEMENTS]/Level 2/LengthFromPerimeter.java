import java.util.Scanner;

class LengthFromPerimeter{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter perimeter of the square: ");
		int perimeter = input.nextInt();

		double side = (double)perimeter / 4.0;
 
		System.out.printf("The length of the side is %.2f whose perimeter is %d.", side, perimeter);
	}
}