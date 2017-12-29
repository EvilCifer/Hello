package se_10.mvc.model;

import java.time.LocalDateTime;

public interface CarModel {

	public double getActualPrice();
	
	public void setActualPrice(double newPrice);
	
	public LocalDateTime getApproachTime();
	
	public void setActualTime(LocalDateTime actual);
	
	public LocalDateTime getActualTime();
}