import java.util.*;

public class Deck {
    private ArrayList<Card> cards;
    private Random random;

    public Deck(int seed) 
    {
        cards = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            cards.add(new Card(i));
        }
        random = new Random(seed);
    }

    public void shuffle(int n) 
    {
        for (int i = 0; i < n; i++) {
            int in1 = random.nextInt(52);
            int in2 = random.nextInt(52);
            Card temp = cards.get(in1);
            cards.set(in1, cards.get(in2));
            cards.set(in2, temp);
        }
    }

    public Hand deal() 
    {
        ArrayList<Card> handCards = new ArrayList<>(cards.subList(0, 5));
        Card[] c = new Card[5];
        for(int i = 0; i < 5; i++)
        {
           c[i] = handCards.get(i);
        }
        return new Hand(c);
    }
    
}
