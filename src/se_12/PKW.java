package se_12;

public class PKW extends Fahrzeug {

	private static PKW instance = null;
	private double gebuehr;
	private double quadrat;
	
	public PKW() {
		gebuehr = 2.00;
		quadrat = 4.50;
	}
	
	public static synchronized PKW getInstance() {
		if(instance == null) {
			instance = new PKW();
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
