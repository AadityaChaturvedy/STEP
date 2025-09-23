class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    final double fixedRate = 100; // fixed price per item

    // Default constructor
    FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0;
    }

    // Constructor with food item
    FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = fixedRate;
    }

    // Constructor with food item and quantity
    FoodOrder(String foodItem, int quantity) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    // Full constructor
    FoodOrder(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    void printBill() {
        System.out.println("Customer: " + customerName + ", Food: " + foodItem +
                ", Quantity: " + quantity + ", Total Price: $" + price);
    }
}

public class MainFood {
    public static void main(String[] args) {
        FoodOrder f1 = new FoodOrder();
        FoodOrder f2 = new FoodOrder("Burger");
        FoodOrder f3 = new FoodOrder("Pizza", 3);
        FoodOrder f4 = new FoodOrder("Alice", "Pasta", 2);

        f1.printBill();
        f2.printBill();
        f3.printBill();
        f4.printBill();
    }
}
