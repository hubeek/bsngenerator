package nl.appall.newproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BsnGenerator {

    public static void main(String[] args) {
        List<String> bsnList = generateBsnNumbers(10);
        System.out.println("Generated BSN Numbers:");
        bsnList.forEach(System.out::println);
    }

    // Generate BSN numbers
    public static List<String> generateBsnNumbers(int count) {
        List<String> validBsns = new ArrayList<>();
        while (validBsns.size() < count) {
            String bsn = generateRandomBsn();
            if (isValidBsn(bsn)) {
                validBsns.add(bsn);
            }
        }
        return validBsns;
    }

    // Generate random 8-digit BSN candidate
    private static String generateRandomBsn() {
        Random random = new Random();
        int number = random.nextInt(90000000) + 10000000; // Generates a number between 10000000 and 99999999
        return String.valueOf(number);
    }

    // Check if the BSN number is valid based on the elfproef
    public static boolean isValidBsn(String bsn) {
        int sum = 0;
        for (int i = 0; i < bsn.length(); i++) {
            int digit = Character.getNumericValue(bsn.charAt(i));
            int multiplier = 9 - i;
            if (i == 8) {
                multiplier = -1; // last digit has a multiplier of -1
            }
            sum += digit * multiplier;
        }
        return sum % 11 == 0;
    }
}
