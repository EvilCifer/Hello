package se07;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class TestSuite {
	Person person;
	
	@Before
	public void setUp() {
		person = new Person("Frau Dr. Eva Müller, Hochschule Bonn-Rhein-Sieg, Fachbereich Informatik, Grantham-Allee 20, 53757 Sankt Augustin");
	}
	
	@Test
	public void test_GetAnrede_True() {
		assertEquals("Frau", person.getAnrede());
	}
	
	@Test
	public void test_GetTitel_True() {
		assertEquals("Dr.", person.getTitel());
	}
	
	@Test
	public void test_GetVorname_True() {
		assertEquals("Eva", person.getVorname());
	}
	
	@Test
	public void test_GetNachname_True() {
		assertEquals("Müller", person.getNachname());
	}
	
	@Test
	public void test_GetOrganisation_True() {
		assertEquals("Hochschule Bonn-Rhein-Sieg", person.getOrganisation());
	}
	
	@Test
	public void test_GetAbteilung_True() {
		assertEquals("Fachbereich Informatik", person.getAbteilung());
	}
	
	@Test
	public void test_GetStrasse_True() {
		assertEquals("Grantham-Allee", person.getStrasse());
	}
	
	@Test
	public void test_GetHausnummer_True() {
		assertEquals("20", person.getHausnummer());
	}
	
	@Test
	public void test_GetPlz_True() {
		assertEquals("53757", person.getPlz());
	}
	
	@Test
	public void test_GetStadt_True() {
		assertEquals("Sankt Augustin", person.getStadt());
	}
}
