import java.util.Scanner;
import java.util.ArrayList;

public class FileOrganizer {

    // Extracts filename and extension
    public static String[] extractComponents(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == 0) {
            return new String[]{filename, ""};
        }
        return new String[]{filename.substring(0, dotIndex), filename.substring(dotIndex + 1)};
    }

    // Categorizes file by extension
    public static String categorizeFile(String extension) {
        switch (extension.toLowerCase()) {
            case "txt": case "doc": case "pdf":
                return "Documents";
            case "jpg": case "png": case "gif":
                return "Images";
            case "mp3": case "wav":
                return "Audio";
            default:
                return "Unknown";
        }
    }
    
    // Generates a new filename
    public static String generateNewName(String originalName, String category) {
        return new StringBuilder(category).append("-").append(originalName).toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file names, one per line (type 'done' to finish):");
        
        ArrayList<String> files = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("done".equalsIgnoreCase(line)) break;
            files.add(line);
        }

        System.out.println("\n--- File Organization Report ---");
        System.out.printf("%-25s %-15s %-30s\n", "Original Name", "Category", "Suggested New Name");
        System.out.println("--------------------------------------------------------------------");

        for (String file : files) {
            String[] components = extractComponents(file);
            String category = categorizeFile(components[1]);
            String newName = generateNewName(components[0], category) + "." + components[1];
            System.out.printf("%-25s %-15s %-30s\n", file, category, newName);
        }
        
        scanner.close();
    }
}