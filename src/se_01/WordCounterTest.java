package se_01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WordCounterTest {
	WordCounter counter = new WordCounter();
	private static final String _PATH = "/home/yozuke/Dokumente/se1_data/wordlists/wordlist.txt";
	@Test
	public void testCount(){
		assertEquals(10, counter.count(_PATH));
		assertEquals(0, counter.count("/home/yozuke/Dokumente/se1_data/wordlists/wordlist0.txt"));
	}
}
