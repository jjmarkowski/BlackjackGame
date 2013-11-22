import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

import java.io.File;

import javax.imageio.ImageIO;

public class GameApplet extends Applet implements ActionListener {

	private Deck deck;
	private JPanel playerInterationPanel = new JPanel();
	private JButton stayButton = new JButton("Stay");
	private JButton hitButton = new JButton("Hit");

	// private JPanel humanHandPanel = new JPanel();
	// private JPanel dealerHandPanel = new JPanel();

	private Player[] player = new Player[2];

	public void init() {

		deck = new Deck();
		//player[0] = new Human(200.0);
		//player[1] = new Dealer();

		this.setLayout(new GridLayout(0, 1));

		//button set up
		playerInterationPanel.setLayout(new FlowLayout());
		stayButton.addActionListener(this);
		stayButton.setActionCommand("Stay");
		playerInterationPanel.add(stayButton);
		hitButton.addActionListener(this);
		hitButton.setActionCommand("Hit");
		playerInterationPanel.add(hitButton);

		this.add(playerInterationPanel);

		//Human cards/panel
		Card cardDrawn1 = deck.drawCard();
		Card cardDrawn2 = deck.drawCard();
		player[0] = new Human(200.0, cardDrawn1, cardDrawn2);
		this.add(player[0].getPanel());

		//Dealer cards/panel
		// dealerHandPanel.setLayout(new FlowLayout());
		// JLabel dealerTag = new JLabel("Dealer");
		// dealerTag.setFont(new Font("sansserif", Font.BOLD, 32));
		// dealerHandPanel.add(dealerTag);

		// cardDrawn = deck.drawCard();
		// player[1].addCard(cardDrawn);
		// card1 = new JLabel(cardDrawn.returnImageIcon());
		// dealerHandPanel.add(card1);

		// cardDrawn = deck.drawCard();
		// player[1].addCard(cardDrawn);
		// //ImageIcon back  = new ImageIcon("images" + File.separator + "back-red.png");
		// //card2 = new JLabel(back);
		// card2 = new JLabel(cardDrawn.returnImageIcon());
		// dealerHandPanel.add(card2);

		// this.add(dealerHandPanel);

	}

	public void paint(Graphics g) {
		super.paint(g);

	}

	public void actionPerformed(ActionEvent e) {
		// if (e.getActionCommand().equals("Stay")) {
		// 	//card = new JLabel(cardDrawn.returnImageIcon());
		// 	while (player[1].handValue() < 17) {
		// 		Card cardDrawn = deck.drawCard();
		// 		player[1].addCard(cardDrawn);
		// 		JLabel card = new JLabel(cardDrawn.returnImageIcon());
		// 		dealerHandPanel.add(card);
		// 		validate();
		// 		repaint();
		// 	}
		// } else if (e.getActionCommand().equals("Hit") && player[0].handValue() < 21) {
		// 	Card cardDrawn = deck.drawCard();
		// 	player[0].addCard(cardDrawn);

		// 	JLabel card = new JLabel(cardDrawn.returnImageIcon());
		// 	humanHandPanel.add(card);
		// 	validate();
		// 	repaint();
		// }

	}

}