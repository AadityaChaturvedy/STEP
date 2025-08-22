import java.util.Scanner;

class MaximumHandshakes{

	public static int Handshakes(int n)
	{
		return (n * (n - 1)) / 2;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of students: ");

		int numberOfStudents = input.nextInt();

		System.out.println("Maximum number of Handshakes: " + Handshakes(numberOfStudents));
	}
}