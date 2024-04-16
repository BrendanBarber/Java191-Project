package cisc191.app;

import javax.swing.JLabel;

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
	// AppPage has a welcome label
	private JLabel welcomeLabel;
	
	public AppPage() {
		this.welcomeLabel = new JLabel("Welcome to our online store! Click on an item, or search to continue");
	}
}
