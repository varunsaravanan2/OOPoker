import java.util.*;
public class Hand {
    private Card[] cards;

    public Hand(Card[] c)
     {
        cards = c;
        for (int i = 0; i < cards.length - 1; i++) 
        {
            for (int j = 0; j < cards.length - i - 1; j++) 
            {
                if (cards[j].compareTo(cards[j + 1]) > 0) 
                { 
                    Card temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }

    public Card[] getCards() 
    {
        return cards;
    }

    public HandType getHandType() {
        HashMap<Integer, Integer> rankCount = new HashMap<>();
        HashMap<Integer, Integer> suitCount = new HashMap<>();

        for (Card card : cards) {
    
            int rank = card.getRank();
            if (!rankCount.containsKey(rank)) 
            {
                rankCount.put(rank, 1);
            } 
            else 
            {
                rankCount.put(rank, rankCount.get(rank) + 1);
            }

            int suit = card.getSuit();
            if (!suitCount.containsKey(suit)) 
            {
                suitCount.put(suit, 1);
            } else 
            {
                suitCount.put(suit, suitCount.get(suit) + 1);
            }
        }

        boolean isFlush = suitCount.size() == 1;

        ArrayList<Integer> ranks = new ArrayList<>(rankCount.keySet());

        for (int i = 0; i < ranks.size() - 1; i++)
        {
            for (int j = i + 1; j < ranks.size(); j++) 
            {
                if (ranks.get(i) > ranks.get(j)) 
                {
                    int temp = ranks.get(i);
                    ranks.set(i, ranks.get(j));
                    ranks.set(j, temp);
                }
            }
        }

        boolean isStraight = ranks.size() == 5 && (ranks.get(4) - ranks.get(0) == 4);

        ArrayList<Integer> freq = new ArrayList<>(rankCount.values());
        for (int i = 0; i < freq.size() - 1; i++) 
        {
            for (int j = i + 1; j < freq.size(); j++) 
            {
                if (freq.get(i) < freq.get(j)) 
                {
                    int temp = freq.get(i);
                    freq.set(i, freq.get(j));
                    freq.set(j, temp);
                }
            }
        }

        if (isStraight && isFlush) {
            return HandType.StraightFlush;
        } 
        else if (freq.size() == 2 && freq.get(0) == 4) {
            return HandType.FourOfAKind;
        } 
        else if (freq.size() == 2 && freq.get(0) == 3 && freq.get(1) == 2) {
            return HandType.FullHouse;
        } 
        else if (isFlush) {
            return HandType.Flush;
        } 
        else if (isStraight) {
            return HandType.Straight;
        } 
        else if (freq.size() == 3 && freq.get(0) == 3) {
            return HandType.ThreeOfAKind;
        }
        else if (freq.size() == 3 && freq.get(0) == 2 && freq.get(1) == 2) {
            return HandType.TwoPair;
        } 
        else if (freq.size() == 4 && freq.get(0) == 2) {
            return HandType.OnePair;
        } 
        else 
        {
            return HandType.HighCard;
        }
    }

    public String toString() 
    {
        String sb = "";
        for (int i = 0; i < cards.length; i++) 
        {
            if (cards[i].getRank() != 10) 
                sb += cards[i];
            else 
                sb = sb.trim() + " " + cards[i];

            if (i < cards.length - 1)
             {
                sb += "  ";
            }
          
        }
        return sb;
    }
}
