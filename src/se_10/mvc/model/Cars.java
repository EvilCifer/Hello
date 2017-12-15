package se_10.mvc.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Cars implements CarModel {

	LocalTime  approachTime, actualTime;
	double actualPrice;
	
	public Cars() {
		approachTime = LocalTime.now();
	}
	
	@Override
	public double getActualPrice() {
		return actualPrice;
	}
	
	@Override
	public void setActualPrice(double pricePerHour) {
		actualPrice = approachTime.until(LocalTime.now(), ChronoUnit.MINUTES) / 60 * pricePerHour;
	}
}
