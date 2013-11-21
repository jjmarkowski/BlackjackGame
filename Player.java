public class Player {

	private Hand hand;
	private PlayerPanel panel;

	public Player(Card cardDrawn1, Card cardDrawn2) {
		hand = new Hand();
		panel = new PlayerPanel(cardDrawn1, cardDrawn2);
	}

	public void addCard(Card cardDrawn) {
		hand.addCard(cardDrawn);
		panel.addCard(cardDrawn);
	}

	public int handValue() {
		return hand.handValue();
	}

	public PlayerPanel getPanel() {
		return panel;
	}

}