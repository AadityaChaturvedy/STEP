import java.util.Scanner;

class SpringSeason
{
	public static String SeasonCalc(int day, int month)
	{
		//Comparing to find if it is Spring Season 

		if ((month == 3 && (day >= 20 && day <= 31)) 
		|| (month == 4 && (day >= 1 && day <= 30)) 
		|| (month == 5 && (day >= 1 && day <= 31))
		|| (month == 6 && (day >= 1 && day <= 20)))
			
			return "comes during Spring Season.";
		
		else
			return "does not come during Spring Season";
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int month = 0, day = 0;

		//Asking the user to enter month and day details
		System.out.println("Enter month and day in number: ");
		month = input.nextInt();
		day = input.nextInt();

		System.out.printf("The entered date: %d/%d %s", day, month, SeasonCalc(day, month));
	}
}