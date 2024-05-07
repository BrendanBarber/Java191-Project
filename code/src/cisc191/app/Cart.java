package cisc191.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
	
	public Cart() {
		this.items = new ArrayList<>();
		
		this.cartPanel = new JPanel();
		this.cartButton = new JButton();
		cartButton.setText("Cart");
		cartButton.setPreferredSize(new Dimension(128, 32));
		
		// Button clicked, run method
		cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCartButtonClick();
            }
        });
		
		cartPanel.add(cartButton);
	}
	
	public void onCartButtonClick() {
        // Create a new window
        JFrame newWindow = new JFrame("Cart Details");
        newWindow.setSize(300, 200);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Create a text label with some temporary simple cart information
        JLabel infoLabel = new JLabel("Your cart has " + items.size() + " items. Total: $" + total);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(infoLabel, BorderLayout.CENTER);
        
        // TODO Have a list of all items with the ability to remove items
        
        // Panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Exit button
        JButton goBackButton = new JButton("Go back");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the window when exit is clicked
                newWindow.dispose();
            }
        });
        buttonPanel.add(goBackButton);
        
        // Create the checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        buttonPanel.add(checkoutButton);
        
        
        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
        newWindow.add(mainPanel);
        
        // Make the new window visible
        newWindow.setVisible(true);
    }
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public JPanel getPanel() {
		return cartPanel;
	}
	
	private void updateTotal() {
		total = 0;
		for(Item item : items) {
			total += item.getPrice();
		}
	}
	
	public void addItem(Item item) {
		items.add(item);
		
		updateTotal();
	}
	
	public double getTotal() {
		return total;
	}
	
}
