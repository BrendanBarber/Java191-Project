package cisc191.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
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
	
	public ItemPage() throws IOException {
		this.panel = new JPanel(new GridLayout(0, 3));
		
		this.items = new HashMap<Item, Boolean>();
		
		// temporary items, will eventually be a external file ---------------------------------
		addItem(new Apple(ImageIO.read(new File("grannysmith.png")), "Granny Smith Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(ImageIO.read(new File("honeycrisp.png")), "Honeycrisp Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(ImageIO.read(new File("reddelicious.png")), "Red Delicious Apple", "A tasty green apple.", 3.99, 16));
		
		addItem(new Apple(ImageIO.read(new File("fuji.png")), "Fuji Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(ImageIO.read(new File("goldendelicious.png")), "Golden Delicious Apple", "A tasty green apple.", 3.99, 16));
		addItem(new Apple(ImageIO.read(new File("gala.png")), "Gala Apple", "A tasty green apple.", 3.99, 16));
		
		addItem(new Chips(ImageIO.read(new File("takis.png")), "Takis", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("sunchips.png")), "Sun Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(ImageIO.read(new File("lays.png")), "Lays Original Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("cheetos.png")), "Cheetos Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("fritos.png")), "Fritos Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(ImageIO.read(new File("bbq.png")), "Lays BBQ Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("ritz.png")), "Ritz Crackers", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("tostitos.png")), "Tostitos Chips", "These are chips.", 4.99, 12));
		
		addItem(new Chips(ImageIO.read(new File("cheezits.jpg")), "Cheez-its Crackers", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("ruffles.png")), "Ruffles Chips", "These are chips.", 4.99, 12));
		addItem(new Chips(ImageIO.read(new File("doritos.jpg")), "Doritos Chips", "These are chips.", 4.99, 12));
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
			 JPanel boxPanel = new ItemBox(item);
	         boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	         boxPanel.setBackground(Color.LIGHT_GRAY);
	         boxPanel.setPreferredSize(new Dimension(100, 75));
	         
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
