import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

import java.io.File;

import javax.imageio.ImageIO;

public class GameApplet extends Applet implements ActionListener {

	private Deck deck;

	private JPanel playerInteractionPanel = new JPanel();
	private JButton stayButton = new JButton("Stay");
	private JButton hitButton = new JButton("Hit");
	private JButton newGameButton = new JButton("New Game");
	private JButton newHandButton = new JButton("New Hand");

	private JPanel betPanel = new JPanel();
	private JLabel balanceLabel = new JLabel("");
	private JLabel betLabel = new JLabel("");
	private JButton betButton5 = new JButton("$5");
	private JButton betButton10 = new JButton("$10");
	private JButton betButton50 = new JButton("$50");
	private JButton betButton100 = new JButton("$100"); 

	private Player[] player = new Player[2];

	public void init() {

		this.setLayout(new GridLayout(0, 1));

		//button set up
		playerInteractionPanel.setLayout(new FlowLayout());
		stayButton.addActionListener(this);
		stayButton.setActionCommand("Stay");
		playerInteractionPanel.add(stayButton);

		hitButton.addActionListener(this);
		hitButton.setActionCommand("Hit");
		playerInteractionPanel.add(hitButton);

		newGameButton.addActionListener(this);
		newGameButton.setActionCommand("New Game");
		playerInteractionPanel.add(newGameButton);

		newHandButton.addActionListener(this);
		newHandButton.setActionCommand("New Hand");
		playerInteractionPanel.add(newHandButton);

		this.add(playerInteractionPanel);

		Card cardDrawn1 = new Card();
		Card cardDrawn2 = new Card();
		player[0] = new Human(200.0, cardDrawn1, cardDrawn2);
		player[1] = new Dealer(cardDrawn1, cardDrawn2);
		
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	public void actionPerformed(ActionEvent e) {
		if ("Stay".equals(e.getActionCommand())) {
			//this.remove(player[1].getPanel());
			player[1].flipCard();
			this.add(player[1].getPanel());
			this.add(betPanel);
			validate();
			repaint();

			while (player[1].handValue() < 17) {
				Card cardDrawn = deck.drawCard();
				player[1].addCard(cardDrawn);
				this.add(player[1].getPanel());
				this.add(betPanel);
				validate();
				repaint();
			}

		} else if ("Hit".equals(e.getActionCommand()) && player[0].handValue() < 21) {
			Card cardDrawn = deck.drawCard();
			player[0].addCard(cardDrawn);
			this.add(player[0].getPanel());
			this.add(player[1].getPanel());
			this.add(betPanel);
			validate();
			repaint();

		} else if ("New Hand".equals(e.getActionCommand())) {
			
		

		} else if ("New Game".equals(e.getActionCommand())) {

			deck = new Deck();

			this.remove(player[0].getPanel());
			this.remove(player[1].getPanel());
			this.remove(betPanel);
			betPanel.remove(balanceLabel);
			//betPanel.remove(balanceLabel);

			//Human cards/panel
			Card cardDrawn1 = deck.drawCard();
			Card cardDrawn2 = deck.drawCard();
			player[0] = new Human(200.0, cardDrawn1, cardDrawn2);
			this.add(player[0].getPanel());
		
			//Dealer cards/panel
			cardDrawn1 = deck.drawCard();
			cardDrawn2 = deck.drawCard();
			player[1] = new Dealer(cardDrawn1, cardDrawn2);
			this.add(player[1].getPanel());

			//betting panels
			balanceLabel = new JLabel("Current Balance: $200");
			betPanel.add(balanceLabel);
			betButton5.addActionListener(this);
			betButton5.setActionCommand("$5");
			betPanel.add(betButton5);
			betButton10.addActionListener(this);
			betButton10.setActionCommand("$10");
			betPanel.add(betButton10);
			betButton50.addActionListener(this);
			betButton50.setActionCommand("$50");
			betPanel.add(betButton50);
			betButton100.addActionListener(this);
			betButton100.setActionCommand("$100");
			betPanel.add(betButton100);
			this.add(betPanel);

			validate();
			repaint();

		} else if ("$5".equals(e.getActionCommand())) {
			player[0].bet(5.0);
		}

	}

}