package se_10.mvc.model;

import java.time.LocalDateTime;

public interface CarModel {

	public double getActualPrice();
	
	public void setActualPrice(double newPrice);
	
	public LocalDateTime getApproachTime();
	
	public void setDepartureTime(LocalDateTime departureTime);
	
	public LocalDateTime getDepartureTime();
	
	public void setPosition(int i);
	
	public int getPosition();
	
	public void setDepartured(boolean b);
	
	public boolean getDepartured();
	
}