package poker;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    ONE("A",1),TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), 
    SIX("6", 6),SEVEN("7", 7), EIGHT("8", 8), NING("9", 9), TEN("T", 10),
    JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);

    private final String acronyms;
    private final int value;

    private Rank(String rankAcronyms, int rankValue) {
        this.acronyms = rankAcronyms;
        this.value = rankValue;

    }

    private static final Map<String, Rank> map = new HashMap<String, Rank>();

    static {
        for (Rank rv : Rank.values()) {
            map.put(rv.getAcronyms(), rv);
        }
    }
    
    public String getAcronyms() {
        return acronyms;
    }

    public int getValue() {
        return value;
    }

    public static Rank getRankByStr(String s) {
        return map.get(s);
    }
}
