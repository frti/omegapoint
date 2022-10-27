package omegapoint;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuhnCheckTest {

    @Test
    void validChecksum() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("811218-9876");
        assertTrue(r.isEmpty());
    }

    @Test
    void validChecksum2() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("141206-2380");
        assertTrue(r.isEmpty());
    }

    @Test
    void invalidChecksum() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("811218-9879");
        assertFalse(r.isEmpty());
    }

    @Test
    void tooShortPno() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("811218-987");
        assertFalse(r.isEmpty());
    }

    @Test
    void invalidChecksum2() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("201701272394");
        assertFalse(r.isEmpty());
    }

    @Test
    void validChecksumInvalidPno() {
        LuhnCheck luhn = new LuhnCheck();
        Optional<String> r = luhn.apply("190302299813");
        assertTrue(r.isEmpty());
    }
}