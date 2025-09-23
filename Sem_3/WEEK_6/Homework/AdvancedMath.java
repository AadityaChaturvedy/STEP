package Homework;

class BasicMath {
    int calculate(int a, int b) { return a + b; }
    double calculate(double a, double b) { return a + b; }
}

class AdvancedMath extends BasicMath {
    int calculate(int a, int b, int c) { return a + b + c; }
    double calculate(double a, double b, double c) { return a * b * c; }

    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();
        System.out.println("Sum (int,int): " + am.calculate(2, 3));
        System.out.println("Sum (double,double): " + am.calculate(2.5, 3.5));
        System.out.println("Sum (int,int,int): " + am.calculate(1, 2, 3));
        System.out.println("Product (double,double,double): " + am.calculate(1.2, 2.0, 3.0));
    }
}