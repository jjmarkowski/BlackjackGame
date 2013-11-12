public class Player {

	private Hand hand;

	public Player() {
		hand = new Hand();
	}

	public void addCard(Card cardDrawn) {
		hand.addCard(cardDrawn);
	}

	public int handValue() {
		return hand.handValue();
	}

}