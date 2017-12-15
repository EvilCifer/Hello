package se_02;

import java.time.LocalTime;

public class Zeit {
	LocalTime time;

	public Zeit(int hour, int minute) {
		time = LocalTime.of(hour, minute);
	}

	public int stunden() {
		return time.getHour();
	}

	public int minuten() {
		return time.getMinute();
	}

	void add(Zeit other) {
		this.time = time.plusHours(other.stunden());
		this.time = time.plusMinutes(other.minuten());
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", stunden(), minuten());
	}

	@Override
	public boolean equals(Object other) {
		if (other.getClass() != Zeit.class)
			return false;
		return this.time == ((Zeit) other).time;
	}

}