package se_12;

public class Trike extends Fahrzeug {

	private static Trike instance;
	private double gebuehr;
	private double quadrat;
	
	public Trike() {
		throwException();
	}
	
	private Trike(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized Trike getInstance() {
		if(instance == null) {
			instance = new Trike(3.50, 2.00);
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
