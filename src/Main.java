import java.util.*;

public class Main {
    public static String formatHandType(HandType type) {
        String s = "";
        String name = type.name();

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (i > 0 && Character.isUpperCase(c)) {
                s += ' ';
            }
            s += c;
        }

        return s;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the seed value: ");
        int seed = scanner.nextInt();

        Deck deck = new Deck(seed);

        for (int i = 0; i < 5; i++) {
            deck.shuffle(676);
            Hand hand = deck.deal();
            System.out.println( hand + "   ");
        }


        System.out.print("Enter the number of hands: ");
        int numHands = scanner.nextInt();

        EnumMap<HandType, Integer> handCounts = new EnumMap<>(HandType.class);
        for (HandType type : HandType.values()) 
        {
            handCounts.put(type, 0);
        }

        for (int i = 0; i < Math.abs(numHands); i++) 
        {
            deck.shuffle(676);
            Hand hand = deck.deal();
            HandType handType = hand.getHandType();
            handCounts.put(handType, handCounts.get(handType) + 1);
        }

        System.out.println("Hand Type Counts:");
        for (HandType type : HandType.values()) {
            int count = handCounts.get(type);
            double percentage = (numHands > 0) ? (count / (double) numHands) * 100 : 0.0;
            if(percentage == 0)
            {
                count = 0;
            }
            System.out.printf("%-20s %7d   %.5f%%%n", formatHandType(type), count, percentage);
        }
    }
}


