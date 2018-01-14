package se_12;

public class SUV extends Fahrzeug {

	private static SUV instance;
	private double gebuehr;
	private double quadrat;
	
	public SUV() {
		throwException();
	}
	
	private SUV(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized SUV getInstance() {
		if(instance == null) {
			instance = new SUV(4.00, 4.00);
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
