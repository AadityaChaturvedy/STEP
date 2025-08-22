public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        // Test string concatenation with regular String (slow method)
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // Test string concatenation with StringBuilder (fast method)
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        // Test string concatenation with StringBuffer (thread-safe method)
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        // Compare memory usage (approximate)
        demonstrateMemoryEfficiency();

        // Demonstrate thread safety differences
        demonstrateThreadSafety();

        // Practical examples showing when to use each approach
        demonstrateStringBuilderMethods();

        // Compare string comparison methods
        compareStringComparisonMethods();
    }

    // Method using String concatenation (inefficient)
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
    }

    // Method using StringBuilder (efficient, not thread-safe)
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // Method using StringBuffer (efficient, thread-safe)
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
    }

    // Method to demonstrate StringBuilder methods
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("\n=== StringBuilder Methods Demo ===");
        sb.append("!"); // 1. append
        System.out.println("After append: " + sb);
        sb.insert(6, "Java "); // 2. insert
        System.out.println("After insert: " + sb);
        sb.delete(6, 11); // 3. delete
        System.out.println("After delete: " + sb);
        sb.deleteCharAt(5); // 4. deleteCharAt
        System.out.println("After deleteCharAt: " + sb);
        sb.reverse(); // 5. reverse
        System.out.println("After reverse: " + sb);
        sb.reverse(); // reverse back
        sb.replace(0, 5, "Hi"); // 6. replace
        System.out.println("After replace: " + sb);
        sb.setCharAt(0, 'h'); // 7. setCharAt
        System.out.println("After setCharAt: " + sb);
        System.out.println("Capacity: " + sb.capacity()); // 8. capacity
        sb.ensureCapacity(100); // 9. ensureCapacity
        System.out.println("Capacity after ensureCapacity(100): " + sb.capacity());
        sb.trimToSize(); // 10. trimToSize
        System.out.println("Capacity after trimToSize: " + sb.capacity());
    }

    // Method to demonstrate StringBuffer thread safety
    public static void demonstrateThreadSafety() {
        System.out.println("\n=== StringBuffer Thread Safety Demo ===");
        StringBuffer buffer = new StringBuffer();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                buffer.append("A");
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("StringBuffer length after threads: " + buffer.length());
        // StringBuilder is not thread-safe, so similar code with StringBuilder may result in incorrect length
    }

    // Method to compare string comparison methods
    public static void compareStringComparisonMethods() {
        System.out.println("\n=== String Comparison Methods ===");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("str1 == str2: " + (str1 == str2)); // true, same pool reference
        System.out.println("str1 == str3: " + (str1 == str3)); // false, different objects
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, same content
        System.out.println("str1.equalsIgnoreCase(\"hello\"): " + str1.equalsIgnoreCase("hello")); // true
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0, equal
        System.out.println("str1.compareToIgnoreCase(\"hello\"): " + str1.compareToIgnoreCase("hello")); // 0

        System.out.println("== compares references, equals() compares content, compareTo() is lexicographic.");
    }

    // Method to demonstrate memory efficiency
    public static void demonstrateMemoryEfficiency() {
        System.out.println("\n=== Memory Efficiency Demo ===");
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long before = runtime.totalMemory() - runtime.freeMemory();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += "a";
        }
        long after = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by String concatenation: " + (after - before) + " bytes");

        runtime.gc();
        before = runtime.totalMemory() - runtime.freeMemory();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }
        after = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by StringBuilder: " + (after - before) + " bytes");

        // Demonstrate string pool
        String pool1 = "Java";
        String pool2 = "Java";
        String heap = new String("Java");
        System.out.println("pool1 == pool2: " + (pool1 == pool2)); // true
        System.out.println("pool1 == heap: " + (pool1 == heap));   // false

        // Show StringBuilder capacity management
        System.out.println("StringBuilder initial capacity: " + new StringBuilder().capacity());
        StringBuilder sb2 = new StringBuilder(5);
        sb2.append("abcdefghij");
        System.out.println("StringBuilder capacity after append: " + sb2.capacity());
    }
}