import java.util.Scanner;

public class CalendarGenerator {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", 
                           "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    public static int getStartDay(int m, int d, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int startDay = getStartDay(month, 1, year);
        int numDays = getDaysInMonth(month, year);
        String monthName = getMonthName(month);

        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%2d  ", i);
            if ((i + startDay) % 7 == 0 || i == numDays) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        displayCalendar(month, year);
        scanner.close();
    }
}