package omegapoint;

import java.util.List;

public class ValidateResponse {
    public ValidateResponse(List<String> errors) {
        this.errors = errors;
    }

    final List<String> errors;
    public boolean isValid() { return errors.isEmpty(); }
}
