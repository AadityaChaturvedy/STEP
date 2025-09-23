import java.util.Scanner;

class SpringSeason
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int month = 0, day = 0;

		//Asking the user to enter month and day details
		System.out.println("Enter month and day in number: ");
		month = input.nextInt();
		day = input.nextInt();

		//Comparing to find if the 

		if ((month == 3 && (day >= 20 && day <= 31)) 
		|| (month == 4 && (day >= 1 && day <= 30)) 
		|| (month == 5 && (day >= 1 && day <= 31))
		|| (month == 6 && (day >= 1 && day <= 20)))
			
			System.out.println("It's a Spring Season.");
		
		else
			System.out.println("Not a Spring Season");
	}
}