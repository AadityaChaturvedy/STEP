import java.lang.Math;

class VolumeCalculator{
	public static void main(String[] args){
		int radius = 6378;

		double volumeinkm = (4/3) * Math.PI * (Math.pow(radius,3));
		double volumeinmiles = volumeinkm / (Math.pow(1.6,3));

		System.out.printf("The volume in earth in cubic kilometers is %.2f and cubic miles is %.2f",volumeinkm, volumeinmiles);
	}
}