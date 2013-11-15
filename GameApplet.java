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

	private JPanel humanHandPanel = new JPanel();
	private JPanel dealerHandPanel = new JPanel();

	private Player[] player = new Player[2];

	public void init() {

		deck = new Deck();
		player[0] = new Human(200.0);
		player[1] = new Dealer();

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
		humanHandPanel.setLayout(new FlowLayout());
		Card cardDrawn = deck.drawCard();
		player[0].addCard(cardDrawn);
		JLabel card1 = new JLabel(cardDrawn.returnImageIcon());
		humanHandPanel.add(card1);

		cardDrawn = deck.drawCard();
		player[0].addCard(cardDrawn);
		JLabel card2 = new JLabel(cardDrawn.returnImageIcon());
		humanHandPanel.add(card2);

		this.add(humanHandPanel);

		//Dealer cards/panel
		dealerHandPanel.setLayout(new FlowLayout());
		cardDrawn = deck.drawCard();
		player[1].addCard(cardDrawn);
		card1 = new JLabel(cardDrawn.returnImageIcon());
		dealerHandPanel.add(card1);

		cardDrawn = deck.drawCard();
		player[1].addCard(cardDrawn);
		ImageIcon back  = new ImageIcon("images" + File.separator + "back-red.png");
		card2 = new JLabel(back);
		dealerHandPanel.add(card2);

		this.add(dealerHandPanel);

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
		if (e.getActionCommand().equals("Stay")) {
			System.out.println("Stay");
			repaint();
		} else if (e.getActionCommand().equals("Hit")) {
			Card cardDrawn = deck.drawCard();

			JLabel card = new JLabel(cardDrawn.returnImageIcon());
			humanHandPanel.add(card);
			validate();
			repaint();
		}

	}

}