import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.io.File;

import javax.imageio.ImageIO;

public class PlayerPanel extends JPanel {

	private JLabel card2;

	//basic card panel where both cards are face up
	public PlayerPanel(Card cardDrawn1, Card cardDrawn2) {
		super();

		JLabel playerTag = new JLabel("Player");
		playerTag.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(playerTag);

		JLabel card1 = new JLabel(cardDrawn1.returnImageIcon());
		this.add(card1);

		JLabel card2 = new JLabel(cardDrawn2.returnImageIcon());
		this.add(card2);
	}

	//card panel for the dealer's inital hand, one card up and one card face down
	public PlayerPanel(Card cardDrawn1) {
		super();

		JLabel dealerTag = new JLabel("Dealer");
		dealerTag.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(dealerTag);

		JLabel card1 = new JLabel(cardDrawn1.returnImageIcon());
		this.add(card1);

		ImageIcon back  = new ImageIcon("images" + File.separator + "back-red.png");
		card2 = new JLabel(back);
		this.add(card2);
	}

	//adds a card to the panel
	public void addCard(Card cardDrawn) {
		JLabel card = new JLabel(cardDrawn.returnImageIcon());
		this.add(card);
	}

	//flips the card of the dealer that was face down
	public void flipCard(Card cardDrawn) {
		this.remove(card2);
		card2 = new JLabel(cardDrawn.returnImageIcon());
		this.add(card2);
	}

}