package se_12;

public class Pickup extends Fahrzeug {

	private static Pickup instance = null;
	private double gebuehr;
	private double quadrat;
	
	public Pickup() {
		gebuehr = 3.00;
		quadrat = 5.00;
	}
	
	public static synchronized Pickup getInstance() {
		if(instance == null) {
			instance = new Pickup();
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
