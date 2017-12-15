package se_02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.DateTimeException;

import org.junit.Before;
import org.junit.Test;

public class ZeitTest {

	Zeit z01, z02, z03;
	
	@Before
	public void setUp() throws Exception{
		z01 = new Zeit(23, 59);
		z02 = new Zeit(0, 2);
		try{
			z03 = new Zeit(43, 24);
			fail("Expected a DateTimeException to be thrown");
		}catch(DateTimeException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStunden(){
		assertEquals(23, z01.stunden());
		assertEquals(0, z02.stunden());
	}
	
	@Test
	public void testMinuten(){
		assertEquals(59, z01.minuten());
		assertEquals(2, z02.minuten());
	}
	
	@Test
	public void testAdd(){
		z01.add(z02);
		assertEquals(z01, z01);
	}
	
	@Test
	public void testDateTimeException(){
		try{
			z03 = new Zeit(24, 59);
		}catch(DateTimeException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToString(){
		assertEquals("23:59", z01.toString());
	}
}
