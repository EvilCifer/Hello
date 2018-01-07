package se_10.mvc.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import se_10.mvc.model.Cars;

public class CarParkTest {

	Cars car = new Cars();
	
	@Test
	public void test() {
		assertTrue(car.getActualPrice() == 1.00);
		CarParkController controller = new CarParkController();
	}

}
