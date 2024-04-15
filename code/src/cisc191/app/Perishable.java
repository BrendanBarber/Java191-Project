package cisc191.app;

import java.time.LocalDate;

public interface Perishable
{
	void setPerishDate(LocalDate date);
	
	boolean checkPerish(LocalDate date);
}
