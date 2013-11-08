import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;

//public class GameApplet extends JApplet implements ActionListener {
public class GameApplet extends Applet {

	private Deck deckUnshuffle;
	private Deck deckShuffle;

	// private JPanel panel = new JPanel();
	// private JButton button = new JButton("Click Me");
	// private JLabel label = new JLabel("Hello");

	public void init() {

		//this.setLayout(new GridLayout(0, 1));

		//panel.setLayout(new FlowLayout());
		// button.addActionListener(this);
		// button.setActionCommand("Click Me");
		// panel.add(button);
		// panel.add(label);

		// this.add(panel);
		
		deckUnshuffle = new Deck("Unshuffle");
		deckShuffle = new Deck();

	}

	public void paint(Graphics g) {
		//super.paint(g);
		
		int scale = 25;
		int x = 50;

		for (int i=0; i<52; i++) {
			Card cardDrawn = deckUnshuffle.drawCard();
			cardDrawn.draw(g, new Rectangle(x, 50, scale*2, scale*3));
			x += scale;
		}

		x = 50;

		for (int i=0; i<52; i++) {
			Card cardDrawn = deckShuffle.drawCard();
			cardDrawn.draw(g, new Rectangle(x, 200, scale*2, scale*3));
			x += scale;
		}

	}

	// public void actionPerformed(ActionEvent e) {
	// 	if (e.getActionCommand().equals("Click Me")) {
	// 		if (label.getText().equals("Hello")) {
	// 			label.setText("Goodbye");
	// 		}else {
	// 			label.setText("Hello");
	// 		}
	// 	}

	// }

}