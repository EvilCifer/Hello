package se07;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestSuite_DigitalClock {

	DigitalClock clock;
	
	@Before
	public void setUp() {
		clock = new DigitalClock();
	}
	
	@Test
	public void test_ClockInitialized() {
		assertEquals("0:0:0", clock.toString());
	}
	
	@Test
	public void test_SetStateToStateSetHours_True() {
		clock.set();
		assertTrue(clock.getState() instanceof StateSetHours);
	}
	
	@Test
	public void test_IncrementHours_2() {
		clock.set();
		clock.inc();
		clock.inc();
		assertEquals("2:0:0", clock.toString());
	}
	
	@Test
	public void test_SetStateToStateSetMinutes_True() {
		clock.set();
		clock.set();
		assertTrue(clock.getState() instanceof StateSetMinutes);
	}
	
	@Test
	public void test_IncrementMinutes_23() {
		clock.set();
		clock.set();
		for(int i = 0; i < 23; ++i) {
			clock.inc();
		}
		assertEquals("0:23:0", clock.toString());
	}
	
	@Test
	public void test_SetStateToStateSetSeconds_True() {
		clock.set();
		clock.set();
		clock.set();
		assertTrue(clock.getState() instanceof StateSetSeconds);
	}
	
	@Test
	public void test_IncrementSeconds_45() {
		clock.set();
		clock.set();
		clock.set();
		for(int i = 0; i < 45; ++i) {
			clock.inc();
		}
		assertEquals("0:0:45", clock.toString());
	}
	
	@Test
	public void test_SetStateToStateRunning_True() {
		assertTrue(clock.getState() instanceof StateRunning);
		clock.set();
		clock.set();
		clock.set();
		clock.set();
		assertTrue(clock.getState() instanceof StateRunning);
	}
	
	@Test
	public void test_IncrementOneDayAndFiveMinutes_5() {
		clock.set(); // switch to StateSetHours
		for(int i = 0; i < 23; ++i) { // increment till 11:00:00 pm
			clock.inc();
		}
		clock.set(); // switch to StateSetMinutes
		for(int i = 0; i < 64; ++i) { // increment till 0:04:00 am
			clock.inc();
		}
		clock.set(); // switch to StateSetSeconds
		for(int i = 0; i < 60; ++i) { // increment till 0:05:00 am
			clock.inc();
		}
		clock.set(); // switch to StateRunning
		assertEquals("0:5:0", clock.toString());
	}
	
	@Test
	public void test_IncrementTillMidnight_0() {
		clock.set(); // switch to StateSetHours
		for(int i = 0; i < 23; ++i) { // increment till 11:00:00 pm
			clock.inc();
		}
		clock.set(); // switch to StateSetMinutes
		for(int i = 0; i < 59; ++i) { // increment till 11:59:00 pm
			clock.inc();
		}
		clock.set(); // switch to StateSetSeconds
		for(int i = 0; i < 60; ++i) { // increment till 0:00:00 am
			clock.inc();
		}
		clock.set(); // switch to StateRunning
		assertEquals("0:0:0", clock.toString());
	}
}
