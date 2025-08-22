import java.util.Scanner;

class VoteEligibility{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int[] studentAge = new int[10];

		for(int i = 0; i < 10; i++)
		{
			System.out.printf("Enter age of student %d: ", i+1);
			studentAge[i] = input.nextInt();
		}

		for(int i = 0; i < 10; i++)
		{
			if(studentAge[i] < 0)
				System.out.println("The entered age is invalid.");
			else if(studentAge[i] >= 18)
				System.out.printf("The student with the age %d can vote.\n",studentAge[i]);
			else
				System.out.printf("The student with the age %d cannot vote.\n",studentAge[i]);
		}
	}
}