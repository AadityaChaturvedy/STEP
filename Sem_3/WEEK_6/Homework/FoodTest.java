package Homework;

abstract class Food {
    final void prepare() {
        wash();
        cook();
        serve();
    }
    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    void wash()  { System.out.println("Washing pizza veggies"); }
    void cook()  { System.out.println("Baking pizza"); }
    void serve() { System.out.println("Serving pizza"); }
}

class Soup extends Food {
    void wash()  { System.out.println("Washing soup ingredients"); }
    void cook()  { System.out.println("Boiling soup"); }
    void serve() { System.out.println("Serving soup"); }
}

public class FoodTest {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        Food soup = new Soup();

        System.out.println("Preparing Pizza:");
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        soup.prepare();
    }
}