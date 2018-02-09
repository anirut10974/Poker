package poker;

import java.util.HashMap;
import java.util.Map;

public enum Suit {

    CLUB("C",1),DIAMOND("D",2),HEART("H",3),SPADE("S",4);

    private final String acronyms;
    private final int value;

    private Suit(String suitAcronyms, int suitValue) {
        this.acronyms = suitAcronyms;
        this.value = suitValue;
    }

    private static final Map<String, Suit> map = new HashMap<String, Suit>();

    static {
        for (Suit sv : Suit.values()) {
            map.put(sv.getAcronyms(), sv);
        }
    }
    
    public String getAcronyms() {
        return acronyms;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitByStr(String s) {
        return map.get(s);
    }
}
