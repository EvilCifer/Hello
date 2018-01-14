package se_12_04;

public class DivCommand extends Command {

	public double execute(double a, double b) {
		if(b == 0) throw new ArithmeticException();
		return a/b;
	}
}
