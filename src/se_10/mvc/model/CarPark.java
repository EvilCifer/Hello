package se_10.mvc.model;

public class CarPark implements CarParkModel {

	private static CarPark instance = null;
	private double pricePerHour;
	private static Cars[] parkingSpots;
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
		if(car != null) ++size;
		parkingSpots[i] = car;
	}
	
	@Override
	public Cars getParkingSpot(int i) {
		return parkingSpots[i];
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
