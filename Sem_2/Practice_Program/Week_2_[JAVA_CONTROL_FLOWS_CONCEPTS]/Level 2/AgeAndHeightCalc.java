import java.util.Scanner;

class AgeAndHeightCalc
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the ages(in years): ");
		int ageAmar = input.nextInt();
		int ageAkbar = input.nextInt();
		int ageAnthony = input.nextInt();

		int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
		String youngestFriend = (youngestAge == ageAmar) ? "Amar" : (youngestAge == ageAkbar) ? "Akbar" : "Anthony";


		System.out.println("Enter the height(in cm): ");
		int heightAmar = input.nextInt();
		int heightAkbar = input.nextInt();
		int heightAnthony = input.nextInt();

		int tallest = Math.max(ageAmar, Math.max(ageAkbar, ageAnthony));
		String tallestFriend = (tallest == heightAmar) ? "Amar" : (tallest == heightAkbar) ? "Akbar" : "Anthony";
		
		System.out.println("The youngest is: " + youngestFriend);
		System.out.println("The tallest is: " + tallestFriend);
	}
}