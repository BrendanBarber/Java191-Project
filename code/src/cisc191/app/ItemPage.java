package cisc191.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cisc191.app.items.Apple;
import cisc191.app.items.Chips;
import cisc191.app.items.Item;

public class ItemPage
{
	
	private JScrollPane scrollPane;
	private JPanel panel;
	
	private HashMap<String, Item> items;
	
	public ItemPage() {
		this.panel = new JPanel(new GridLayout(0, 3));
		
		this.items = new HashMap<String, Item>();
		
		// temporary items, will eventually be a external file ---------------------------------
		addItem(new Apple(null, "Granny Smith Apple 0", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Granny Smith Apple 1", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Granny Smith Apple 2", "A tasty green apple.", 3.99, 16));
		
		addItem(new Apple(null, "Granny Smith Apple 3", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Granny Smith Apple 4", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Granny Smith Apple 5", "A tasty green apple.", 3.99, 16));
		
		addItem(new Chips(null, "Chips 0", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Chips 1", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Chips 2", "These are chips.", 4.99, 12));
		
		addItem(new Chips(null, "Chips 3", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Chips 4", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Chips 5", "These are chips.", 4.99, 12));
		// --------------------------------------------------------------------------------------
		
		createPage();
		
		this.scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setPreferredSize(new Dimension(300, 800));
	}
	
	public void addItem(Item item) {
		items.put(item.getName(), item);
	}
	
	public void createPage() {
		for(Item item : items.values()) {
			 JPanel boxPanel = new JPanel();
	         boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	         boxPanel.setBackground(Color.LIGHT_GRAY);
	         
	         JLabel label = new JLabel(item.getName(), JLabel.CENTER);
	         boxPanel.add(label);
	         
	         panel.add(boxPanel);
		}
	}
	
	public JScrollPane getPanel() {
		return scrollPane;
	}
	
}
