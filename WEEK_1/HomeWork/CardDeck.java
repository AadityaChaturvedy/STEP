import java.util.Scanner;
import java.util.Random;

public class CardDeck {

    private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static String[] deck;

    public static void initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        deck = new String[numOfCards];
        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[i++] = rank + " of " + suit;
            }
        }
    }

    public static void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomCardIndex = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[randomCardIndex];
            deck[randomCardIndex] = temp;
        }
    }

    public static String[][] distributeCards(int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            return null;
        }
        String[][] playersHands = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playersHands[j][i] = deck[cardIndex++];
            }
        }
        return playersHands;
    }

    public static void printPlayerHands(String[][] playersHands) {
        if (playersHands == null) {
            System.out.println("Cannot distribute cards as requested.");
            return;
        }
        for (int i = 0; i < playersHands.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s cards:");
            for (String card : playersHands[i]) {
                System.out.println("  " + card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        initializeDeck();
        shuffleDeck();
        
        String[][] playerHands = distributeCards(numPlayers, cardsPerPlayer);
        printPlayerHands(playerHands);
        
        scanner.close();
    }
}
