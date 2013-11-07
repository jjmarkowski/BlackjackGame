public class Player {

	private Hand player;
	private double balance;
	private double betAmount;

	public Player(double balance) {
		this.balance = balance;
		player = new Hand();
	}

	public void bet(double bet) {

	}

	public int handValue() {
		return player.handValue();
	}

	public void addCard(Card cardDrawn) {
		player.addCard(cardDrawn);
	}

	public void printHand() {
		player.printHand();
	}

	public double getBalance() {
		return balance;
	}


}