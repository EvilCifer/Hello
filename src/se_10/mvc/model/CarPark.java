package se_10.mvc.model;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CarPark implements CarParkModel {

	private static CarPark instance = null;
	private static double pricePerHour;
	private static Cars[] parkingSpots;
	private static HashMap<String, Cars> map = new HashMap<String, Cars>();
	private int size = 0;
	
	public CarPark() {
		parkingSpots = new Cars[10];
	}
	
	public static CarPark getInstance() {
		if(instance == null) {
			instance = new CarPark();
		}
		return instance;
	}
	
	@Override
	public double getPricePerHour() {
		return pricePerHour;
	}

	@Override
	public void setPricePerHour(double newPrice) {
		pricePerHour = newPrice;
	}
	
	@Override
	public void setParkingSpots(int amount) {
		parkingSpots = new Cars[amount];
	}
	
	@Override
	public void setParkingInParkingSpot(int i, Cars car) {
		if(car == null) --size;
		if(car != null) {
			car.setPosition(i+1);
			map.put(car.getApproachTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")), car);
			 ++size;
		}
		parkingSpots[i] = car;
	}
	
	public void dump() {
		map.forEach((k,v) -> System.out.println(v));
	}
	
	@Override
	public Cars getParkingSpot(int i) {
		return parkingSpots[i];
	}
	
	@Override
	public Cars getParkingSpot(String date) {
		return map.get(date);
	}
	
	@Override
	public Cars getFirstParkingSpot() {
		return parkingSpots[0];
	}
	
	@Override
	public Cars getLastParkingSpot() {
		return parkingSpots[parkingSpots.length-1];
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public int total() {
		return parkingSpots.length;
	}
}
