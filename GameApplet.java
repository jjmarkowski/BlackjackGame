import java.awt.*;
import java.applet.*;

public class GameApplet extends Applet {

	private CardDisplay[] displayUnshuffle;
	private CardDisplay[] displayShuffle;

	public void init() {

		displayUnshuffle = new CardDisplay[52];
		displayShuffle = new CardDisplay[52];

		Deck playingDeck = new Deck("Unshuffle");

		for (int i=0; i<52; i++) {
			Card cardDrawn = playingDeck.drawCard();
			displayUnshuffle[i] = new CardDisplay(cardDrawn.getName());
		}

		Deck playingDeckShuffle = new Deck("");
		playingDeckShuffle.shuffleDeck();

		for (int i=0; i<52; i++) {
			Card cardDrawn = playingDeckShuffle.drawCard();
			displayShuffle[i] = new CardDisplay(cardDrawn.getName());
		}
	}

	public void paint(Graphics g) {
		int scale = 20;
		int x = 50;

		for (int i=0; i<52; i++) {
			displayUnshuffle[i].draw(g, new Rectangle(x, 50, scale*2, scale*3));
			x += scale;
		}

		x = 50;
		for (int i=0; i<52; i++) {
			displayShuffle[i].draw(g, new Rectangle(x, 200, scale*2, scale*3));
			x += scale;
		}

	}

}