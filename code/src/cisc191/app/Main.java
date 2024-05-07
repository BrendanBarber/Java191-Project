package cisc191.app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

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
 *         Represents the windows as a whole
 */

public class Main
{
	public static void main(String[] args) {
		Image image = null;
		// try to load the logo image
		try
		{
			image = ImageIO.read(new File("logo.png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// create the cart so that it can be passed into multiple places
		Cart cart = new Cart();
		
		// Try to create the window, errors are usually due to images not loading
		try
		{
			AppPage window = new AppPage(image, new SearchBar(), new ItemPage(cart), cart);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
