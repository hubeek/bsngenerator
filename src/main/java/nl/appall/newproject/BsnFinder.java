package nl.appall.newproject;

import java.util.ArrayList;
import java.util.List;

public class BsnFinder {

    public static void main(String[] args) {
        // Get all valid BSNs between 0 and 100,000,000
        List<String> validBsns = findValidBsnsInRange(0, 100000000);

        // Print valid BSNs
        System.out.println("Valid BSNs found: " + validBsns.size());
        validBsns.forEach(System.out::println);
    }

    // Find all valid BSNs between the specified range
    public static List<String> findValidBsnsInRange(int start, int end) {
        List<String> validBsns = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String bsn = String.format("%09d", i); // Ensure 9 digits with leading zeros
            if (isValidBsn(bsn)) {
                validBsns.add(bsn);
            }
        }
        return validBsns;
    }

    // Check if the BSN passes the elfproef
    public static boolean isValidBsn(String bsn) {
        int sum = 0;
        for (int i = 0; i < bsn.length(); i++) {
            int digit = Character.getNumericValue(bsn.charAt(i));
            int multiplier = 9 - i;
            if (i == 8) {
                multiplier = -1; // The last digit multiplier is -1
            }
            sum += digit * multiplier;
        }
        return sum % 11 == 0;
    }
}
