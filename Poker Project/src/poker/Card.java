package poker;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(String rank, String suit){
        this.rank = Rank.getRankByStr(rank);
        this.suit = Suit.getSuitByStr(suit);
    }
    
    public void setRank(Rank r){
        this.rank = r;
    }
    
    public void setSuit(Suit s){
        this.suit = s;
    }
    
    public String getRankAcronyms() {
        return rank.getAcronyms();
    }

    public String getSuitAcronyms() {
        return suit.getAcronyms();
    }
    
    public int getRankValue(){
        return rank.getValue();
    }
    
    public int getSuitValue(){
        return suit.getValue();
    }
}


