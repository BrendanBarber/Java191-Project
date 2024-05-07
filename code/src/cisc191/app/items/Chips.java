package cisc191.app.items;

import java.awt.Image;
import java.time.LocalDate;

import cisc191.app.Deliverable;
import cisc191.app.PickUpable;

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
 *         Represents a Chips item in the app
 */

public class Chips extends Item implements Deliverable, PickUpable // is an Item, is Deliverable, is PickUpable
{	
	// Chips has a readyTime
	private LocalDate readyTime;
	// Chips has a deliveryCost
	private double deliveryCost;
	// Chips has an arrivalTime
	private LocalDate arrivalTime;
	
	public Chips(Image image, String name, String description, double price,
			int stock)
	{
		super(image, name, description, price, stock);
	}

	@Override
	public void setReadyTime(LocalDate date)
	{
		this.readyTime = date;
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
	public LocalDate getReadyTime()
	{
		return readyTime;
	}

	@Override
	public LocalDate getArrivalTime()
	{
		return arrivalTime;
	}

}
