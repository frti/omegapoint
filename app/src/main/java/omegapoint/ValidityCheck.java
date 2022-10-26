package omegapoint;

import java.util.Optional;

public interface ValidityCheck {
    Optional<String> apply(final String maybePno);
}
