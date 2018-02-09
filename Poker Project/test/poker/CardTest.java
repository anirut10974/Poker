package poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    /**
     * Test of getRankValue method, of class Card.
     */
    @Test
    public void testGetRankValue() {
        Card instance = new Card("A","C");
        int result = instance.getRankValue();
        assertEquals(14, result);
    }

    /**
     * Test of getSuitValue method, of class Card.
     */
    @Test
    public void testGetSuitValue() {
        Card instance = new Card("A","C");
        int result = instance.getSuitValue();
        assertEquals(1, result);
    }
    
}
