package poker;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {

    Hand instance;

    @Before
    public void setUp() {
        Card card1 = new Card("A", "C");
        Card card2 = new Card("2", "C");
        Card card3 = new Card("3", "C");
        Card card4 = new Card("4", "C");
        Card card5 = new Card("5", "C");
        instance = new Hand();
        instance.setCardsInHand(card1);
        instance.setCardsInHand(card2);
        instance.setCardsInHand(card3);
        instance.setCardsInHand(card4);
        instance.setCardsInHand(card5);
    }

    /**
     * Test of getCards method, of class Hand.
     */
    @Test
    public void testGetCards() {
        List<Card> expResult = Arrays.asList(new Card("A", "C"), new Card("2", "C"), new Card("3", "C"), new Card("4", "C"), new Card("5", "C"));
        List<Card> result = instance.getCards();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getRank(), result.get(i).getRank());
        }
    }

    /**
     * Test of getRanksValue method, of class Hand.
     */
    @Test
    public void testGetRanksValue() {
        List<Integer> expResult = Arrays.asList(14, 2, 3, 4, 5);
        List<Integer> result = instance.getRanksValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuitsValue method, of class Hand.
     */
    @Test
    public void testGetSuitsValue() {
        List<Integer> expResult = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> result = instance.getSuitsValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRanksToString method, of class Hand.
     */
    @Test
    public void testGetRanksToString() {
        String expResult = "A 2 3 4 5 ";
        String result = instance.getRanksToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRanksValueToString method, of class Hand.
     */
    @Test
    public void testGetRanksValueToString() {
        String expResult = "1402030405";
        String result = instance.getRanksValueToString();
        assertEquals(expResult, result);
    }

}
