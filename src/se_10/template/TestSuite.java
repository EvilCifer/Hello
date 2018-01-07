package se_10.template;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestSuite {

	private double[] daily = {1,2,3,4,5,6,7};
	private double[] weekly = {10,20,30,40};
	private double[] monthly = {100,200,300,400,500,600,700,800,900,1000,1100,1200};
	private WeekTakings week;
	private MonthTakings month;
	private YearTakings year;
	
	@Before
	public void setUp() {
		week = new WeekTakings(daily);
		month = new MonthTakings(weekly);
		year = new YearTakings(monthly);
	}
	
	@Test
	public void testCalculateSum_Weekly() {
		assertTrue(week.calculateSum() == 28);
	}
	
	@Test
	public void testCalculateSum_Monthly() {
		assertTrue(month.calculateSum() == 100);
	}
	
	@Test
	public void testCalculateSum_Year() {
		assertTrue(year.calculateSum() == 7800);
	}
}
