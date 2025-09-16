import java.time.LocalDateTime;
import java.util.*;

public final class ECommerceSystem {

    // ---------- Product ----------
    public static final class Product {
        private final String productId;
        private final String name;
        private final String category;
        private final String manufacturer;
        private final double basePrice;
        private final double weight;
        private final String[] features;
        private final Map<String, String> specifications;

        private Product(String productId, String name, String category, String manufacturer,
                        double basePrice, double weight, String[] features, Map<String, String> specifications) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.manufacturer = manufacturer;
            this.basePrice = basePrice;
            this.weight = weight;
            this.features = (features == null) ? new String[0] : features.clone();
            this.specifications = (specifications == null) ? new HashMap<>() : new HashMap<>(specifications);
        }

        public static Product createElectronics(String id, String name, double price) {
            return new Product(id, name, "Electronics", "Generic", price, 1.0,
                    new String[]{"Warranty"}, Map.of("Voltage", "220V"));
        }

        public static Product createClothing(String id, String name, double price) {
            return new Product(id, name, "Clothing", "Generic", price, 0.5,
                    new String[]{"Cotton"}, Map.of("Size", "M"));
        }

        public static Product createBooks(String id, String name, double price) {
            return new Product(id, name, "Books", "Generic", price, 0.3,
                    new String[]{"Paperback"}, Map.of("Pages", "200"));
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getBasePrice() { return basePrice; }

        public final double calculateTax(String region) {
            double rate = region.equalsIgnoreCase("EU") ? 0.2 : 0.1;
            return basePrice * rate;
        }

        @Override
        public String toString() { return name + " (" + category + ")"; }
    }

    // ---------- Customer ----------
    public static class Customer {
        private final String customerId;
        private final String email;
        private String name;
        private String phoneNumber;
        private String preferredLanguage;
        private final String accountCreationDate;

        public Customer(String customerId, String email, String name) {
            this.customerId = customerId;
            this.email = email;
            this.name = name;
            this.accountCreationDate = LocalDateTime.now().toString();
        }

        String getCreditRating() { return "GOOD"; }

        public String getPublicProfile() {
            return "Customer: " + name + " (Preferred: " + preferredLanguage + ")";
        }
    }

    // ---------- ShoppingCart ----------
    public static class ShoppingCart {
        private final String cartId;
        private final String customerId;
        private final List<Object> items = new ArrayList<>();
        private double totalAmount;
        private int itemCount;

        public ShoppingCart(String cartId, String customerId) {
            this.cartId = cartId;
            this.customerId = customerId;
        }

        public boolean addItem(Object product, int quantity) {
            if (!(product instanceof Product)) return false;
            items.add(product);
            totalAmount += ((Product) product).getBasePrice() * quantity;
            itemCount += quantity;
            return true;
        }

        double calculateDiscount() {
            return (itemCount > 5) ? totalAmount * 0.1 : 0.0;
        }

        String getCartSummary() {
            return "Cart " + cartId + " has " + itemCount + " items, total $" + totalAmount;
        }
    }

    // ---------- Order ----------
    public static class Order {
        private final String orderId;
        private final LocalDateTime orderTime;

        public Order(String id) {
            this.orderId = id;
            this.orderTime = LocalDateTime.now();
        }
    }

    public static class PaymentProcessor {
        private final String processorId;
        private final String securityKey;

        public PaymentProcessor(String id, String key) {
            this.processorId = id;
            this.securityKey = key;
        }
    }

    public static class ShippingCalculator {
        private final Map<String, Double> shippingRates;

        public ShippingCalculator() {
            this.shippingRates = Map.of("US", 5.0, "EU", 10.0);
        }
    }

    // ---------- System methods ----------
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        return (order instanceof Order) && (customer instanceof Customer);
    }

    // Demo main
    public static void main(String[] args) {
        Product p1 = Product.createElectronics("P1", "Laptop", 1000);
        Customer c1 = new Customer("C1", "alice@mail.com", "Alice");
        ShoppingCart cart = new ShoppingCart("CART1", c1.customerId);
        cart.addItem(p1, 2);

        System.out.println(cart.getCartSummary());
        System.out.println("Tax (EU): " + p1.calculateTax("EU"));
        Order order = new Order("O1");
        System.out.println("Process order: " + processOrder(order, c1));
    }
}
