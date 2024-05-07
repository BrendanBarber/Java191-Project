package cisc191.app.items;

import java.awt.Image;

/**
 * @author Ophir Maor
 * @author Brendan Barber
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: 4/14/2024
 * 
 *         Responsibilities of class:
 *         Represents an item in the app
 */

public class Item
{

	// Item has an image
	private Image image;
	// Item has a name
	private String name;
	// Item has a description
	private String description;
	// Item has a price
	private double price;
	// Item has a stock
	private int stock;

	public Item(Image image, String name, String description, double price,
			int stock)
	{
		this.image = image;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Image getImage()
	{
		return image;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public double getPrice()
	{
		return price;
	}

	public int getStock()
	{
		return stock;
	}

	public void removeFromStock() {
		stock--;
	}
}
