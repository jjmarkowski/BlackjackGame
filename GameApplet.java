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

	private Human human;
	private Dealer dealer;

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
		human = new Human(200.0, cardDrawn1, cardDrawn2);
		dealer = new Dealer(cardDrawn1, cardDrawn2);
		
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	public void actionPerformed(ActionEvent e) {
		if ("Stay".equals(e.getActionCommand())) {
			//this.remove(player[1].getPanel());
			dealer.flipCard();
			this.add(dealer.getPanel());
			this.add(betPanel);
			validate();
			repaint();

			while (dealer.handValue() < 17) {
				Card cardDrawn = deck.drawCard();
				dealer.addCard(cardDrawn);
				this.add(dealer.getPanel());
				this.add(betPanel);
				validate();
				repaint();
			}

		} else if ("Hit".equals(e.getActionCommand()) && human.handValue() < 21) {
			Card cardDrawn = deck.drawCard();
			human.addCard(cardDrawn);
			this.add(human.getPanel());
			this.add(dealer.getPanel());
			this.add(betPanel);
			validate();
			repaint();

		} else if ("New Hand".equals(e.getActionCommand())) {
			
		

		} else if ("New Game".equals(e.getActionCommand())) {

			deck = new Deck();

			this.remove(human.getPanel());
			this.remove(dealer.getPanel());
			this.remove(betPanel);
			betPanel.remove(balanceLabel);
			betPanel.remove(betLabel);

			//Human cards/panel
			Card cardDrawn1 = deck.drawCard();
			Card cardDrawn2 = deck.drawCard();
			human = new Human(200.0, cardDrawn1, cardDrawn2);
			this.add(human.getPanel());
		
			//Dealer cards/panel
			cardDrawn1 = deck.drawCard();
			cardDrawn2 = deck.drawCard();
			dealer = new Dealer(cardDrawn1, cardDrawn2);
			this.add(dealer.getPanel());

			//betting panels
			balanceLabel = new JLabel("Current Balance: $"+human.getBalance());
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
			human.bet(5.0);

			betPanel.remove(balanceLabel);
			betPanel.remove(betLabel);
			this.remove(betPanel);

			balanceLabel = new JLabel("Current Balance: $"+human.getBalance());
			betPanel.add(balanceLabel);
			betPanel.add(betButton5);
			betPanel.add(betButton10);
			betPanel.add(betButton50);
			betPanel.add(betButton100);
			betLabel = new JLabel("Bet Amount: $"+5.00);
			betPanel.add(betLabel);
			this.add(betPanel);
			validate();
			repaint();
		}

	}

}