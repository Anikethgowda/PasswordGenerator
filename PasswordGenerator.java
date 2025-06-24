import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?/";

    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        StringBuilder charPool = new StringBuilder();
        if (useUpper) charPool.append(UPPER);
        if (useLower) charPool.append(LOWER);
        if (useDigits) charPool.append(DIGITS);
        if (useSpecial) charPool.append(SPECIAL);

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(charPool.length());
            password.append(charPool.charAt(idx));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUpper = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLower = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean useDigits = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecial = scanner.nextBoolean();

        try {
            String password = generate(length, useUpper, useLower, useDigits, useSpecial);
            System.out.println("Generated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}