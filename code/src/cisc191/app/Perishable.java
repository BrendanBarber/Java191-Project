package cisc191.app;

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
 *         Contains methods used by Perishable items
 */

public interface Perishable
{
	void setPerishDate(LocalDate date);
	
	boolean checkPerish(LocalDate date);
}
