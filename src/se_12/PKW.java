package se_12;

public class PKW extends Fahrzeug {

	private static PKW instance;
	private double gebuehr;
	private double quadrat;
	
	public PKW() {
		throwException();
	}
	
	private PKW(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized PKW getInstance() {
		if(instance == null) {
			instance = new PKW(2.00, 4.50);
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
