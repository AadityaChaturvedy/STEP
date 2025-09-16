package Homework;

import java.time.LocalDateTime;
import java.util.*;

final class Product {
    private final String productId, name, category, manufacturer;
    private final double basePrice, weight;
    private final String[] features;
    private final Map<String,String> specifications;

    private Product(String id, String n, String c, String m, double p, double w, String[] f, Map<String,String> spec) {
        productId=id; name=n; category=c; manufacturer=m; basePrice=p; weight=w;
        features=f.clone(); specifications = Map.copyOf(spec);
    }
    public static Product createElectronics(String id, String n, String m, double p, String[] f, Map<String,String> s) {
        return new Product(id, n, "Electronics", m, p, 1.0, f, s);
    }
    public static Product createClothing(String id, String n, String m, double p, String[] f, Map<String,String> s) {
        return new Product(id, n, "Clothing", m, p, 0.2, f, s);
    }
    public static Product createBooks(String id, String n, String m, double p, String[] f, Map<String,String> s) {
        return new Product(id, n, "Books", m, p, 0.4, f, s);
    }
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String,String> getSpecifications() { return Map.copyOf(specifications); }
    public final double calculateTax(String region) { return basePrice * 0.18; }
    public String toString() { return "["+productId+":"+name+" "+category+"]"; }
}

class Customer {
    private final String customerId, email, accountCreationDate;
    private String name, phoneNumber, preferredLanguage;
    public Customer(String id, String mail, String creDate) {
        customerId=id; email=mail; accountCreationDate=creDate;
        name=""; phoneNumber=""; preferredLanguage="EN";
    }
    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public void setName(String n) { name=n; }
    public String getName() { return name; }
    public void setPhoneNumber(String p) { phoneNumber=p; }
    public String getPhoneNumber() { return phoneNumber; }
    String getCreditRating() { return (phoneNumber.length() > 0) ? "Good" : "Unknown"; }
    public String getPublicProfile() { return "Customer: "+name+" (Since "+accountCreationDate+")"; }
    public String toString() { return "[Customer:"+customerId+","+email+"]"; }
}

class ShoppingCart {
    private final String cartId, customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount; private int itemCount;
    public ShoppingCart(String cId, String custId) { cartId=cId; customerId=custId; }
    public boolean addItem(Object prod, int qty) {
        if(prod instanceof Product && qty > 0) {
            for(int i=0;i<qty;i++) items.add(prod);
            totalAmount += ((Product)prod).getBasePrice()*qty;
            itemCount += qty;
            return true;
        }
        return false;
    }
    public String getCartSummary() { return "Items:"+itemCount+" Total:₹"+totalAmount; }
    private double calculateDiscount() { return itemCount>10 ? 0.05*totalAmount : 0; }
    public String toString() { return "Cart[" + cartId + ":"+ items.size()+"]"; }
}

class Order {
    private final String orderId;
    private final LocalDateTime orderTime;
    public Order(String id) { orderId=id; orderTime=LocalDateTime.now(); }
    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }
}

class PaymentProcessor {
    private final String processorId, securityKey;
    public PaymentProcessor(String id, String k) { processorId=id; securityKey=k;}
    public String getProcessorId() { return processorId;}
}

class ShippingCalculator {
    private final Map<String,Double> shippingRates;
    public ShippingCalculator(Map<String,Double> sr) { shippingRates=Map.copyOf(sr);}
    public double getRate(String region) { return shippingRates.getOrDefault(region,50.0);}
}

final class ECommerceSystem {
    private static final Map<String,Object> productCatalog = new HashMap<>();
    public static boolean processOrder(Object o, Object c) {
        return (o instanceof Order) && (c instanceof Customer);
    }
    public static void addProduct(Product p) { productCatalog.put(p.getProductId(),p);}
    public static String getCatalogSnapshot() { return productCatalog.keySet().toString(); }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Product phone = Product.createElectronics("E1","Smartphone","PhoneCorp",20000,new String[]{"OLED"}, Map.of("RAM","8GB"));
        ECommerceSystem.addProduct(phone);
        Customer cust = new Customer("C1","mail@a.com","2021-01-01"); cust.setName("Ravi");
        ShoppingCart cart = new ShoppingCart("CART1", cust.getCustomerId()); cart.addItem(phone,2);
        Order order = new Order("ORD1");
        PaymentProcessor payP = new PaymentProcessor("PAYP1","secret");
        ShippingCalculator ship = new ShippingCalculator(Map.of("IN",100.0));
        System.out.println(cart.getCartSummary());
        System.out.println("Order processed: "+ECommerceSystem.processOrder(order,cust));
        System.out.println(phone.calculateTax("IN"));
        System.out.println(ECommerceSystem.getCatalogSnapshot());
    }
}