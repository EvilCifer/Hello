package se_12;

public class Zweirad extends Fahrzeug {

	private static Zweirad instance;
	private double gebuehr;
	private double quadrat;
	
	public Zweirad() {
		throwException();
	}
	
	private Zweirad(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized Zweirad getInstance() {
		if(instance == null) {
			instance = new Zweirad(2.50, 1.00);
		}
		return instance;
	}
	
	private void throwException() {
		throw new ExceptionInInitializerError();
	}
	
	@Override
	public double getGebuehr() {
		return gebuehr;
	}
	
	@Override
	public double getQuadratmeterzahl() {
		return quadrat;
	}
	
}
