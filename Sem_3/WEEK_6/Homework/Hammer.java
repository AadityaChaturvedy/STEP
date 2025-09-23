package Homework;

class Tool {
    private String name = "Tool";
    protected int age = 5;
    public String type = "General";

    public String getName() { return name; }
}

class Hammer extends Tool {
    public void testAccess() {
        // System.out.println(name); // Not accessible!
        System.out.println("Private (getName()): " + getName());
        System.out.println("Protected: " + age);
        System.out.println("Public: " + type);
    }

    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.testAccess();
    }
}