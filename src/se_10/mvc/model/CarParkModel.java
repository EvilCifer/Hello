package se_10.mvc.model;

public interface CarParkModel {

	public double getPricePerHour();
	
	public void setPricePerHour(double newPrice);
	
	public void setParkingSpots(int amount);
	
	public void setParkingInParkingSpot(int i, Cars car);
	
	public Cars getParkingSpot(int i);
	
	public Cars getFirstParkingSpot();
	
	public Cars getLastParkingSpot();
	
	public int size();
	
	public int total();
}
