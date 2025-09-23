package Lab;

class Color {
    protected String name;
    public Color(String name) {
        System.out.println("Color constructor called");
        this.name = name;
    }
}

class PrimaryColor extends Color {
    protected int intensity;
    public PrimaryColor(String name, int intensity) {
        super(name);
        System.out.println("PrimaryColor constructor called");
        this.intensity = intensity;
    }
}

class RedColor extends PrimaryColor {
    protected String shade;
    public RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        System.out.println("RedColor constructor called");
        this.shade = shade;
    }
}

public class TestColor {
    public static void main(String[] args) {
        RedColor rc = new RedColor("Red", 90, "Crimson");
    }
}