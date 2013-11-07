import java.util.Random;

public class Deck {

	private Card[] deck;
	private int positionInDeck = 0;

	public Deck() {
		deck = new Card[52];
		setDeck();
		shuffleDeck();
	}

	public Deck(String x) {
		deck = new Card[52];
		setDeck();
	}

	//creates a deck with cards in order
	//1 = Ace: 11,12,13 = Face cards
	public void setDeck() {
		int cardNumber = 1;
		for (int i=0; i<deck.length; i=i+4) {
			deck[i] = new Card(cardNumber, "Heart");
			deck[i+1] = new Card(cardNumber, "Spade");
			deck[i+2] = new Card(cardNumber, "Diamond");
			deck[i+3] = new Card(cardNumber, "Club");
			
			cardNumber++;
		}
	}

	public void shuffleDeck() {
		Random random = new Random();
		for (int i=0; i<deck.length; i++) {
			int n = random.nextInt(52-i) + i;

			Card extraCard = deck[i];
			deck[i] = deck[n];
			deck[n] = extraCard;
		}
	}

	//picks the next card in the deck that hasn't been drawn 
	public Card drawCard() {
		positionInDeck++;
		return deck[positionInDeck-1];
	}

	public void printDeck() {
		for (int i=0; i<deck.length; i++) {
			System.out.println(i+1 + ": " + deck[i].getNumber() + ", " + deck[i].getSuit());
		}
	}
}