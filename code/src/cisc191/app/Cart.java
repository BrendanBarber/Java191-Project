package cisc191.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cisc191.app.exceptions.CartEmptyException;
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

public class Cart
{
	// Cart has many items
	private ArrayList<Item> items;
	// Cart has a total
	private double total;
	// Cart has a panel
	private JPanel cartPanel;
	// Cart has a button
	private JButton cartButton;
	
	// Icons
	private JPanel iconPanel;
	private JButton deliverableButton;
	private JButton pickupableButton;
	private JButton perishableButton;

	public Cart()
	{
		this.items = new ArrayList<>();

		this.cartPanel = new JPanel();
		this.cartButton = new JButton();
		cartButton.setText("Cart");
		cartButton.setPreferredSize(new Dimension(128, 32));

		// Button clicked, run method
		cartButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				onCartButtonClick();
			}
		});

		cartPanel.add(cartButton);
	}

	public void onCartButtonClick()
	{
		// Create a new window
		JFrame newWindow = new JFrame("Cart Details");
		newWindow.setSize(600, 400);
		newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel mainPanel = new JPanel(new BorderLayout());

		// Cart total price
		JLabel infoLabel = new JLabel("Total: $" + 0);
		;

		Map<String, Integer> itemCountMap = new HashMap<>();
		for (Item item : items)
		{
			String itemName = item.getName();
			// Increment occurrence count for item name
			itemCountMap.put(itemName,
					itemCountMap.getOrDefault(itemName, 0) + 1);
		}

		// Have a list of all items with the ability to remove items
		Set<String> uniqueItemNames = new HashSet<>();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Item item : items)
		{
			String itemName = item.getName();
			int itemCount = itemCountMap.get(itemName);
			// if the item name is not in the set, add it to the list model
			if (!uniqueItemNames.contains(itemName))
			{
				uniqueItemNames.add(itemName);
				// if there is more than one item with the same name, append
				// "xN"
				itemName += " x" + itemCount;
				listModel.addElement(itemName);
			}
		}

		JList<String> itemList = new JList<>(listModel);
		itemList.setCellRenderer(new CartItemDisplay());
		// Add ListSelectionListener to handle item removal
		itemList.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					// get the selected list item to remove
					int selectedIndex = itemList.getSelectedIndex();
					if (selectedIndex != -1)
					{
						// get the name of the item
						String itemName = listModel.get(selectedIndex);
						String shortName = itemName.substring(0,
								itemName.lastIndexOf(" x"));

						// recalculation of total once removed
						double newTotal = 0;

						// iterate through until the item to remove is found
						Iterator<Item> iterator = items.iterator();
						while (iterator.hasNext())
						{
							Item item = iterator.next();
							if (item.getName().equals(shortName))
							{
								iterator.remove(); // Safely remove the item
								continue;
							}
							// add to total
							newTotal += item.getPrice();
						}
						// remove list item
						listModel.remove(selectedIndex);
						// update the total globally
						updateTotal();

						// remake total label
						DecimalFormat decimalFormat = new DecimalFormat("#.##");
						String roundedTotal = decimalFormat.format(newTotal);
						infoLabel.setText("Total: $" + roundedTotal);
						
						// update icons
						updateIcons();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(itemList);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		// Format the total and set it
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String roundedTotal = decimalFormat.format(total);
		infoLabel.setText("Total: $" + roundedTotal);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(infoLabel, BorderLayout.NORTH);

		// Panel for the buttons
		JPanel buttonPanel = new JPanel(new FlowLayout());

		// Exit button
		JButton goBackButton = new JButton("Go back");
		goBackButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Close the window when exit is clicked
				newWindow.dispose();
			}
		});
		buttonPanel.add(goBackButton);

		// Create the checkout button
		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					checkOut();
				}
				catch(CartEmptyException e1) 
				{
					// Error message for when cart is empty
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonPanel.add(checkoutButton);
		
		// Icons for interfaces
		iconPanel = new JPanel(new FlowLayout());

		// Create and add disabled buttons to the icon panel
		deliverableButton = new JButton("Deliverable");
		deliverableButton.setEnabled(false);
		iconPanel.add(deliverableButton);

		pickupableButton = new JButton("Pickupable");
		pickupableButton.setEnabled(false);
		iconPanel.add(pickupableButton);

		perishableButton = new JButton("Perishable");
		perishableButton.setEnabled(false);
		iconPanel.add(perishableButton);

		updateIcons();
		
		buttonPanel.add(iconPanel);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		newWindow.add(mainPanel);

		// Make the new window visible
		newWindow.setVisible(true);
	}
	
	private void updateIcons() 
	{
		boolean[] iconVisible = {false, false, false};
		
		for(Item item : getItems()) 
		{
			if(item instanceof Deliverable) 
			{
				iconVisible[0] = true;
			}
			if(item instanceof PickUpable) 
			{
				iconVisible[1] = true;
			}
			if(item instanceof Perishable) 
			{
				iconVisible[2] = true;
			}
		}
		
		// update icons
		if(iconVisible[0] == true) 
		{
			deliverableButton.setBackground(Color.GREEN);
		}
		else
		{
			deliverableButton.setBackground(Color.GRAY);
		}
		
		if(iconVisible[1] == true) 
		{
			pickupableButton.setBackground(Color.GREEN);
		}
		else 
		{
			pickupableButton.setBackground(Color.GRAY);
		}
		
		if(iconVisible[2] == true)
		{
			perishableButton.setBackground(Color.GREEN);
		}
		else 
		{
			perishableButton.setBackground(Color.GRAY);
		}
	}
	
	private void checkOut() throws CartEmptyException 
	{
		if(getItems().size() > 0)
		{
			System.exit(0);
		}
		else
		{
			throw new CartEmptyException();
		}
	}

	public ArrayList<Item> getItems()
	{
		return items;
	}

	public JPanel getPanel()
	{
		return cartPanel;
	}

	private void updateTotal()
	{
		total = 0;
		for (Item item : items)
		{
			total += item.getPrice();
		}
	}

	public void addItem(Item item)
	{
		items.add(item);

		updateTotal();
	}

	public void removeItem(Item item)
	{
		if (item == null) return;
		items.remove(item);
	}

	public double getTotal()
	{
		return total;
	}

}
