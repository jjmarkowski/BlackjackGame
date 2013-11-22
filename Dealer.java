public class Dealer extends Player {

	private Card cardDrawn2;
	
	public Dealer(Card cardDrawn1, Card cardDrawn2) {
		super(cardDrawn1, cardDrawn2, 5);
		this.cardDrawn2 = cardDrawn2;
		
	}

	// public void flipCard() {
	// 	super.flipCard(cardDrawn2);
	// }



}