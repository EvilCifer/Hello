package se07;

public class State {

	DigitalClock clock;
	State next;
	
	public State(DigitalClock clock) {
		this.clock = clock;
	}
	
	public void inc() {
		
	}
	
	public void setNext(State next) {
		this.next = next;
	}
}
