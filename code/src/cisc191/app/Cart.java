package cisc191.app;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import cisc191.app.items.Item;

public class Cart
{
	
	private ArrayList<Item> items;
	
	private double total;
	
	private JPanel cartPanel;
	private JButton cartButton;
	
	public Cart() {
		this.items = new ArrayList<>();
		
		this.cartPanel = new JPanel();
		this.cartButton = new JButton();
		cartButton.setText("Cart");
		cartButton.setPreferredSize(new Dimension(128, 32));
		cartPanel.add(cartButton);
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
