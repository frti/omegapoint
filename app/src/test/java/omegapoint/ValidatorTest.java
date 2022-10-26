package omegapoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    void valid1() {
        ValidateResponse response = validator.validate("201701102384");
        assertFalse(response.isValid());
    }

    @Test
    void invalid1() {
        ValidateResponse response = validator.validate("201701272394");
        assertFalse(response.isValid());
    }

    @Test
    void invalidChecksum() {
        ValidateResponse response = validator.validate("201701272395");
        assertFalse(response.isValid());
    }
}