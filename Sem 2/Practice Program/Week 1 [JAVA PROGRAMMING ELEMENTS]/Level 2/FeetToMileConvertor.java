import java.util.Scanner;

class FeetToMileConvertor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the distance in feet: ");
		int feet = input.nextInt();

		double yards = feet / 3;
		double miles = yards / 1760;
 
		System.out.printf("The distance provided in feet is %d and converting it to yard is %.2f and in miles is %.2f.", feet, yards, miles);
	}
}