package se07;

public class DigitalClock {
	
	int seconds, minutes, hours;
	State state;
	
	public DigitalClock() {
		state = new StateRunning(this);
		state.setNext(new StateSetHours(this));
		state.next.setNext(new StateSetMinutes(this));
		state.next.next.setNext(new StateSetSeconds(this));
		state.next.next.next.setNext(state);
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getHours() {
		return hours;
	}
	
	@Override
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}
	
	public State getState() {
		return state;
	}
	
	public void set() {
		this.state = this.state.next;
	}
	
	public void inc() {
		this.state.inc();
	}
}
