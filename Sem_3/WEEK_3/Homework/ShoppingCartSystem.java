import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    // Static variables
    public static int totalProducts = 0;
    public static String[] categories = {"Electronics", "Books", "Clothing", "Home", "Toys"};

    // Constructor
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int qty) { stockQuantity = qty; }

    // Static methods
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    public static Product[] getProductsByCategory(Product[] products, String category) {
        int count = 0;
        for (Product p : products) {
            if (p != null && p.getCategory().equalsIgnoreCase(category)) count++;
        }
        Product[] result = new Product[count];
        int idx = 0;
        for (Product p : products) {
            if (p != null && p.getCategory().equalsIgnoreCase(category)) result[idx++] = p;
        }
        return result;
    }

    public void displayProduct() {
        System.out.printf("%-8s %-20s %-10.2f %-12s %-8d\n", productId, productName, price, category, stockQuantity);
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[20]; // max 20 items
        this.quantities = new int[20];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        if (product.getStockQuantity() < quantity) {
            System.out.println("Not enough stock for " + product.getProductName());
            return;
        }
        // Check if already in cart
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(product.getProductId())) {
                quantities[i] += quantity;
                product.setStockQuantity(product.getStockQuantity() - quantity);
                calculateTotal();
                System.out.println("Added more of " + product.getProductName() + " to cart.");
                return;
            }
        }
        // Add new product
        products[itemCount] = product;
        quantities[itemCount] = quantity;
        product.setStockQuantity(product.getStockQuantity() - quantity);
        itemCount++;
        calculateTotal();
        System.out.println("Added " + product.getProductName() + " to cart.");
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                // Return stock
                products[i].setStockQuantity(products[i].getStockQuantity() + quantities[i]);
                // Remove from cart
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                System.out.println("Removed product from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("\nCart for " + customerName + " (ID: " + cartId + ")");
        System.out.printf("%-8s %-20s %-10s %-12s %-8s %-8s\n", "ID", "Name", "Price", "Category", "Qty", "Subtotal");
        for (int i = 0; i < itemCount; i++) {
            double subtotal = products[i].getPrice() * quantities[i];
            System.out.printf("%-8s %-20s %-10.2f %-12s %-8d %-8.2f\n",
                products[i].getProductId(), products[i].getProductName(),
                products[i].getPrice(), products[i].getCategory(),
                quantities[i], subtotal);
        }
        System.out.printf("Cart Total: $%.2f\n", cartTotal);
    }

    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }
        displayCart();
        System.out.println("Checkout complete! Thank you for your purchase, " + customerName + ".");
        // Empty cart
        for (int i = 0; i < itemCount; i++) {
            products[i] = null;
            quantities[i] = 0;
        }
        itemCount = 0;
        cartTotal = 0.0;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 10 products
        Product[] products = new Product[10];
        products[0] = new Product("P1001", "Smartphone", 699.99, "Electronics", 10);
        products[1] = new Product("P1002", "Laptop", 999.99, "Electronics", 5);
        products[2] = new Product("P1003", "Novel Book", 19.99, "Books", 20);
        products[3] = new Product("P1004", "T-Shirt", 14.99, "Clothing", 30);
        products[4] = new Product("P1005", "Coffee Maker", 49.99, "Home", 8);
        products[5] = new Product("P1006", "Action Figure", 24.99, "Toys", 15);
        products[6] = new Product("P1007", "Jeans", 39.99, "Clothing", 25);
        products[7] = new Product("P1008", "Cookbook", 29.99, "Books", 12);
        products[8] = new Product("P1009", "Headphones", 89.99, "Electronics", 18);
        products[9] = new Product("P1010", "Board Game", 34.99, "Toys", 10);

        System.out.print("Enter your name: ");
        String customerName = sc.nextLine();
        ShoppingCart cart = new ShoppingCart("CART001", customerName);

        int choice;
        do {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Browse all products");
            System.out.println("2. Browse products by category");
            System.out.println("3. Add product to cart");
            System.out.println("4. Remove product from cart");
            System.out.println("5. View cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.printf("%-8s %-20s %-10s %-12s %-8s\n", "ID", "Name", "Price", "Category", "Stock");
                    for (Product p : products) {
                        p.displayProduct();
                    }
                    break;
                case 2:
                    System.out.println("Available categories:");
                    for (String cat : Product.categories) System.out.println("- " + cat);
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    Product[] catProducts = Product.getProductsByCategory(products, cat);
                    if (catProducts.length == 0) {
                        System.out.println("No products found in this category.");
                    } else {
                        System.out.printf("%-8s %-20s %-10s %-12s %-8s\n", "ID", "Name", "Price", "Category", "Stock");
                        for (Product p : catProducts) p.displayProduct();
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID to add: ");
                    String addId = sc.nextLine();
                    Product addProd = Product.findProductById(products, addId);
                    if (addProd == null) {
                        System.out.println("Product not found.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    cart.addProduct(addProd, qty);
                    break;
                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String remId = sc.nextLine();
                    cart.removeProduct(remId);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}