package se_12;

public class SUV extends Fahrzeug {

	private static SUV instance = null;
	private double gebuehr;
	private double quadrat;
	
	public SUV() {
		gebuehr = 4.00;
		quadrat = 4.00;
	}
	
	public static synchronized SUV getInstance() {
		if(instance == null) {
			instance = new SUV();
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
