

public class Card implements Comparable<Card> {
    private int rank;
    private int suit;

    public Card(int value) 
    {
        
        this.rank = value / 4 + 1; 
        this.suit = value % 4;  
      
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    public String toString() {
       String[] suits = {"S", "H", "D", "C"};
        String rankStr = "";
        if(rank == 1)
        {
            rankStr = "A";
        }
        else if(rank <= 10)
        {
            rankStr = String.valueOf(rank);
        }
        else if(rank == 11)
        {
            rankStr = "J";
        }
        else if(rank == 12)
        {
            rankStr = "Q";
        }
        else
        {
            rankStr = "K";
        }

        return rankStr + suits[suit];
    }
    public int compareTo(Card other) {
       if(this.rank != other.rank)
        return Integer.compare(this.rank, other.rank);
       else
        return Integer.compare(this.suit, other.suit);
    }
}
