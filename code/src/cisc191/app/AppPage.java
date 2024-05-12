package cisc191.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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

public class AppPage
{
	// AppPage has a frame
	private JFrame frame;
	// AppPage has a main panel
	private JPanel mainPanel;
	// AppPage has a timer
	private Timer timer;

	public AppPage(Image logo, SearchBar searchBar, ItemPage itemPage,
			Cart cart)
	{
		// Create the JFrame
		frame = new JFrame();

		frame.setTitle("Food App");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		// Top banner containing search bar, logo, and cart button
		JPanel topBanner = new JPanel();
		topBanner.setLayout(new GridLayout());

		ImageDisplay logoPanel = new ImageDisplay(logo);
		topBanner.add(logoPanel);
		topBanner.add(searchBar.getPanel());
		topBanner.add(cart.getPanel());
		mainPanel.add(topBanner, BorderLayout.NORTH);

		mainPanel.add(itemPage.getPanel(), BorderLayout.CENTER);

		itemPage.attachSearchBar(searchBar);

		frame.add(mainPanel);
		frame.setSize(800, 600);
		frame.setVisible(true);

		// Updates page periodically
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				itemPage.updatePage();
			}
		});
		timer.start();
	}
}
