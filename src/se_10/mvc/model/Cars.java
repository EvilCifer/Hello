package se_10.mvc.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Cars implements CarModel {

	private LocalDateTime  approachTime, departureTime;
	private double actualPrice, departurePrice;
	private int pos;
	private boolean departured;
	
	public Cars() {
		approachTime = LocalDateTime.now();
	}
	
	@Override
	public double getActualPrice() {
		if(!departured) {
			return actualPrice;
		}
		return departurePrice;
	}
	
	@Override
	public void setActualPrice(double pricePerHour) {
		if(departured) {
			departurePrice = approachTime.until(departureTime, ChronoUnit.MILLIS) / 1000 * pricePerHour;
		}else {
			actualPrice = approachTime.until(LocalDateTime.now(), ChronoUnit.MILLIS) / 1000 * pricePerHour;
		}
	}

	@Override
	public LocalDateTime getApproachTime() {
		return approachTime;
	}
	
	@Override
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	@Override
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	
	@Override
	public void setPosition(int pos) {
		this.pos = pos;
	}
	
	@Override
	public int getPosition() {
		return pos;
	}

	@Override
	public void setDepartured(boolean departured) {
		this.departured = departured;
	}
	
	@Override
	public boolean getDepartured() {
		return departured;
	}
	
	@Override
	public String toString() {
		return "Approach Time: " + approachTime + "\nActual Price: " + actualPrice;
	}
	
}
