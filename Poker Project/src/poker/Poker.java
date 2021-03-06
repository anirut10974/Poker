package poker;

import java.util.*;

public class Poker extends Utils {

    final String PLAYINGCARD = "^(([2-9TJQKA][CDHS] ?){5})$";
    ArrayList<String> cardInPlay = new ArrayList<>();

    public void playPoker() {
        try (Scanner reader = new Scanner(System.in)) {
            //Input number of player
            System.out.print("How many player: ");
            int n = reader.nextInt();
            reader.nextLine();  //clear "\n"

            //Set variable
            Player winner = null;
            Player player;
            String playName;
            String cardInput;

            //Input player hand
            for (int i = 1; i <= n; i++) {
                playName = "Player"+i;
                System.out.print(playName + ": ");
                cardInput = reader.nextLine();
                
                //Check card input
                if(!checkInput(cardInput)){
                    i--;
                    continue;
                }
                
                //Create New Player
                player = createNewPlayer(playName, cardInput);

                //Calculate score player
                player = calculatePlayerHand(player);

                //Showdown player hand and current winner
                winner = showDown(winner, player);
            }

            //Print Winner
            if (winner != null) {
                System.out.println("\n" + winner.getName() + " win: " + winner.getDetail());
            }
        }
    }

    public boolean checkInput(String cardInput) {
        if (!validVariable(PLAYINGCARD, cardInput)) {
            System.err.println("Input card in hand is incorrect: skip this player");
            return false;
        }else if (!"OK".equals(checkCardInPlay(cardInput))) {
            System.err.println("Card [" + checkCardInPlay(cardInput) + "] is already in game");
            return false;
        }
        return true;
    }

    public String checkCardInPlay(String cardInput) {
        String[] cardArr = cardInput.toUpperCase().split(" ");
        for (String c : cardArr) {
            if (cardInPlay.contains(c)) {
                return c;
            }
        }
        return "OK";
    }

    public Player createNewPlayer(String name, String cardInput) {
        Player player = new Player();
        Hand hand = new Hand();
        String[] cardStr = cardInput.toUpperCase().split(" ");
        Card card;
        for (String cs : cardStr) {
            cardInPlay.add(cs);
            card = new Card(cs.substring(0, 1), cs.substring(1));
            hand.setCardsInHand(card);
        }
        player.setName(name);
        player.setHand(hand);

        return player;
    }

    public Player showDown(Player winner, Player player) {
        if (winner == null || player.getScore().compareTo(winner.getScore()) > 0) {
            return player;
        }
        return winner;
    }

    public Player calculatePlayerHand(Player player) {
        Hand hand = player.getHand();
        List<Card> cards = hand.getCards();
        List<Integer> ranks = hand.getRanksValue();
        List<Integer> suits = hand.getSuitsValue();

        if (straightFlush(ranks, suits)) {
            player.setScore("8" + twoDigits(Collections.max(ranks)) + suits.get(0));
            player.setDetail("Straight Flush ( MaxRank = " + cards.get(0).getRankAcronyms()+ " / Suit = " + cards.get(0).getSuitAcronyms() + " )");
        } else if (kind(4, ranks) > 0) {
            player.setScore("7" + twoDigits(kind(4, ranks)));
            player.setDetail("Four of a kind with card " + cards.get(ranks.indexOf(kind(4, ranks))).getRankAcronyms());
        } else if (fullHouse(ranks)) {
            player.setScore("6" + twoDigits(kind(3, ranks)));
            player.setDetail("Full House ( Kind3 = " + cards.get(ranks.indexOf(kind(3, ranks))).getRankAcronyms() + " / Kind2 = " + cards.get(ranks.indexOf(kind(2, ranks))).getRankAcronyms() + " )");
        } else if (flush(suits)) {
            player.setScore("5" + hand.getRanksValueToString());
            player.setDetail("Flush ( Kicker = " + hand.getRanksToString() + ")");
        } else if (straight(ranks)) {
            player.setScore("4" + twoDigits(Collections.max(ranks)));
            player.setDetail("Straight ( MaxRank = " + cards.get(0).getRankAcronyms() + " )");
        } else if (kind(3, ranks) > 0) {
            player.setScore("3" + twoDigits(kind(3, ranks)));
            player.setDetail("Three of a kind with card " + kind(3, ranks));
        } else if (twoPair(ranks).size() > 0) {
            player.setScore("2" + twoDigits(Collections.max(twoPair(ranks))) + twoDigits(Collections.min(twoPair(ranks))) + twoDigits(kind(1, ranks)));
            player.setDetail("Two pair ( HighPair " + cards.get(ranks.indexOf(Collections.max(twoPair(ranks)))).getRankAcronyms()
                    + " / LowPair " + cards.get(ranks.indexOf(Collections.min(twoPair(ranks)))).getRankAcronyms()
                    + " / Kicker " + cards.get(ranks.indexOf(kind(1, ranks))).getRankAcronyms() + " )");
            System.out.println(ranks.indexOf(kind(1, ranks)));
        } else if (kind(2, ranks) > 0) {
            player.setScore("1" + twoDigits(kind(2, ranks)) + hand.getRanksValueToString());
            player.setDetail("One pair with card " + cards.get(ranks.indexOf(kind(2, ranks))).getRankAcronyms() + " ( Kicker = " + hand.getRanksToString() + ")");
        } else {
            player.setScore("0" + hand.getRanksValueToString());
            player.setDetail("High card ( Kicker = " + hand.getRanksToString() + ")");
        }
        return player;
    }

    public boolean straightFlush(List<Integer> ranks, List<Integer> suits) {
        return (straight(ranks) && flush(suits));
    }

    public boolean straight(List<Integer> ranks) {
        Set<Integer> hs = new HashSet<>();
        hs.addAll(ranks);
        ranks = new ArrayList();
        ranks.addAll(hs);
        return ((Collections.max(ranks) - Collections.min(ranks) == 4) && ranks.size() == 5);
    }

    public boolean flush(List<Integer> suits) {
        Set<Integer> hs = new HashSet<>();
        suits.forEach((suit) -> {
            hs.add(suit);
        });
        return hs.size() == 1;
    }

    public boolean fullHouse(List<Integer> ranks) {
        return (kind(3, ranks) != 0 && kind(2, ranks) != 0);
    }

    public List<Integer> twoPair(List<Integer> ranks) {
        int highPair = kind(2, ranks);
        Collections.sort(ranks);
        int lowPair = kind(2, ranks);
        Collections.sort(ranks, Collections.reverseOrder());
        if (highPair != lowPair) {
            return Arrays.asList(highPair, lowPair);
        }
        return Arrays.asList();
    }

    public int kind(int n, List<Integer> ranks) {
        for (int r : ranks) {
            if (ranks.stream().filter(p -> p.equals(r)).count() == n) {
                return r;
            }
        }
        return 0;
    }
}
