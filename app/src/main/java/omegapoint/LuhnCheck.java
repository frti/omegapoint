package omegapoint;

import java.util.Optional;

public class LuhnCheck implements ValidityCheck {

    @Override
    public Optional<String> apply(String maybePno) {
        final String allDigits = maybePno.replaceAll("[^\\d]+", "");
        System.out.println("allDigits is " + allDigits);
        if (allDigits.length() < 10) {
            return Optional.of("Too few digits");
        }
        final String lastNine = allDigits.substring(allDigits.length() - 10, allDigits.length() - 1);
        final String actualChecksum = allDigits.substring(allDigits.length() - 1);
        char[] digits = lastNine.toCharArray();

        int sum = 0;
        int multiplier = 2;
        for (char d : digits) {
            sum += add(Character.getNumericValue(d), multiplier);
            multiplier = 3 - multiplier;
        }

        String computedChecksum = (sum % 10 == 0) ? "" : "" + (sum - (sum % 10) + 10 - sum);
        System.out.println("Computed checksum is " + computedChecksum);
        return (computedChecksum.equals(actualChecksum) ?
                Optional.empty() :
                Optional.of("Checksum mismatch"));
    }

    public int add(int digit, int multiplier) {
        final int res0 = digit * multiplier;
        return (res0 < 10) ? res0 : (1 + (res0 % 10));
    }
}
