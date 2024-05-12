package cisc191.app.exceptions;

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
 *         Contains methods used by PickUpable items
 */

public class OutOfStockException extends Exception // is an Exception
{
	public OutOfStockException(Item item)
	{
		super("Item '" + item.getName() + "' is out of stock");
	}
}
