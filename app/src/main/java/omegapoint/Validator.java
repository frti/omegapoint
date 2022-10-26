package omegapoint;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class Validator {
    private final List<ValidityCheck> validityChecks = List.of(new LuhnCheck(), new PnoFormatCheck());
    ValidateResponse validate(final String maybePno) {
        List<String> errors = new LinkedList<>();
         for (ValidityCheck check: validityChecks) {
            System.out.println("Running " + check)  ;
            Optional<String> maybeError = check.apply(maybePno);
             maybeError.ifPresent(errors::add);
        }
        return new ValidateResponse(errors);
    }
}
