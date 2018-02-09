package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand {

    private List<Card> cards;
    private List<Integer> ranksValue;
    private List<Integer> suitsValue;

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

    public List<Card> getCards() {
        return cards;
    }

    public List<Integer> getRanksValue() {
        return ranksValue;
    }

    public List<Integer> getSuitsValue() {
        return suitsValue;
    }

    public void sortCard() {
        cards.sort(Comparator.comparing(Card::getRankValue).reversed());
        Collections.sort(ranksValue, Collections.reverseOrder());

        List<Integer> specialCase1 = Arrays.asList(14, 5, 4, 3, 2);
        if (ranksValue.equals(specialCase1)) {
            ranksValue = Arrays.asList(5, 4, 3, 2, 1);
            cards.get(0).setRank("1");
            sortCard();
        }
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
