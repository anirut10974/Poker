/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

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
