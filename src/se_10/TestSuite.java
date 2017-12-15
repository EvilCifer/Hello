package se_10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

public class TestSuite {

	private FilterInputStream stream, stream2;
	
	@Before
	public void setUp() {
		try {
			stream = new ToUpperCaseInputStream(new FileInputStream(new File("file1.txt")));
			stream2 = new ToUpperCaseInputStream(new FileInputStream(new File("file2.txt")));
		}catch(FileNotFoundException e) {
			e.getStackTrace();
		}
	}
	
	@Test
	public void test_IsToUpperCaseInputStream_True() {
		assertTrue((stream instanceof ToUpperCaseInputStream));
	}
	
	@Test
	public void test_Convertabcdefgh_ABCDEFGH() {
		String expected = "ABCDEFGH\n";
		String result = "";
		try {
			for(int i; (i = stream.read()) != -1;) {
				result += (char) i;
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		assertEquals(expected, result);
	}
	
	@Test
	public void test_ConvertTextFromFile2() {
		String expected = "HELLO I'M A DUMMY TEXT\n" + 
				"AND I AM HERE TO TEST YOUR CODE.\n" + 
				"OH AND HERE ARE SOME NUMBERS WHICH SHOULD BE UNTOUCHED 1234678910\n" + 
				"";
		String result = "";
		try {
			for(int i; (i = stream2.read()) != -1;) {
				result += (char) i;
			}
		}catch (IOException e) {
			e.getStackTrace();
		}
		assertEquals(expected, result);
	}
}
