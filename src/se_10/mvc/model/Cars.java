package se_10.mvc.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Cars implements CarModel {

	LocalDateTime  approachTime, actualTime;
	double actualPrice;
	
	public Cars() {
		approachTime = LocalDateTime.now();
	}
	
	// implement method getTime()
	
	@Override
	public double getActualPrice() {
		return actualPrice;
	}
	
	@Override
	public void setActualPrice(double pricePerHour) {
		actualPrice = approachTime.until(LocalDateTime.now(), ChronoUnit.MINUTES) / 60 * pricePerHour;
	}

	@Override
	public LocalDateTime getApproachTime() {
		return approachTime;
	}
	
	@Override
	public void setActualTime(LocalDateTime actual) {
		actualTime = actual;
	}
	
	@Override
	public LocalDateTime getActualTime() {
		return actualTime;
	}
}
