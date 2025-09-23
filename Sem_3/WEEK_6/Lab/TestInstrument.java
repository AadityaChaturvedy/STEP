package Lab;

class Instrument {
    protected String name;
    protected String material;
    
    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
}

class Piano extends Instrument {
    protected int keys;
    public Piano(String material) {
        super("Piano", material);
        this.keys = 88;
    }
}

class Guitar extends Instrument {
    protected int strings;
    public Guitar(String material) {
        super("Guitar", material);
        this.strings = 6;
    }
}

class Drum extends Instrument {
    protected int pieces;
    public Drum(String material) {
        super("Drum", material);
        this.pieces = 5;
    }
}

public class TestInstrument {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Wood"),
            new Guitar("Metal"),
            new Drum("Plastic")
        };
        
        for (Instrument inst : instruments) {
            System.out.println(inst.name + " (" + inst.material + ")");
        }
    }
}