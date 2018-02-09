package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {

    private final ArrayList<Card> cards;
    private final ArrayList<Integer> ranksValue;
    private final ArrayList<Integer> suitsValue;

    public Hand() {
        cards = new ArrayList<>();
        ranksValue = new ArrayList<>();
        suitsValue = new ArrayList<>();
    }

    public void setCardsInHand(Card card) {
        cards.add(card);
        ranksValue.add(card.getRankValue());
        suitsValue.add(card.getSuitValue());
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Integer> getRanksValue() {
        return ranksValue;
    }

    public ArrayList<Integer> getSuitsValue() {
        return suitsValue;
    }
    
    public void sortCard(){
        cards.sort(Comparator.comparing(Card::getRankValue).reversed());
        Collections.sort(ranksValue,Collections.reverseOrder());
    }
    
    public String getRanksToString() {
        StringBuilder ar = new StringBuilder();
        cards.forEach((card) -> {
            ar.append(card.getRank()).append(" ");
        });  
        return ar.toString();
    }
    
    public String getRanksValueToString() {
        StringBuilder sum = new StringBuilder();
        ranksValue.forEach((rank) -> {
            sum.append(String.format("%02d", rank));
        });
        return sum.toString();
    }
}
