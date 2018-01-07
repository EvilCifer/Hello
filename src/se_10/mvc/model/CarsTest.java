package se_10.mvc.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Test;

public class CarsTest {

	Cars car = new Cars();
	
	
	@Test
	public void testGetActualPrice() {
		
		car.setActualPrice(10);
		assertTrue(car.getActualPrice() == 213);
		//assertEquals(car.getActualPrice(), 213);
	}
	
//	@Override
//	public void setActualPrice(double pricePerHour) {
//		actualPrice = approachTime.until(LocalDateTime.now(), ChronoUnit.MILLIS) / 60 * pricePerHour;
//	}
//
//	@Override
//	public LocalDateTime getApproachTime() {
//		return approachTime;
//	}
//	
//	@Override
//	public void setActualTime(LocalDateTime actual) {
//		actualTime = actual;
//	}
//	
//	@Override
//	public LocalDateTime getActualTime() {
//		return actualTime;
//	}

}
