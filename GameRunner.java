import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

import java.io.File;

import javax.imageio.ImageIO;

public class GameRunner extends Applet implements ActionListener {

	private Deck deck;
	private Human human;
	private Dealer dealer;

	private JPanel newGamePanel = new JPanel();
	private JButton newGameButton = new JButton("New Game");

	private JPanel betPanel = new JPanel();
	private JLabel balanceLabel = new JLabel("");
	private JLabel betAmountLabel = new JLabel("");
	private JButton doubleDownButton = new JButton("Double Down");
	private JButton betButton5 = new JButton("$5");
	private JButton betButton10 = new JButton("$10");
	private JButton betButton50 = new JButton("$50");
	private JButton betButton100 = new JButton("$100");

	private JPanel playerInteractionPanel = new JPanel();
	private JButton playButton = new JButton("Play");
	private JButton stayButton = new JButton("Stay");
	private JButton hitButton = new JButton("Hit");
	private JButton newRoundButton = new JButton("New Round");

	private JPanel outcomePanel = new JPanel();
	private JLabel outcomeLabel = new JLabel("");

	private JPanel blankPanel1 = new JPanel();
	private JPanel blankPanel2 = new JPanel();

	public void init() {
		//creates all actionListener and actionCommands for all possible buttons
		this.setLayout(new GridLayout(0, 1));

		//new game panel
		newGamePanel.setLayout(new FlowLayout());
		newGameButton.addActionListener(this);
		newGameButton.setActionCommand("New Game");
		newGamePanel.add(newGameButton);
		this.add(newGamePanel);

		//bet panel
		betPanel.setLayout(new FlowLayout());
		betButton5.addActionListener(this);
		betButton5.setActionCommand("$5");
		betButton10.addActionListener(this);
		betButton10.setActionCommand("$10");
		betButton50.addActionListener(this);
		betButton50.setActionCommand("$50");
		betButton100.addActionListener(this);
		betButton100.setActionCommand("$100");
		doubleDownButton.addActionListener(this);
		doubleDownButton.setActionCommand("Double Down");

		//player interaction panel
		playerInteractionPanel.setLayout(new FlowLayout());
		playButton.addActionListener(this);
		playButton.setActionCommand("Play");
		stayButton.addActionListener(this);
		stayButton.setActionCommand("Stay");
		hitButton.addActionListener(this);
		hitButton.setActionCommand("Hit");
		newRoundButton.addActionListener(this);
		newRoundButton.setActionCommand("New Round");
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	public void actionPerformed(ActionEvent e) {
		if ("New Game".equals(e.getActionCommand())) {
			removeAllPanels();

			deck = new Deck();
			Card cardDrawn1 = new Card();
			Card cardDrawn2 = new Card();
			human = new Human(200.0, cardDrawn1, cardDrawn2);
			dealer = new Dealer(cardDrawn1, cardDrawn2);

			//adds the betting panel
			balanceLabel = new JLabel("Balance: $"+human.getBalance());
			betAmountLabel = new JLabel("Betting: $" +human.getBetTotal());
			betPanel.add(balanceLabel);
			betPanel.add(betButton5);
			betPanel.add(betButton10);
			betPanel.add(betButton50);
			betPanel.add(betButton100);
			betPanel.add(betAmountLabel);
			this.add(betPanel);

			//adds the play button
			playerInteractionPanel.add(playButton);
			this.add(playerInteractionPanel);

			//adds all panels below in order to keep the layout the same, even though these panels are blank
			this.add(blankPanel1);
			this.add(blankPanel2);
			this.add(outcomePanel);
			validate();
			repaint();

		// When the betting panel is up and any of the buttons are clicked that value is added to the current bet amount
		} else if ("$5".equals(e.getActionCommand()) || "$10".equals(e.getActionCommand()) || "$50".equals(e.getActionCommand()) || "$100".equals(e.getActionCommand())) {
			String[] betOptions = {"$5", "$10", "$50", "$100"};
			Double[] betOptionsValue = {5.0, 10.0, 50.0, 100.0};
			for (int i=0; i<4; i++) {
				if (betOptions[i].equals(e.getActionCommand())) {
					human.bet(betOptionsValue[i]);
				}
			}

			//removes the old labels displaying the balance and bet amount and adds the new ones based of the bet amount
			betPanel.remove(balanceLabel);
			betPanel.remove(betAmountLabel);
			balanceLabel = new JLabel("Balance: $"+human.getBalance());
			betAmountLabel = new JLabel("Betting: $"+human.getBetTotal());
			betPanel.add(balanceLabel);
			betPanel.add(betButton5);
			betPanel.add(betButton10);
			betPanel.add(betButton50);
			betPanel.add(betButton100);
			betPanel.add(betAmountLabel);
			this.add(betPanel);

			//readds all the panels below the betting panel in order to keep the layout the same
			this.add(playerInteractionPanel);
			this.add(blankPanel1);
			this.add(blankPanel2);
			this.add(outcomePanel);
			validate();
			repaint();

		} else if ("Play".equals(e.getActionCommand())) {
			//removes teh betting buttons and adds in the double down button
			betPanel.remove(betButton5);
			betPanel.remove(betButton10);
			betPanel.remove(betButton50);
			betPanel.remove(betButton100);
			betPanel.remove(betAmountLabel);
			betPanel.add(doubleDownButton);
			betPanel.add(betAmountLabel);

			//removes the play button and adds the stay and hit buttons
			playerInteractionPanel.remove(playButton);
			playerInteractionPanel.add(stayButton);
			playerInteractionPanel.add(hitButton);

			this.remove(blankPanel1);
			this.remove(blankPanel2);

			//creates a new deck if there are left than 18 cards left to draw in current deck
			if (deck.getPositionInDeck() < 18) {
				deck = new Deck();
			}

			//draws 2 cards for human and dealer and creates the panels for them
			Card cardDrawn1 = deck.drawCard();
			Card cardDrawn2 = deck.drawCard();
			human.newHand(cardDrawn1, cardDrawn2);

			cardDrawn1 = deck.drawCard();
			cardDrawn2 = deck.drawCard();
			dealer.newHand(cardDrawn1, cardDrawn2);

			this.add(betPanel);
			this.add(playerInteractionPanel);
			this.add(human.getPanel());
			this.add(dealer.getPanel());
			this.add(outcomePanel);
			validate();
			repaint();

		//doubles the players current bet and draws one more card
		} else if ("Double Down".equals(e.getActionCommand()) && human.handValue() < 21) {
			human.bet(human.getBetTotal());

			betPanel.remove(balanceLabel);
			betPanel.remove(betAmountLabel);
			betPanel.remove(doubleDownButton);
			balanceLabel = new JLabel("Balance: $"+human.getBalance());
			betAmountLabel = new JLabel("Betting: $"+human.getBetTotal());
			betPanel.add(balanceLabel);
			betPanel.add(betAmountLabel);

			playerInteractionPanel.remove(hitButton);

			Card cardDrawn = deck.drawCard();
			human.addCard(cardDrawn);
			
			this.add(betPanel);
			this.add(playerInteractionPanel);
			this.add(human.getPanel());
			this.add(dealer.getPanel());
			this.add(outcomePanel);
			validate();
			repaint();

		} else if ("Stay".equals(e.getActionCommand())) {
			betPanel.remove(doubleDownButton);
			playerInteractionPanel.remove(stayButton);
			playerInteractionPanel.remove(hitButton);
			playerInteractionPanel.add(newRoundButton);

			dealer.flipCard();
			//draws cards for the dealer until their hand value is 17 or above
			while (dealer.handValue() < 17) {
				Card cardDrawn = deck.drawCard();
				dealer.addCard(cardDrawn);
			}
			//decides who won and calls the betReturn method of human in order to give them the correct amount for winning, losing, or drawing
			if ((dealer.handValue() < human.handValue() && human.handValue() <= 21) || (dealer.handValue() > 21 && human.handValue() <= 21)) {
				outcomeLabel = new JLabel("Player Won");
				human.betReturn(1);
			} else if ((dealer.handValue() == human.handValue()) || (dealer.handValue() > 21 && human.handValue() > 21)) {
				outcomeLabel = new JLabel("Draw");
				human.betReturn(2);
			} else {
				outcomeLabel = new JLabel("Dealer Won");
				human.betReturn(0);
			}

			this.add(dealer.getPanel());
			outcomeLabel.setFont(new Font("sansserif", Font.BOLD, 16));
			outcomePanel.add(outcomeLabel);
			this.add(outcomePanel);
			validate();
			repaint();
		
		//draws one card for the human and adds it to the panel
		} else if ("Hit".equals(e.getActionCommand()) && human.handValue() < 21) {
			Card cardDrawn = deck.drawCard();
			human.addCard(cardDrawn);
			this.add(human.getPanel());
			this.add(dealer.getPanel());
			this.add(outcomePanel);
			validate();
			repaint();

		//creates the same layout as "New Game", but just does not reset the human or dealer
		} else if ("New Round".equals(e.getActionCommand())) {
			betPanel.remove(balanceLabel);
			betPanel.remove(betAmountLabel);
			balanceLabel = new JLabel("Balance: $"+human.getBalance());
			betAmountLabel = new JLabel("Betting: $"+human.getBetTotal());
			betPanel.add(balanceLabel);
			betPanel.add(betButton5);
			betPanel.add(betButton10);
			betPanel.add(betButton50);
			betPanel.add(betButton100);
			betPanel.add(betAmountLabel);

			playerInteractionPanel.remove(newRoundButton);
			playerInteractionPanel.add(playButton);

			this.remove(dealer.getPanel());
			this.remove(human.getPanel());

			outcomePanel.remove(outcomeLabel);

			this.add(blankPanel1);
			this.add(blankPanel2);
			this.add(outcomePanel);
			validate();
			repaint();
		}
	}

	//removes all Labels, Buttons, and Panels in order for the applet to be cleared completely when a new game is called
	public void removeAllPanels() {
		betPanel.remove(balanceLabel);
		betPanel.remove(betAmountLabel);
		betPanel.remove(doubleDownButton);
		betPanel.remove(betButton5);
		betPanel.remove(betButton10);
		betPanel.remove(betButton50);
		betPanel.remove(betButton100);
		this.remove(betPanel);

		playerInteractionPanel.remove(playButton);
		playerInteractionPanel.remove(stayButton);
		playerInteractionPanel.remove(hitButton);
		playerInteractionPanel.remove(newRoundButton);
		this.remove(playerInteractionPanel);

		outcomePanel.remove(outcomeLabel);
		this.remove(outcomePanel);

		this.remove(blankPanel1);
		this.remove(blankPanel2);

	}

}