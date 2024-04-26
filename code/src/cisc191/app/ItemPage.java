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
	
	private HashMap<Item, Boolean> items;
	
	private JPanel[][] topSixItemBoxes = new JPanel[3][2];
	
	private SearchBar searchBar;
	
	public ItemPage() {
		this.panel = new JPanel(new GridLayout(0, 3));
		
		this.items = new HashMap<Item, Boolean>();
		
		// temporary items, will eventually be a external file ---------------------------------
		addItem(new Apple(null, "Granny Smith Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Honeycrisp Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Red Delicious Apple", "A tasty green apple.", 3.99, 16));
		
		addItem(new Apple(null, "Fuji Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Golden Delicious Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(null, "Gala Apple", "A tasty green apple.", 3.99, 16));
		
		addItem(new Chips(null, "Takis", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Sun Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(null, "Lays Original Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Cheetos Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Fritos Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(null, "Lays BBQ Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Ritz Crackers", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Tortilla Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(null, "Cheez-its Crackers", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Ruffles Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(null, "Doritos Chips", "These are chips.", 4.99, 12));
		// --------------------------------------------------------------------------------------
		
		createPage();
		
		this.scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setPreferredSize(new Dimension(300, items.size() * 75));
	}
	
	public void addItem(Item item) {
		items.put(item, true);
	}
	
	public void createPage() {
		int count = 0;
		for(Item item : items.keySet()) {
			 if(items.get(item) == false) continue;
			 JPanel boxPanel = new JPanel();
	         boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	         boxPanel.setBackground(Color.LIGHT_GRAY);
	         
	         boxPanel.setPreferredSize(new Dimension(100, 75));
	         
	         JLabel label = new JLabel(item.getName(), JLabel.CENTER);
	         boxPanel.add(label);
	         
	         // Separates and stores the top 6 search results
	         if(count < 6) {
	        	 topSixItemBoxes[count % 3][(int) Math.floor(count / 3)] = boxPanel;
	        	 count++;
	         }
	         
	         panel.add(boxPanel);
		}
	}
	
	public void attachSearchBar(SearchBar searchBar) {
		this.searchBar = searchBar;
	}
	
	public void updatePage() {
		if(searchBar == null) return;
		
		String match = searchBar.getCurrentSearch();
	
		int newPanelSize = 0;
		
		for(Item item : items.keySet()) {
			if(item.getName().contains(match)) {
				items.put(item, true);
				newPanelSize++;
			}
			else {
				items.put(item, false);
			}
		}
		
		panel.removeAll();
		createPage();
		
		panel.setPreferredSize(new Dimension(300, newPanelSize * 75));
		panel.revalidate();
	    panel.repaint();
	}
	
	public JScrollPane getPanel() {
		return scrollPane;
	}
	
}
