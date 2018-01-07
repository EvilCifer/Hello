package se_10.template;

public class WeekTakings extends TemplateClass {

	private double[] daily;
	
	public WeekTakings(double[] daily) {
		this.daily = daily;
	}
	
	@Override
	public double calculateSum() {
		return templateSum(daily);
	}
}
