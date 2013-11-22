public class Human {

	private Hand hand;
	private PlayerPanel panel;
	private double balance;
	private double bet;
	
	public Human(double balance, Card cardDrawn1, Card cardDrawn2) {
		hand = new Hand();
		hand.addCard(cardDrawn1);
		hand.addCard(cardDrawn2);
		panel = new PlayerPanel(cardDrawn1, cardDrawn2);
		balance = balance;
		bet = 0;
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

	public void bet(double betAmount) {
		bet += betAmount;
		balance -= betAmount;
	}

	public double betAmount() {
		return bet;
	}

	public void betReturn(int x) {
		if (x==1) {
			balance += (bet * 2);
		}
		bet = 0;
	}

	public double getBalance() {
		return balance;
	}
}