package cisc191.app.exceptions;

public class CartEmptyException extends Exception
{
	public CartEmptyException() {
		super("The cart is empty");
	}
}
