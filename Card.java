import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	
	private int number;
	private String suit;
	private String name;
	private Image image;

	public Card(int number, String suit) {
		setNumber(number);
		setSuit(suit);
		setName();
		this.image = loadImage(name);
	}

	public Card() {
		
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	//changes the number value that represents each card into the correct number of letter in order for the image to be loaded later on
	public void setName() {
		if (number == 1) {
			this.name = "A" + suit + "s";
		} else if (number == 2) {
			this.name = "2" + suit + "s";
		} else if (number == 3) {
			this.name = "3" + suit + "s";
		} else if (number == 4) {
			this.name = "4" + suit + "s";
		} else if (number == 5) {
			this.name = "5" + suit + "s";
		} else if (number == 6) {
			this.name = "6" + suit + "s";
		} else if (number == 7) {
			this.name = "7" + suit + "s";
		} else if (number == 8) {
			this.name = "8" + suit + "s";
		} else if (number == 9) {
			this.name = "9" + suit + "s";
		} else if (number == 10) {
			this.name = "10" + suit + "s";
		} else if (number == 11) {
			this.name = "J" + suit + "s";
		} else if (number == 12) {
			this.name = "Q" + suit + "s";
		} else if (number == 13) {
			this.name = "K" + suit + "s";
		}
	}

	public int getNumber() {
		return number;
	}

	public String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}

	//loads the image for a particular card
	public Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "images" + File.separator + name + ".png";
			//File file = new File(path);
			image = ImageIO.read(new File(path));
		} catch(IOException e) {
			System.out.println("Could not load image at path" + path);
			System.exit(1);
		}

		return image;
	}

	//turns the .png into an ImageIcon in order for it to work with the panels
	public ImageIcon returnImageIcon() {
		return new ImageIcon("images" + File.separator + this.name + ".png");
	}

	public void draw(Graphics g, Rectangle r) {
		g.drawImage(image, r.x, r.y, r.width, r.height, null);
	}
}