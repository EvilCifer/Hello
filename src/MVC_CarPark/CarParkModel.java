package MVC_CarPark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CarParkModel {
	private CarPark carPark = new CarPark();

	public double getActualPrice(int i) {
		this.carPark.cars[i].ticket.to = LocalDateTime.now();
		setActualPrice(i);
		return carPark.cars[i].ticket.actualPrice;
	}

	public void setActualPrice(int i) {
		int difference = (int) ChronoUnit.MINUTES.between(carPark.cars[i].ticket.from, carPark.cars[i].ticket.to);
		carPark.cars[i].ticket.actualPrice = round((double) difference / 60 * carPark.pricePerHour, 2);
	}

	public void setCustomer(int i, LocalDateTime arrivingTime) {
		this.carPark.cars[i] = new Car(new Ticket(arrivingTime));
		setActualPrice(i);
	}

	public double getPricePerHour() {
		return carPark.pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.carPark.pricePerHour = pricePerHour;
	}

	public double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public String getArrivalTime(int i) {
		return this.carPark.cars[i].ticket.from.toString();
	}

	public String getDepartureTime(int i) {
		return this.carPark.cars[i].ticket.to.toString();
	}

	public String getDurationTime(int i) {
		long diffInDays = ChronoUnit.DAYS.between(LocalDateTime.parse(getArrivalTime(i)),
				LocalDateTime.parse(getDepartureTime(i)));
		long diffInHours = ChronoUnit.HOURS.between(LocalDateTime.parse(getArrivalTime(i)),
				LocalDateTime.parse(getDepartureTime(i))) % 24;
		long diffInMinutes = ChronoUnit.MINUTES.between(LocalDateTime.parse(getArrivalTime(i)),
				LocalDateTime.parse(getDepartureTime(i))) % 60;
		long diffInSeconds = ChronoUnit.SECONDS.between(LocalDateTime.parse(getArrivalTime(i)),
				LocalDateTime.parse(getDepartureTime(i))) % 60;

		return String.format("%dd %dh %dm %ds", diffInDays, diffInHours, diffInMinutes, diffInSeconds);
	}
}
