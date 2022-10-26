package omegapoint;

import java.util.Optional;

public class PnoFormatCheck implements ValidityCheck {
    @Override
    public Optional<String> apply(String maybePno) {
        System.out.println("PnoFormatCheck: Checking " + maybePno);
        // 6 + 4, possibly a plus sign
        if (maybePno.matches("^\\d{6}[+-]?\\d{4}$")) {
            System.out.println("Matches 6+-4");
            return Optional.empty();
        } else if (maybePno.matches("^(18|19|20)\\d{6}-?\\d{4}$")) {
            System.out.println("Matches with century");
            return Optional.empty();
        } else {
            return Optional.of("No match for pno format");
        }
    }
}
