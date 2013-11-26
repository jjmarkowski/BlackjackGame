public class Human {

	private Hand hand;
	private PlayerPanel panel;
	private double balance;
	private double betTotal;
	
	public Human(double newBalance, Card cardDrawn1, Card cardDrawn2) {
		hand = new Hand();
		hand.addCard(cardDrawn1);
		hand.addCard(cardDrawn2);
		panel = new PlayerPanel(cardDrawn1, cardDrawn2);
		this.balance = newBalance;
		betTotal = 0;
	}

	public void newHand(Card cardDrawn1, Card cardDrawn2) {
		hand = new Hand();
		hand.addCard(cardDrawn1);
		hand.addCard(cardDrawn2);
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

	//evey bet adds to the betAmount and takes away from the balance
	public void bet(double betAmount) {
		betTotal += betAmount;
		balance -= betAmount;
	}

	public double getBetTotal() {
		return betTotal;
	}

	//x = 1 when the player won giving them their bet, x =2 when it was a draw in order to just give what the player bet back
	public void betReturn(int x) {
		if (x == 1) {
			balance += (betTotal * 2);
		} else if (x == 2) {
			balance += betTotal;
		}
		betTotal = 0;
	}

	public double getBalance() {
		return balance;
	}
}