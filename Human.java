public class Human extends Player {

	private double balance;
	private double bet;
	
	public Human(double balance) {
		super();
		this.balance = balance;
	}

	public void bet(double betAmount) {
		this.bet = betAmount;
	}

	public void betReturn(int x) {
		if (x==1) {
			balance += bet;
		} else {
			balance -= bet;
		}
	}

	public double getBalance() {
		return this.balance;
	}
}