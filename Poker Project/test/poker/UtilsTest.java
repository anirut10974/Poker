package poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {

    /**
     * Test of validVariable method, of class Utils.
     */
    @Test
    public void testValidVariable() {
        System.out.println("validVariable");
        String code = "^(([2-9TJQKA][CDHS] ?){5})$";
        String variable = "AS QS KS JS TS";
        Utils instance = new Utils();
        boolean expResult = true;
        boolean result = instance.validVariable(code, variable);
        assertEquals(expResult, result);
    }

    /**
     * Test of twoDigits method, of class Utils.
     */
    @Test
    public void testTwoDigits() {
        System.out.println("twoDigits");
        int value = 8;
        Utils instance = new Utils();
        String expResult = "08";
        String result = instance.twoDigits(value);
        assertEquals(expResult, result);
    }
    
}
