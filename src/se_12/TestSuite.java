package se_12;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestSuite {

	Fahrzeug pkw, pickup, suv, zweirad, trike, quad;
	
	@Before
	public void setUp() {
		pkw = PKW.getInstance();
		pickup = Pickup.getInstance();
		suv = SUV.getInstance();
		zweirad = Zweirad.getInstance();
		trike = Trike.getInstance();
		quad = Quad.getInstance();
		
	}
	
	@Test
	public void test_GetInstanceOfPKW() {
		assertTrue(pkw.equals(PKW.getInstance()));
	}
	
	@Test
	public void test_GetInstanceOfPickup() {
		assertTrue(pickup.equals(Pickup.getInstance()));
	}
	
	@Test
	public void test_GetInstanceOfSUV() {
		assertTrue(suv.equals(SUV.getInstance()));
	}
	
	@Test
	public void test_GetInstanceOfZweirad() {
		assertTrue(zweirad.equals(Zweirad.getInstance()));
	}
	
	@Test
	public void test_GetInstanceOfTrike() {
		assertTrue(trike.equals(Trike.getInstance()));
	}
	
	@Test
	public void test_GetInstanceOfQuad() {
		assertTrue(quad.equals(Quad.getInstance()));
	}
	
	@Test
	public void test_PKWUnequalToPickup() {
		assertFalse(pkw.equals(pickup));
	}
	
	@Test
	public void test_SUVUneqaulToZweirad() {
		assertFalse(suv.equals(zweirad));
	}
	
	@Test
	public void test_TrikeUnequalToQuad() {
		assertFalse(trike.equals(quad));
	}
	
	@Test
	public void test_InstanceOfPKW() {
		assertTrue(pkw instanceof PKW);
	}
}
