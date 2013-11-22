public class Dealer {

	private Hand hand;
	private PlayerPanel panel;
	private Card extraCard;
	
	public Dealer(Card cardDrawn1, Card cardDrawn2) {
		hand = new Hand();
		hand.addCard(cardDrawn1);
		hand.addCard(cardDrawn2);
		extraCard = cardDrawn2;
		panel = new PlayerPanel(cardDrawn1);
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

	public void flipCard() {
		panel.flipCard(extraCard);
	}

}