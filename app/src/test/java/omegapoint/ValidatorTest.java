package omegapoint;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    private Validator validator = new Validator();

    @Test
    void valid1() {
        assertEquals(new LinkedList<>(), validator.validate("201701102384"));
    }
}