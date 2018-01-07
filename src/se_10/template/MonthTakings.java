package se_10.template;

public class MonthTakings extends TemplateClass {

	private double[] weekly;
	
	public MonthTakings(double[] weekly) {
		this.weekly = weekly;
	}
	
	@Override
	public double calculateSum() {
		return templateSum(weekly);
	}
}
