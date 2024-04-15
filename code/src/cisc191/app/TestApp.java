package cisc191.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.text.DateFormat;
import java.time.LocalDate;

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
 *         Runs tests for the app
 */

class TestApp
{

	 @Test
	 void testItem() {
	 Item item = new Item(null, "TestItem", "This is a test item.", 5.00, 5);
	
	 assertEquals(item.getImage(), null);
	 assertEquals(item.getName(), "TestItem");
	 assertEquals(item.getDescription(), "This is a test item.");
	 assertEquals(item.getPrice(), 5.00);
	 assertEquals(item.getStock(), 5);
	 }

	// Also tests interfaces: PickUpable and Deliverable
	 @Test
	 void testChips() {
		 Chips chips = new Chips(null, "Chips", "These are chips.", 4.99, 12);
		 chips.setDeliveryCost(0.49);
		 chips.setReadyTime(LocalDate.parse("2024-05-12"));
		 chips.setArrivalTime(LocalDate.parse("2024-05-15"));
		
		 assertEquals(chips.getImage(), null);
		 assertEquals(chips.getName(), "Chips");
		 assertEquals(chips.getDescription(), "These are chips.");
		 assertEquals(chips.getPrice(), 4.99);
		 assertEquals(chips.getStock(), 12);
		
		 assertEquals(chips.getReadyTime(), LocalDate.parse("2024-05-12"));
		 assertEquals(chips.getArrivalTime(), LocalDate.parse("2024-05-15"));
		
		 assertEquals(chips.getDeliveryCost(), 0.49);
	 }

	 // Also tests interfaces: Deliverable and Perishable
	 @Test
	 void testApple() {
		 Apple apple = new Apple(null, "Granny Smith Apple", "A tasty green apple.", 3.99, 16);
		
		 apple.setArrivalTime(LocalDate.parse("2024-05-15"));
		 apple.setPerishDate(LocalDate.parse("2024-05-20"));
		 apple.setDeliveryCost(0.49);
		
		 assertEquals(apple.getImage(), null);
		 assertEquals(apple.getName(), "Granny Smith Apple");
		 assertEquals(apple.getDescription(), "A tasty green apple.");
		 assertEquals(apple.getPrice(), 3.99);
		 assertEquals(apple.getStock(), 16);
		
		 assertEquals(apple.getArrivalTime(), LocalDate.parse("2024-05-15"));
		
		 assertEquals(apple.getDeliveryCost(), 0.49);
		
		 assertEquals(apple.checkPerish(LocalDate.parse("2024-05-15")), false);
		 assertEquals(apple.checkPerish(LocalDate.parse("2024-05-21")), true);
	 }

	// @Test
	// void testCart() {
	// Cart cart = new Cart();
	//
	//
	// assertEquals(cart.getTotal(), 0);
	//
	// Item[] items;
	// assertEquals(cart.getItems(), items);
	//
	// Apple apple = new Apple(null, "Granny Smith Apple", "A tasty green
	// apple.", 3.99, 16, 0.49);
	// Chips chips = new Chips(null, "Chips", "These are chips.", 4.99, 12,
	// 0.49);
	//
	// cart.add(apple);
	//
	// assertEquals(cart.getTotal(), apple.getPrice());
	//
	// cart.add(chips);
	//
	// assertEquals(cart.getTotal(), apple.getPrice() + chips.getPrice());
	//
	// items = new Item[]{apple, chips};
	// Assert.assertArrayEquals(cart.getItems(), items);
	//
	// }

	// @Test
	// void testAppPage() {
	// AppPage appPage = new AppPage();
	// }

	// @Test
	// void testSearchBar() {
	// SearchBar searchBar = new SearchBar();
	// }

}
