package omegapoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnCheckTest {

    @Test
    void apply() {
        LuhnCheck luhn = new LuhnCheck();
        String r = luhn.checkSum("811218-9876");
        System.out.println("r is " + r);
    }
}