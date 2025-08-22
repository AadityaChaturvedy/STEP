import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarPrinter {

    private static final String[] MONTH_NAMES = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final int[] DAYS_IN_MONTH = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static String getMonthName(int month) {
        if (month >= 1 && month <= 12) {
            return MONTH_NAMES[month];
        } else {
            return "Invalid Month";
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        if (daysInMonth == -1) {
            System.out.println("Invalid month input: " + month);
            return;
        }

        System.out.println("\n   " + monthName + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }

        if ((daysInMonth + firstDay) % 7 != 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = 0;
        int year = 0;

        System.out.println("--- Calendar Printer ---");

        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                month = input.nextInt();
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.println("Invalid month. Please enter a number between 1 and 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }

        while (true) {
            System.out.print("Enter year (e.g., 2024): ");
            try {
                year = input.nextInt();
                if (year > 0) {
                    break;
                } else {
                    System.out.println("Invalid year. Please enter a positive year.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }

        displayCalendar(month, year);

        input.close();
    }
}
