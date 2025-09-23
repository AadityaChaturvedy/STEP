package Lab;

class Box {
    public void pack() {
        System.out.println("Packing the box");
    }
    public void unpack() {
        System.out.println("Unpacking the box");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();    // parent behavior first
        System.out.println("Adding gift wrapping and ribbon");
    }
    @Override
    public void unpack() {
        super.unpack();  // preserve parent functionality
        System.out.println("Opening gift wrapping");
    }
}

public class TestBox {
    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        gb.unpack();
    }
}
