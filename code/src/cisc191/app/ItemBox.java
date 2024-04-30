package cisc191.app;

import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cisc191.app.items.Item;

public class ItemBox extends JPanel
{

	private Item item;
	
	public ItemBox(Item item) {
		this.item = item;
		
		createBox();
	}
	
	private void createBox() {
		Image image = item.getImage();
		String name = item.getName();
		double price = item.getPrice();
		
		ImageDisplay imageLabel = new ImageDisplay(image);
		
		JLabel nameLabel = new JLabel(name);
	    nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    
	    JLabel priceLabel = new JLabel(String.format("$%.2f", price));
	    priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    
	    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    
	    this.add(imageLabel);
	    this.add(nameLabel);
	    this.add(priceLabel);
	}
	
}
