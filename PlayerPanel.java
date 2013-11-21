import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PlayerPanel extends JPanel {


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

	public void addCard(Card cardDrawn) {
		JLabel card = new JLabel(cardDrawn.returnImageIcon());
		this.add(card);
	}

}