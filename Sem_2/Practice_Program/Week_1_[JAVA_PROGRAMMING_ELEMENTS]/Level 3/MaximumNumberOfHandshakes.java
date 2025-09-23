import java.util.Scanner;

class MaximumNumberOfHandshakes{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of students: ");

		int numberOfStudents = input.nextInt();
		int maximum_possible_combination = (numberOfStudents * (numberOfStudents - 1) ) / 2;

		System.out.printf("The number of possible handshakes %d .",maximum_possible_combination);

	}

}