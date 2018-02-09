package poker;

public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public int getRankValue(){
        return "-123456789TJQKA".indexOf(rank);
    }
    
    public int getSuitValue(){
        return "-CDHS".indexOf(suit);
    }
}


