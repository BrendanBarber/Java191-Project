package cisc191.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cisc191.app.exceptions.OutOfStockException;
import cisc191.app.items.Item;

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
 *         Represents the windows as a whole
 */

public class ItemBox extends JPanel // is a JPanel
{
	// ItemBox has an item
	private Item item;
	// ItemBox has a cart
	private Cart cart;

	public ItemBox(Item item, Cart cart)
	{
		this.item = item;
		this.cart = cart;

		createBox();
	}

	private void createBox()
	{
		// Get necessary components
		Image image = item.getImage();
		String name = item.getName();
		double price = item.getPrice();

		ImageDisplay imageLabel = new ImageDisplay(image);

		// Create name label
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		// Create price label
		JLabel priceLabel = new JLabel(String.format("$%.2f", price));
		priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Create button for adding to cart
		JButton addButton = new JButton("+");
		addButton.setBackground(Color.GREEN);
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					addToCart();
				}
				catch (OutOfStockException e1)
				{
					// Error message for when there is no stock left
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.add(imageLabel);
		this.add(nameLabel);
		this.add(priceLabel);
		this.add(addButton);
	}

	private void addToCart() throws OutOfStockException
	{
		// If there is no stock, throw exception
		if (item.getStock() < 1) throw new OutOfStockException(item);

		// remove item from stock and add to cart
		item.removeFromStock();
		cart.addItem(item);
	}

}
