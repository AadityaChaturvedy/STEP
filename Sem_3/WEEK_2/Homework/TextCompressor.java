import java.util.Scanner;

public class TextCompressor {

    // Compresses text using run-length encoding
    public static String compress(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(text.charAt(i));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        return compressed.toString();
    }

    // Decompresses text from run-length encoding
    public static String decompress(String compressedText) {
        if (compressedText == null || compressedText.isEmpty()) {
            return "";
        }
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compressedText.length(); i++) {
            char c = compressedText.charAt(i);
            if (i + 1 < compressedText.length() && Character.isDigit(compressedText.charAt(i + 1))) {
                int count = Character.getNumericValue(compressedText.charAt(++i));
                for (int j = 0; j < count; j++) {
                    decompressed.append(c);
                }
            } else {
                decompressed.append(c);
            }
        }
        return decompressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = scanner.nextLine();

        String compressed = compress(text);
        System.out.println("Compressed: " + compressed);

        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);

        double ratio = (double) compressed.length() / text.length() * 100;
        System.out.printf("Compression ratio: %.2f%%\n", ratio);
        
        scanner.close();
    }
}