import java.util.Scanner;

class GradeCalculator{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the marks [Physics, Chemistry, Maths] : ");
		int phy = input.nextInt();
		int chem = input.nextInt();
		int maths = input.nextInt();

		int avg = (phy + chem + maths) / 3;

		if (avg >= 80){
			System.out.println("Grade: A | Level 4, above agency-normalized standards");
		}else if(avg >= 70 && avg <= 79){
			System.out.println("Grade: B | Level 3, at agency-normalized standards");
		}else if(avg >= 60 && avg <= 69){
			System.out.println("Grade: C | Level 2, below, but approaching agency-normalized standards");
		}else if(avg >= 50 && avg <= 59){
			System.out.println("Grade: D | Level 1, well below agency-normalized standards");
		}else if(avg >= 40 && avg <= 49){
			System.out.println("Grade: E | Level 1-, too below agency-normalized standards");
		}else if(avg <= 39){
			System.out.println("Grade: R | Remedial standards");
		}
	}
}