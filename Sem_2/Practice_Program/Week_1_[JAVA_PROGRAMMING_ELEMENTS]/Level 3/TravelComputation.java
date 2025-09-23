import java.util.Scanner;

class TravelComputation {

   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);

      System.out.println("Enter name, fromCity, viaCity and toCity (space seperated): ");

      String name = input.nextLine();
      String fromCity = input.nextLine(), viaCity = input.nextLine(), toCity = input.nextLine();

      System.out.println("Enter distancefromFromToVia and viaToFinalCity in Miles: ");

      double distanceFromToVia = input.nextDouble();
      double distanceViaToFinalCity = input.nextDouble();

      System.out.println("Enter timefromFromToVia and timeViaToFinalCity in minutes: ");

      int timeFromToVia = input.nextInt();
      int timeViaToFinalCity = input.nextInt();

      double totalDistance = distanceFromToVia + distanceViaToFinalCity;

      int totalTime = timeFromToVia + timeViaToFinalCity;

      System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km and " + "the Total Time taken is " + totalTime + " minutes");

   }

}