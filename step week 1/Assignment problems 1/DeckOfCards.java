import java.util.Scanner;

class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    public static void distributeCards(String[] deck, int players, int cardsEach) {
        if (players * cardsEach > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return;
        }

        String[][] playerCards = new String[players][cardsEach];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsEach; j++) {
                playerCards[i][j] = deck[index++];
            }
        }

        for (int i = 0; i < players; i++) {
            System.out.print("Player " + (i+1) + ": ");
            for (int j = 0; j < cardsEach; j++) {
                System.out.print(playerCards[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards each: ");
        int cardsEach = sc.nextInt();

        distributeCards(deck, players, cardsEach);
    }
}