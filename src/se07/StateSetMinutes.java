package se07;

public class StateSetMinutes extends State{

	public StateSetMinutes(DigitalClock clock) {
		super(clock);
	}
	
	public void inc() {
		super.clock.minutes += 1;
		if(super.clock.minutes >= 60) super.clock.hours += 1;
		if(super.clock.hours >= 24) super.clock.hours %= 24;
		super.clock.minutes %= 60;
	}
}
