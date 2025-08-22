import java.util.Scanner;

class KmToM{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the kilometer: ");
		int km = input.nextInt();

		double miles = km / 1.6;

		System.out.printf("The total miles is %.2f mile for the given %d km.", miles, km);

	} 
}