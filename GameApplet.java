import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class GameApplet extends JApplet implements ActionListener {

	private CardDisplay[] displayUnshuffle;
	private CardDisplay[] displayShuffle;

	private JPanel panel = new JPanel();
	private JButton button = new JButton("Click Me");
	private JLabel label = new JLabel("Hello");

	public void init() {
		//this.setLayout(new GridLayout(0, 1));

		//panel.setLayout(new FlowLayout());
		button.addActionListener(this);
		button.setActionCommand("Click Me");
		panel.add(button);
		panel.add(label);

		this.add(panel);

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
		super.paint(g);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Click Me")) {
			if (label.getText().equals("Hello")) {
				label.setText("Goodbye");
			}else {
				label.setText("Hello");
			}
		}

	}

}