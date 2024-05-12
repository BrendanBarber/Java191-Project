package cisc191.app.items;

import java.awt.Image;
import java.text.DateFormat;
import java.time.LocalDate;

import cisc191.app.Deliverable;
import cisc191.app.Perishable;

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
 *         Represents an Apple item in the app
 */

public class Apple extends Item implements Deliverable, Perishable // is an
																	// Item, is
																	// Deliverable,
																	// is
																	// Perishable
{
	// Apple has an arrivalTime
	private LocalDate arrivalTime;
	// Apple has a deliveryCost
	private double deliveryCost;

	// Apple has a perishDate
	private LocalDate perishDate;

	public Apple(Image image, String name, String description, double price,
			int stock)
	{
		super(image, name, description, price, stock);
	}

	@Override
	public void setPerishDate(LocalDate date)
	{
		this.perishDate = date;
	}

	@Override
	public boolean checkPerish(LocalDate date)
	{
		return date.isAfter(perishDate);
	}

	@Override
	public void setDeliveryCost(double cost)
	{
		this.deliveryCost = cost;
	}

	@Override
	public void setArrivalTime(LocalDate date)
	{
		this.arrivalTime = date;
	}

	@Override
	public double getDeliveryCost()
	{
		return deliveryCost;
	}

	@Override
	public LocalDate getArrivalTime()
	{
		return arrivalTime;
	}

}
