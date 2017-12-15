package se1_08;

import java.util.function.BiFunction;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSuite {

	ExtensibleCalculator calc;
	BiFunction<Integer, Integer, Integer> addition;
	BiFunction<Integer, Integer, Integer> subtraktion;
	BiFunction<Integer, Integer, Integer> multiplikation;
	BiFunction<Integer, Integer, Integer> division;
	BiFunction<Integer, Integer, Integer> modulo;
	BiFunction<Integer, Integer, Integer> pow;
	
	@Before
	public void setUp() {
		calc = new ExtensibleCalculator();
		addition = (x, y) -> x + y;
		subtraktion = (x, y) -> x - y;
		multiplikation = (x, y) -> x * y;
		division = (x, y) -> x / y;
		modulo = (x, y) -> x % y;
		pow = (x, y) -> (int) Math.pow(x, y);
	}
	
	@Test
	public void test_OperationsCount() {
		assertEquals(0, calc.operations().length);
		calc.addOperation("+", addition);
		assertEquals(1, calc.operations().length);
		calc.addOperation("-", subtraktion);
		assertEquals(2, calc.operations().length);
		calc.addOperation("*", multiplikation);
		assertEquals(3, calc.operations().length);
		calc.addOperation("/", division);
		assertEquals(4, calc.operations().length);
		calc.addOperation("%", modulo);
		assertEquals(5, calc.operations().length);
		calc.addOperation("^", pow);
		assertEquals(6, calc.operations().length);
	}
	
	@Test
	public void test_AdditionOf7And2_9() {
		calc.addOperation("+", addition);
		assertEquals(9, calc.calc("+", 7, 2));
	}
	
	@Test
	public void test_SubtraktionOf10And5_5() {
		calc.addOperation("-", subtraktion);
		assertEquals(5, calc.calc("-", 10, 5));
	}
	
	@Test
	public void test_MultiplikationOf4And3_12() {
		calc.addOperation("*", multiplikation);
		assertEquals(12, calc.calc("*", 4, 3));
	}
	
	@Test
	public void test_DivisionOf20And3_6() {
		calc.addOperation("/", division);
		assertEquals(6, calc.calc("/", 20, 3));
	}
	
	@Test
	public void test_ModuloOf30And8_6() {
		calc.addOperation("%", modulo);
		assertEquals(6, calc.calc("%", 30, 8));
	}
	
	@Test
	public void test_PowOf10And3_1000() {
		calc.addOperation("^", pow);
		assertEquals(1000, calc.calc("^", 10, 3));
	}
}
