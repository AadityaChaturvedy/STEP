import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class OTPGenerator {

    public static int generateOTP() {
        int otp = (int)(Math.random() * 900000) + 100000;
        return otp;
    }

    public static boolean areAllUnique(int[] otps) {
        if (otps == null || otps.length == 0) {
            return true;
        }

        Set<Integer> uniqueOtps = new HashSet<>();

        for (int otp : otps) {
            if (!uniqueOtps.add(otp)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final int numberOfOtps = 10;
        int[] generatedOtps = new int[numberOfOtps];

        System.out.println("Generating " + numberOfOtps + " OTPs...");

        for (int i = 0; i < numberOfOtps; i++) {
            generatedOtps[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(generatedOtps));

        boolean unique = areAllUnique(generatedOtps);

        if (unique) {
            System.out.println("Result: All " + numberOfOtps + " generated OTPs are unique.");
        } else {
            System.out.println("Result: Duplicate OTPs were found among the " + numberOfOtps + " generated.");
        }
    }
}