public class StringArrays {

    public static String findLongestName(String[] names) {
        String longest = names[0];
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    public static int countNamesStartingWith(String[] names, char letter) {
        if (names == null) return 0;
        int count = 0;
        char target = Character.toLowerCase(letter);
        for (String name : names) {
            if (name != null && !name.isEmpty() && Character.toLowerCase(name.charAt(0)) == target) {
                count++;
            }
        }
        return count;
    }

    public static String[] formatNames(String[] names) {
        if (names == null) return null;
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name != null) {
                String[] parts = name.trim().split(" ");
                if (parts.length >= 2) {
                    formatted[i] = parts[1] + ", " + parts[0];
                } else {
                    formatted[i] = name;
                }
            } else {
                formatted[i] = null;
            }
        }
        return formatted;
    }
    
    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown",
                "Carol Davis", "David Wilson"};

        // Test findLongestName
        String longest = findLongestName(students);
        System.out.println("Longest name: " + longest);

        // Test countNamesStartingWith
        char testLetter = 'D';
        int count = countNamesStartingWith(students, testLetter);
        System.out.println("Number of names starting with '" + testLetter + "': " + count);

        // Test formatNames
        String[] formatted = formatNames(students);
        System.out.println("Formatted names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}