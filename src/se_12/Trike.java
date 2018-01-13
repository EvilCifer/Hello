package se_12;

public class Trike extends Fahrzeug {

	private static Trike instance = null;
	private double gebuehr;
	private double quadrat;
	
	public Trike() {
		gebuehr = 3.50;
		quadrat = 2.00;
	}
	
	public static synchronized Trike getInstance() {
		if(instance == null) {
			instance = new Trike();
		}
		return instance;
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
