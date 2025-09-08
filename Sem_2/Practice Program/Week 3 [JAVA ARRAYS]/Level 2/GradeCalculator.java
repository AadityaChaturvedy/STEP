import java.util.Scanner;

class GradeCalculator{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of students: ");
		int number = input.nextInt();

		double[][] stuMarks = new double[number][4];
		String[] grade = new String[number];

		double phy = 0, chem = 0, maths = 0, avg = 0;

		for(int i = 0; i < number; i++){
			System.out.println("Enter the marks [Physics, Chemistry, Maths] : ");
			phy = input.nextDouble();
			chem = input.nextDouble();
			maths = input.nextDouble();

			avg = (phy + chem + maths) / 3;

			stuMarks[i][0] = phy;
			stuMarks[i][1] = chem;
			stuMarks[i][2] = maths;
			stuMarks[i][3] = avg;

			if (avg >= 80){
				grade[i] = "Grade: A | Level 4, above agency-normalized standards";
			}else if(avg >= 70 && avg <= 79){
				grade[i] = "Grade: B | Level 3, at agency-normalized standards";
			}else if(avg >= 60 && avg <= 69){
				grade[i] = "Grade: C | Level 2, below, but approaching agency-normalized standards";
			}else if(avg >= 50 && avg <= 59){
				grade[i] = "Grade: D | Level 1, well below agency-normalized standards";
			}else if(avg >= 40 && avg <= 49){
				grade[i] = "Grade: E | Level 1-, too below agency-normalized standards";
			}else if(avg <= 39){
				grade[i] = "Grade: R | Remedial standards";
			}
		}

		for(int i = 0; i < number; i++)
		{
			System.out.printf("Marks in Physics: %.2f\nChemistry: %.2f\nMaths: %.2f\nAverage: %.2f\nGrade: %s", stuMarks[i][0], stuMarks[i][1], stuMarks[i][2], stuMarks[i][3], grade[i]);
		}
	}
}