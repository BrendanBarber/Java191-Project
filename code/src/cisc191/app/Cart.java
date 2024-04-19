package cisc191.app;

import java.util.ArrayList;

import cisc191.app.items.Item;

public class Cart
{
	
	private ArrayList<Item> items;
	
	private double total;
	
	public Cart() {
		this.items = new ArrayList<>();
	}
	
	public ArrayList<Item> getItems() {
		return items;
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
