package omegapoint;

import java.util.Optional;

public class LuhnCheck implements ValidityCheck {
    @Override
    public Optional<String> apply(String maybePno) {
        return Optional.empty();
    }

    public String checkSum(final String pno) {
        final String allDigits = pno.replaceAll("[^\\d]+", "");
        System.out.println("allDigits is " + allDigits);
        if (allDigits.length() < 10) {
            return ("Too few digits");
        }
        final String lastNine = allDigits.substring(allDigits.length() - 10, allDigits.length() - 1);
        final String actualChecksum = allDigits.substring(allDigits.length() - 1);
        System.out.println("lastNine = " + lastNine);
        System.out.println("actualChecksum = " + actualChecksum);
        char[] digits = lastNine.toCharArray();

        int sum = 0;
        int multiplier = 2;
        for (char d : digits) {
            int x = Character.getNumericValue(d);
            sum += add(x, multiplier);
            multiplier = 3 - multiplier;
        }

        if (sum % 10 == 0) {
            System.out.println("Checksum is zero");
            return "";
        } else {
            // System.out.println("Checksum is " + sum); // XXX Ser inte rätt ut
            // int sub = sum - (sum % 10)  + 10 - sum;
            int sub = sum - (sum % 10) + 10 - sum;
            System.out.println("Computed checksum " + sub);
            return "";
        }
    }

    public int add(int digit, int multiplier) {
        final int res0 = digit * multiplier;
        return (res0 < 10) ? res0 : (1 + (res0 % 10));
    }
}
