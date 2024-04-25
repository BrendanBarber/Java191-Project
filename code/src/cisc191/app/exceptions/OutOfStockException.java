package cisc191.app.exceptions;

import cisc191.app.items.Item;

public class OutOfStockException extends Exception
{
	public OutOfStockException(Item item) {
		super("Item '" + item.getName() + "' is out of stock");
	}
}
