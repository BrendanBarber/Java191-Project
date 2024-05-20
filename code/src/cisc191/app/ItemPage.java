package cisc191.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cisc191.app.items.Apple;
import cisc191.app.items.Chips;
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

public class ItemPage
{
	// ItemPage has a cart
	private Cart cart;
	// ItemPage has a scrollPane
	private JScrollPane scrollPane;
	// ItemPage has a panel
	private JPanel panel;
	// ItemPage has many items that are visible or not
	private HashMap<Item, Boolean> items;
	// ItemPage has the topSix query responses
	private JPanel[][] topSixItemBoxes = new JPanel[2][3];
	// ItemPage has a searchBar
	private SearchBar searchBar;

	public ItemPage(Cart cart) throws IOException
	{
		this.cart = cart;
		this.panel = new JPanel(new GridLayout(0, 3));

		this.items = new HashMap<Item, Boolean>();
		
		loadStock("storeStock.json");

		createPage();

		this.scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setPreferredSize(new Dimension(300, items.size() * 75));
	}

	public void addItem(Item item)
	{
		items.put(item, true);
	}

	public void createPage()
	{
		int count = 0;
		// for each item in keyset
		for (Item item : items.keySet())
		{
			// if item is invisible, continue
			if (items.get(item) == false) continue;
			// Create the ItemBox panel for the item
			JPanel boxPanel = new ItemBox(item, cart);
			boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			boxPanel.setBackground(Color.LIGHT_GRAY);
			boxPanel.setPreferredSize(new Dimension(100, 75));

			// Separates and stores the top 6 search results
			if (count < 6)
			{
				topSixItemBoxes[count / 3][count % 3] = boxPanel;
				count++;
			}

			panel.add(boxPanel);
		}
		
		for (int i = 0; i < topSixItemBoxes.length; i++) {
	        for (int j = 0; j < topSixItemBoxes[i].length; j++) {
	            if (topSixItemBoxes[i][j] != null) {
	                if (i == 0) {
	                    topSixItemBoxes[i][j].setBackground(Color.cyan);
	                } else if (i == 1) {
	                    topSixItemBoxes[i][j].setBackground(Color.yellow);
	                }
	            }
	        }
	    }
	}

	public void attachSearchBar(SearchBar searchBar)
	{
		this.searchBar = searchBar;
	}

	public void updatePage()
	{
		if (searchBar == null) return;

		String match = searchBar.getCurrentSearch();

		int newPanelSize = 0;

		// Check if item name contains the string searched
		for (Item item : items.keySet())
		{
			if (item.getName().contains(match))
			{
				items.put(item, true);
				newPanelSize++;
			}
			else
			{
				items.put(item, false);
			}
		}

		// Clear and recreate page with only matched items
		panel.removeAll();
		createPage();

		// Resize panel so that boxes aren't stretched
		panel.setPreferredSize(new Dimension(300, newPanelSize * 75));
		panel.revalidate();
		panel.repaint();
	}
	
	public void loadStock(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Extract Apples, iterate through each in the json, extract the needed information, and then create an object
            JsonArray applesArray = jsonObject.getAsJsonArray("Apples");
            for (JsonElement appleElement : applesArray) {
                JsonObject apple = appleElement.getAsJsonObject();
                for (Map.Entry<String, JsonElement> key : apple.entrySet()) {
                    JsonObject details = key.getValue().getAsJsonObject();
                    addItem(new Apple(ImageIO.read(new File(details.get("image_file").getAsString())),
                            key.getKey(), details.get("description").getAsString(),
                            details.get("price").getAsDouble(), details.get("stock").getAsInt()));
                }
            }

            // Extract Chips, iterate through each in the json, extract the needed information, and then create an object
            JsonArray chipsArray = jsonObject.getAsJsonArray("Chips");
            for (JsonElement chipsElement : chipsArray) {
                JsonObject chips = chipsElement.getAsJsonObject();
                for (Map.Entry<String, JsonElement> key : chips.entrySet()) {
                    JsonObject details = key.getValue().getAsJsonObject();
                    addItem(new Chips(ImageIO.read(new File(details.get("image_file").getAsString())),
                    		key.getKey(), details.get("description").getAsString(),
                            details.get("price").getAsDouble(), details.get("stock").getAsInt()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public JScrollPane getPanel()
	{
		return scrollPane;
	}

}
