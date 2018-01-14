package se_12;

public class Pickup extends Fahrzeug {

	private static Pickup instance;
	private double gebuehr;
	private double quadrat;
	
	public Pickup() {
		throwException();
	}
	
	private Pickup(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized Pickup getInstance() {
		if(instance == null) {
			instance = new Pickup(3.00, 5.00);
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
