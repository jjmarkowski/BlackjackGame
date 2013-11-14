import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

public class GameApplet extends JApplet implements ActionListener {
//public class GameApplet extends Applet {

	private Deck deckUnshuffle;
	private Deck deckShuffle;
	private JPanel panel = new JPanel();

	public void init() {
		deckUnshuffle = new Deck("Unshuffle");
		Card cardDrawn = deckUnshuffle.drawCard();

		this.setLayout(new GridLayout(2, 1));

		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel(cardDrawn.returnImageIcon());
		panel.add(label);
		cardDrawn = deckUnshuffle.drawCard();
		JLabel label2 = new JLabel(cardDrawn.returnImageIcon());
		panel.add(label2);

		this.add(panel);

		// deckUnshuffle = new Deck("Unshuffle");
		// deckShuffle = new Deck();
		// Card cardDrawn = deckUnshuffle.drawCard();

		// JLabel label = new JLabel("Hello");

		// JPanel down = new JPanel();
		// down.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		// down.add(label);

		// this.add(panel);

				
		// deckUnshuffle = new Deck("Unshuffle");
		// deckShuffle = new Deck();

	}

	public void paint(Graphics g) {
		super.paint(g);
		
		// int scale = 25;
		// int x = 50;

		// for (int i=0; i<52; i++) {
		// 	Card cardDrawn = deckUnshuffle.drawCard();
		// 	cardDrawn.draw(g, new Rectangle(x, 50, scale*2, scale*3));
		// 	x += scale;
		// }

		// x = 50;

		// for (int i=0; i<52; i++) {
		// 	Card cardDrawn = deckShuffle.drawCard();
		// 	cardDrawn.draw(g, new Rectangle(x, 200, scale*2, scale*3));
		// 	x += scale;
		// }

	}

	public void actionPerformed(ActionEvent e) {
		// if (e.getActionCommand().equals("Click Me")) {
		// 	if (label.getText().equals("Hello")) {
		// 		label.setText("Goodbye");
		// 	}else {
		// 		label.setText("Hello");
		// 	}
		// }

	}

}