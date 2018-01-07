package se_10.template;

public abstract class TemplateClass {

	public double templateSum(double[] takings) {
		double sum = 0;
		for(int i = 0; i < takings.length; ++i) {
			sum += takings[i];
		}
		return sum;
	}
	
	public abstract double calculateSum();
}
