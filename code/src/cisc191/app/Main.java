package cisc191.app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main
{
	public static void main(String[] args) {
		Image image = null;
		try
		{
			image = ImageIO.read(new File("logo.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			AppPage window = new AppPage(image, new SearchBar(), new ItemPage(), new Cart());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
