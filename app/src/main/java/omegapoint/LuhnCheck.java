package omegapoint;

import java.util.Optional;

public class LuhnCheck implements ValidityCheck {
    @Override
    public Optional<String> apply(String maybePno) {
        return Optional.empty();
    }
}
