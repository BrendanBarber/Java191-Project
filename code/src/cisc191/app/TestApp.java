package cisc191.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.text.DateFormat;

/**
 * @author Ophir Maor
 * @author Brendan Barber
 *
 */

class TestApp
{

//	@Test
//	void testItem() {
//		Item item = new Item(null, "TestItem", "This is a test item.", 5.00, 1, 5);
//		
//		assertEquals(item.getImage(), null);
//		assertEquals(item.getName(), "TestItem");
//		assertEquals(item.getDescription(), "This is a test item.");
//		assertEquals(item.getPrice(), 5.00);
//		assertEquals(item.getAmount(), 1);
//		assertEquals(item.getStock(), 5);
//	}
	
	// Also tests interfaces: PickUpable and Deliverable
//	@Test
//	void testChips() {
//		Chips chips = new Chips(null, "Chips", "These are chips.", 4.99, 1, 12, 0.49);
//		chips.setReadyTime(DateFormat.parse("5/12/2024"));
//		chips.setArrivalTime(DateFormat.parse("5/15/2024"));
//		
//		assertEquals(chips.getImage(), null);
//		assertEquals(chips.getName(), "Chips");
//		assertEquals(chips.getDescription(), "These are chips.");
//		assertEquals(chips.getPrice(), 4.99);
//		assertEquals(chips.getAmount(), 1);
//		assertEquals(chips.getStock(), 12);
//		
//		assertEquals(chips.getReadyTime(), DateFormat.parse("5/12/2024"));
//		assertEquals(chips.getArrivalTime(), DateFormat.parse("5/15/2024"));
//		
//		assertEquals(chips.getDeliveryCost(), 0.49);
//		
//	}
	
	// Also tests interfaces: Deliverable and Perishable
//	@Test
//	void testApple() {
//		Apple apple = new Apple(null, "Granny Smith Apple", "A tasty green apple.", 3.99, 1, 16, 0.49);
//		
//		apple.setArrivalTime(DateFormat.parse("5/15/2024"));
//		apple.setPerishDate(DateFormat.parse("5/20/2024"));
//		
//		assertEquals(apple.getImage(), null);
//		assertEquals(apple.getName(), "Granny Smith Apple");
//		assertEquals(apple.getDescription(), "A tasty green apple.");
//		assertEquals(apple.getPrice(), 3.99);
//		assertEquals(apple.getAmount(), 1);
//		assertEquals(apple.getStock(), 16);
//		
//		assertEquals(apple.getArrivalTime(), DateFormat.parse("5/15/2024"));
//		
//		assertEquals(apple.getDeliveryCost(), 0.49);
//		
//		assertEquals(apple.checkPerish(DateFormat.parse("5/15/2024")), false);
//		assertEquals(apple.checkPerish(DateFormat.parse("5/21/2024")), true);
//	}	
	
//	@Test
//	void testCart() {
//		Cart cart = new Cart();
//		
//		
//		assertEquals(cart.getTotal(), 0);
//		
//		Item[] items;
//		assertEquals(cart.getItems(), items);
//		
//		Apple apple = new Apple(null, "Granny Smith Apple", "A tasty green apple.", 3.99, 1, 16);
//		Chips chips = new Chips(null, "Chips", "These are chips.", 4.99, 1, 12);
//		
//		cart.add(apple);
//		
//		assertEquals(cart.getTotal(), apple.getPrice());
//		
//		cart.add(chips);
//		
//		assertEquals(cart.getTotal(), apple.getPrice() + chips.getPrice());
//		
//		items = new Item[]{apple, chips};
//		Assert.assertArrayEquals(cart.getItems(), items);
//			
//	}
	
//	@Test
//	void testAppPage() {
//		AppPage appPage = new AppPage();
//	}

//	@Test
//	void testSearchBar() {
//		SearchBar searchBar = new SearchBar();
//	}
		
}
