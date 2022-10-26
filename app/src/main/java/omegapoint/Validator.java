package omegapoint;

import java.util.LinkedList;
import java.util.List;

class Validator {
    private final List<ValidityCheck> validityChecks = List.of(new LuhnCheck());
    ValidateResponse validate(final String maybePno) {
        return new ValidateResponse(new LinkedList<String>());
    }
}
