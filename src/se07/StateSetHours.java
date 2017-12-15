package se07;

public class StateSetHours extends State{

	public StateSetHours(DigitalClock clock) {
		super(clock);
	}
	
	public void inc() {
		super.clock.hours += 1;
		super.clock.hours %= 24;
	}
}
