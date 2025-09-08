class PenDistribution{
	public static void main(String[] args){

		int NumberOfPens = 14;
		int NumberOfStudents = 3;

		int RemainingPens = NumberOfPens % NumberOfStudents;
		int PenPerStudent = (NumberOfPens - RemainingPens) / NumberOfStudents;

		System.out.printf("The Pen Per Student is %d and the remaining pen not distributed is %d.", PenPerStudent ,RemainingPens);
	}
}