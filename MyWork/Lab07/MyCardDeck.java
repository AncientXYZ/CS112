import java.util.Random;

class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        if (value >= 2 && value <= 14 && isValidSuit(suit)) {
            this.value = value;
            this.suit = suit.toUpperCase().substring(0, 1);
        } else {
            setError();
        }
    }

    // Constructor for a card from a string
    public Card(String text) {
        // If the string is null or too short, set an error
        if (text == null || text.length() < 2) {
            setError();
            return;
        }

        char firstChar = text.charAt(0);
        this.value = setValueFromChar(firstChar);
        String suitText = text.length() >= 3 && this.value == 10 ? text.substring(2, 3) : text.substring(1, 2);

        if (this.value == 0 || !isValidSuit(suitText)) {
            setError();
        } else {
            this.suit = suitText.toUpperCase();
        }
    }

    // Check if the suit is legal
    private boolean isValidSuit(String s) {
        return s.equalsIgnoreCase("S") || s.equalsIgnoreCase("H") || s.equalsIgnoreCase("C") || s.equalsIgnoreCase("D");
    }

    private void setError() {
        this.value = 0;
        this.suit = "ERROR";
    }

    // match the value of the card from a character
    private int setValueFromChar(char c) {
        if (Character.isDigit(c)) {
            int num = Character.getNumericValue(c);
            return (num >= 2 && num <= 9) ? num : 0;
        } else {
            return switch (Character.toUpperCase(c)) {
                case 'J' -> 11;
                case 'Q' -> 12;
                case 'K' -> 13;
                case 'A' -> 14;
                default -> 0;
            };
        }
    }

    public int Value() {
        return value;
    }

    public String Suit() {
        return suit;
    }

    // Return a String that shows the value of this Card.
    public String toString() {
        if ("ERROR".equals(this.suit)) {
            return "ERROR";
        }

        String valStr = switch (this.value) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> String.valueOf(this.value);
        };
        return valStr + this.suit;
    }
}

class Deck {
    private final Card[] allMyCards = new Card[52];

    // Constructor for a deck of cards
    public Deck() {
        int index = 0;
        String[] suits = {"S", "H", "C", "D"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                allMyCards[index++] = new Card(value, suit);
            }
        }
    }

    // Return a String that shows the value of this Deck.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : allMyCards) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString().trim();
    }

    // Shuffle the deck
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < allMyCards.length; i++) {
            int randomIndex = rand.nextInt(allMyCards.length);
            Card temp = allMyCards[i];
            allMyCards[i] = allMyCards[randomIndex];
            allMyCards[randomIndex] = temp;
        }
    }
}

public class MyCardDeck {
    public static void main(String[] args) {
        if (args.length > 0) {
            Card yourCard = new Card(args[0]);
            System.out.println(yourCard);
        } else {
            Deck deck = new Deck();
            deck.shuffle();
            System.out.println(deck);
        }
    }
}
