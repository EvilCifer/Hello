package se07;

public class StateSetSeconds extends State {

	public StateSetSeconds(DigitalClock clock) {
		super(clock);
	}
	
	public void inc() {
		super.clock.seconds += 1;
		if(super.clock.seconds >= 60) super.clock.minutes += 1;
		if(super.clock.minutes >= 60) super.clock.hours += 1;
		if(super.clock.minutes >= 60) super.clock.minutes %= 60;
		if(super.clock.hours >= 24) super.clock.hours %= 24;
		super.clock.seconds %= 60;
	}
}
