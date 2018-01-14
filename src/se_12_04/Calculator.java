package se_12_04;

import java.util.Stack;

public class Calculator {
	
	Stack<Double> undo;
	Stack<Double> redo;
	
	Command add = new AddCommand();
	Command sub = new SubCommand();
	Command mul = new MulCommand();
	Command div = new DivCommand();

	public double add(double a, double b) {
		undo.push(sub.execute(add.execute(a, b), b));
		return add.execute(a, b);
	}
	
	public double sub(double a, double b) {
		undo.push(add.execute(sub.execute(a, b), b));
		return sub.execute(a, b);
	}
	
	public double mul(double a, double b) {
		undo.push(div.execute(mul.execute(a, b), b));
		return mul.execute(a, b);
	}
	
	public double div(double a, double b) {
		undo.push(mul.execute(div.execute(a, b), b));
		return div.execute(a, b);
	}
	
	public double undo() {
		return undo.pop();
	}
}
