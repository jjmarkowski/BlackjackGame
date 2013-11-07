public class Card {
	
	private int number;
	private String suit;
	private String name;

	public Card(int number, String suit) {
		setNumber(number);
		setSuit(suit);
		setName();
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setName() {
		if (number == 1) {
			this.name = "A" + suit + "s";
		} else if (number == 2) {
			this.name = "2" + suit + "s";
		} else if (number == 3) {
			this.name = "3" + suit + "s";
		} else if (number == 4) {
			this.name = "4" + suit + "s";
		} else if (number == 5) {
			this.name = "5" + suit + "s";
		} else if (number == 6) {
			this.name = "6" + suit + "s";
		} else if (number == 7) {
			this.name = "7" + suit + "s";
		} else if (number == 8) {
			this.name = "8" + suit + "s";
		} else if (number == 9) {
			this.name = "9" + suit + "s";
		} else if (number == 10) {
			this.name = "10" + suit + "s";
		} else if (number == 11) {
			this.name = "J" + suit + "s";
		} else if (number == 12) {
			this.name = "Q" + suit + "s";
		} else if (number == 13) {
			this.name = "K" + suit + "s";
		}
	}

	public int getNumber() {
		return number;
	}

	public String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}
}