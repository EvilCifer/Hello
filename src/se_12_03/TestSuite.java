package se_12_03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSuite {

	List<Ticket> list;
	List<Ticket> sorted1, sorted2, sorted3;
	Sortierung s, s2, s3;
	
	@Before
	public void setUp() {
		s = new SortierungNachKunde();
		s2 = new SortierungNachDauer();
		s3 = new SortierungNachPreis();
		
		list = new ArrayList<Ticket>();
		list.add(new Ticket(2, 4, "Bob"));
		list.add(new Ticket(5, 10, "Alice"));
		list.add(new Ticket(3, 6, "Claudia"));
		
		sorted1 = new ArrayList<Ticket>();
		sorted1.add(new Ticket(5, 10, "Alice"));
		sorted1.add(new Ticket(2, 4, "Bob"));
		sorted1.add(new Ticket(3, 6, "Claudia"));
		
		sorted2 = new ArrayList<Ticket>();
		sorted2.add(new Ticket(2, 4, "Bob"));
		sorted2.add(new Ticket(3, 6, "Claudia"));
		sorted2.add(new Ticket(5, 10, "Alice"));
		
		sorted3 = new ArrayList<Ticket>();
		sorted3.add(new Ticket(2, 4, "Bob"));
		sorted3.add(new Ticket(3, 6, "Claudia"));
		sorted3.add(new Ticket(5, 10, "Alice"));
	}
	
	@Test
	public void test_SortierungNachKunde() {
		s.sort(list);
		for(int i = 0; i < list.size(); ++i) {
			assertEquals(sorted1.get(i).getKunde(), list.get(i).getKunde());
		}
	}
	
	@Test
	public void test_SortierungNachDauer() {
		s2.sort(list);
		for(int i = 0; i < list.size(); ++i) {
			assertEquals(sorted2.get(i).getDauer(), list.get(i).getDauer());
		}
	}
	
	@Test
	public void test_SortierungNachPreis() {
		s3.sort(list);
		for(int i = 0; i < list.size(); ++i) {
			assertTrue(sorted3.get(i).getPreis() == list.get(i).getPreis());
		}
	}
}
