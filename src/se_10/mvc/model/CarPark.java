package se_10.mvc.model;

public class CarPark implements CarParkModel {

	private double pricePerHour;
	private Cars[] parkingSpots;
	
	public CarPark() {
		parkingSpots = new Cars[10];
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
		return parkingSpots.length;
	}
}
