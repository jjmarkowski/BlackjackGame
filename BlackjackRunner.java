import java.util.Scanner;

class BlackjackRunner {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int userInput;

		Deck playingDeck = new Deck();

		Player user = new Player(200.0);
		//Hand house = new Hand();

		Card cardDrawn = playingDeck.drawCard();
		user.addCard(cardDrawn);
		cardDrawn = playingDeck.drawCard();
		user.addCard(cardDrawn);
		user.printHand();
		System.out.println("Value= " + user.handValue());
		System.out.println();

		System.out.println("Draw(1)\tStay(0)");
		userInput = reader.nextInt();

		while(userInput == 1) {
			cardDrawn = playingDeck.drawCard();
			user.addCard(cardDrawn);
			user.printHand();
			System.out.println("Value: " + user.handValue());
			System.out.println();
			System.out.println("Draw(1)\tStay(0)");
			userInput = reader.nextInt();
		}

		// Card cardDrawn = playingDeck.drawCard();
		// user.addCard(cardDrawn);
		// cardDrawn = playingDeck.drawCard();
		// user.addCard(cardDrawn);

		// System.out.println(user.handValue());

		playingDeck.printDeck();

	}
	
}