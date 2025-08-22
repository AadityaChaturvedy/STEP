import java.util.Scanner;
import java.util.ArrayList;

public class CsvAnalyzer {

    // Parses simple CSV data without using split()
    public static ArrayList<String[]> parseCsv(String csvData) {
        ArrayList<String[]> records = new ArrayList<>();
        String[] lines = csvData.split("\n");
        for (String line : lines) {
            ArrayList<String> fields = new ArrayList<>();
            StringBuilder field = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (c == ',') {
                    fields.add(field.toString());
                    field.setLength(0);
                } else {
                    field.append(c);
                }
            }
            fields.add(field.toString());
            records.add(fields.toArray(new String[0]));
        }
        return records;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CSV data (e.g., Name,Age,City):");
        StringBuilder csvInput = new StringBuilder();
        // Enter data line by line, type 'done' to finish
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("done".equalsIgnoreCase(line)) break;
            csvInput.append(line).append("\n");
        }

        ArrayList<String[]> data = parseCsv(csvInput.toString());

        System.out.println("\n--- Formatted Data ---");
        for (String[] record : data) {
            for (String field : record) {
                System.out.printf("%-15s", field);
            }
            System.out.println();
        }

        // Simple analysis: average of the second column if numeric
        double sum = 0;
        int count = 0;
        try {
            for (int i = 1; i < data.size(); i++) {
                sum += Double.parseDouble(data.get(i)[1]);
                count++;
            }
            System.out.println("\nAverage of second column: " + (sum / count));
        } catch (Exception e) {
            System.out.println("\nCould not perform analysis on the second column.");
        }

        scanner.close();
    }
}