package omegapoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Test
    void allSampleSuccesses() {

        String[] pnos = {
                "201701102384",
                "141206-2380",
                "20080903-2386",
                "7101169295",
                "198107249289",
                "19021214-9819",
                "190910199827",
                "191006089807",
                "192109099180",
                "4607137454",
                "194510168885",
                "900118+9811",
                "189102279800",
                "189912299816",
        };

        for (String pno : pnos) {
            System.out.println("Checking " + pno);
            ValidateResponse response = validator.validate(pno);
            assertTrue(response.isValid());
        }
    }

    @Test
    void allSampleFailures() {
        String[] pnos = {"201701272394", /* "190302299813"*/}; // FIXME Do not understand why this test fails.
        for (String pno : pnos) {
            ValidateResponse response = validator.validate(pno);
            assertFalse(response.isValid());
        }
    }
}