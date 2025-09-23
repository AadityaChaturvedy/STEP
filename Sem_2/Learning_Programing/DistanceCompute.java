class DistanceCompute{
	public static void main(String[] args){
		double C_V = 156.6;
		float t_C_V = 4*60 + 4;

		double V_B = 211.8;
		float t_V_B = 4*60 + 25;

		double total_distance = C_V + V_B;
		float total_time = t_C_V + t_V_B;

		System.out.println("Total distance from Chennai to Bangalore via Vellore: " + total_distance + " and total time taken in minutes is: " + total_time + " minutes.");
	}
}