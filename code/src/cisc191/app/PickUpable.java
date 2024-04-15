package cisc191.app;

import java.time.LocalDate;

public interface PickUpable
{
	void setReadyTime(LocalDate date);
	
	LocalDate getReadyTime();
}
