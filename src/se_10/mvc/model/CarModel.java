package se_10.mvc.model;

import java.time.LocalTime;

public interface CarModel {

	public double getActualPrice();
	
	public void setActualPrice(double newPrice);
	
	public LocalTime getApproachTime();
	
	public void setActualTime(LocalTime actual);
	
	public LocalTime getActualTime();
}