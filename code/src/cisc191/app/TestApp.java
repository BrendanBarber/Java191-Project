package cisc191.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import cisc191.app.items.Apple;
import cisc191.app.items.Chips;
import cisc191.app.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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

	 @Test
	 void testCart() {
		 Cart cart = new Cart();
		
		
		 assertEquals(cart.getTotal(), 0);
		
		 ArrayList<Item> items = new ArrayList<>();
		 assertEquals(cart.getItems(), items);
		
		 Apple apple = new Apple(null, "Granny Smith Apple", "A tasty green apple.", 3.99, 16);
		 Chips chips = new Chips(null, "Chips", "These are chips.", 4.99, 12);
		
		 cart.addItem(apple);
		
		 assertEquals(cart.getTotal(), apple.getPrice());
		
		 cart.addItem(chips);
		
		 assertEquals(cart.getTotal(), apple.getPrice() + chips.getPrice());
		
		 items.add(apple);
		 items.add(chips);
		 Assert.assertArrayEquals(cart.getItems().toArray(), items.toArray());
	 }
	 
	@Test
	public void testImageLoading() throws IOException
	{
		// Tests that random pictures load
		// Load images
		BufferedImage image1 = ImageIO.read(new File("doritos.jpg"));
		BufferedImage image2 = ImageIO.read(new File("lays.png"));
		BufferedImage image3 = ImageIO.read(new File("fuji.png"));

		// Assert that images are not null
		assertNotNull(image1);
		assertNotNull(image2);
		assertNotNull(image3);
	}

}
	