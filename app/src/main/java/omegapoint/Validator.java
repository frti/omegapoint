package omegapoint;

import java.util.LinkedList;
import java.util.List;

class Validator {
    private final List<ValidityCheck> validityChecks = List.of(new LuhnCheck());
    List<String> validate(final String maybePno) {
        return new LinkedList<>();
    }
}
