import java.util.Scanner;

class DayOfWeek{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter month, day, year: ");
		int m = input.nextInt();
		int d = input.nextInt();
		int y = input.nextInt();

		if(m < 3){
			m += 12;
			y -= 1;
		}

		int year = y - (14 - m) / 12;
		int x = year + year/4 - year/100 + year/400;
		int month = m + 12 * ((14 - m) / 12) - 2;
		int day = (d + x + 31 * month / 12) % 7;

		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		System.out.println("Day of the week: " + days[day]);

		input.close();

	}
}