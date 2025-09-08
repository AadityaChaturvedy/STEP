import java.util.Scanner;

class LeapYear{

	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a year: ");
		int year = input.nextInt();

		System.out.println();

		if (year >= 1582) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year.");
                    } else {
                        System.out.println(year + " is NOT a Leap Year.");
                    }
                } else {
                    System.out.println(year + " is a Leap Year.");
                }
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        } else {
            System.out.println(year + " is NOT a Leap Year (before Gregorian calendar).");
        }

        System.out.println();

		if(year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
			System.out.println(year + " is a Leap Year.");
		}else{
			System.out.println(year + " is NOT a Leap Year.");
		}

		input.close();

	}

}