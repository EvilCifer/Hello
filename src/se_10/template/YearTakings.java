package se_10.template;

public class YearTakings extends TemplateClass {

	private double[] monthly;
	
	public YearTakings(double[] monthly) {
		this.monthly = monthly;
	}
	
	@Override
	public double calculateSum() {
		return templateSum(monthly);
	}
}
