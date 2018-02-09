package poker;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokerTest {

    Poker instance;

    @Before
    public void setUp() {
        instance = new Poker();
    }

    /**
     * Test of checkInput method, of class Poker.
     */
    @Test
    public void testCheckInput() {
        String cardInput = "2D 4D 6D JD TD";
        assertEquals(true, instance.checkInput(cardInput));
    }

    /**
     * Test of checkCardInPlay method, of class Poker.
     */
    @Test
    public void testCheckCardInPlay() {
        String cardInput = "2D 4D 6D JD TD";
        assertEquals("OK", instance.checkCardInPlay(cardInput));
    }

    /**
     * Test of createNewPlayer method, of class Poker.
     */
    @Test
    public void testCreateNewPlayer() {
        Player result = instance.createNewPlayer("Player1", "2D 4D 6D JD TD");
        assertEquals("Player", result.getClass().getSimpleName());
        assertEquals("Player1", result.getName());
    }

    /**
     * Test of showDown method, of class Poker.
     */
    @Test
    public void testShowDown() {
        System.out.println("showDown");
        Player player1 = instance.calculatePlayerHand(instance.createNewPlayer("Player1", "9S 9H 9D 9C AC"));
        Player player2 = instance.calculatePlayerHand(instance.createNewPlayer("Player2", "AS QS KS JS TS"));
        Player result = instance.showDown(player1, player2);
        assertEquals(player2, result);
    }
    
    /**
     * Test of calculatePlayerHand method, of class Poker.
     */
    @Test
    public void testCalculatePlayerHand() {
        System.out.println("calculatePlayerHand");
        Player player = instance.createNewPlayer("Player1", "9S 9H 9D 9C AC");
        Player result = instance.calculatePlayerHand(player);
        assertEquals("709", result.getScore());
    }
    
    /**
     * Test of straightFlush method, of class Poker.
     */
    @Test
    public void testStraightFlush() {
        Player player = instance.createNewPlayer("Player", "AS QS KS JS TS");
        List<Integer> ranks = player.getHand().getRanksValue();
        List<Integer> suits = player.getHand().getSuitsValue();
        boolean result = instance.straightFlush(ranks, suits);
        assertEquals(true, result);
    }

    /**
     * Test of straight method, of class Poker.
     */
    @Test
    public void testStraight() {
        Player player = instance.createNewPlayer("Player", "AD 5H 4C 3C 2S");
        boolean result = instance.straight(player.getHand().getRanksValue());
        assertEquals(true, result);
    }

    /**
     * Test of flush method, of class Poker.
     */
    @Test
    public void testFlush() {
        Player player = instance.createNewPlayer("Player", "2D 4D 6D JD TD");
        boolean result = instance.flush(player.getHand().getSuitsValue());
        assertEquals(true, result);
    }

    /**
     * Test of fullHouse method, of class Poker.
     */
    @Test
    public void testFullHouse() {
        Player player = instance.createNewPlayer("Player", "8S 8H 8D 7C 7S");
        boolean result = instance.fullHouse(player.getHand().getRanksValue());
        assertEquals(true, result);
    }

    /**
     * Test of twoPair method, of class Poker.
     */
    @Test
    public void testTwoPair() {
        Player player = instance.createNewPlayer("Player", "8C QH QC KC KD");
        List<Integer> expResult = Arrays.asList(13, 12);
        List<Integer> result = instance.twoPair(player.getHand().getRanksValue());
        assertEquals(expResult, result);
    }

    /**
     * Test of kind method, of class Poker.
     */
    @Test
    public void testKind() {
        Player player = instance.createNewPlayer("Player", "2H 3H 4H 5C 5S");
        int result = instance.kind(2, player.getHand().getRanksValue());
        assertEquals(5, result);
    }

}
