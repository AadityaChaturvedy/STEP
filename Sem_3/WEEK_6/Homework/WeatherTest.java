package Homework;

class Weather {
    public Weather() { System.out.println("Weather constructed"); }
    public void describe() { System.out.println("General weather"); }
}

class Storm extends Weather {
    public Storm() { super(); System.out.println("Storm constructed"); }
    public void describe() { System.out.println("It's stormy!"); }
}

class Thunderstorm extends Storm {
    public Thunderstorm() { super(); System.out.println("Thunderstorm constructed"); }
    public void describe() { System.out.println("Thunder and lightning!"); }
}

class Sunshine extends Weather {
    public Sunshine() { super(); System.out.println("Sunshine constructed"); }
    public void describe() { System.out.println("Sunny weather!"); }
}

public class WeatherTest {
    public static void main(String[] args) {
        Weather[] wArr = {new Weather(), new Storm(), new Thunderstorm(), new Sunshine()};
        for (Weather w : wArr)
            w.describe();
    }
}