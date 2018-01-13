package se_12;

public class Zweirad extends Fahrzeug {

	private static Zweirad instance = null;
	private double gebuehr;
	private double quadrat;
	
	public Zweirad() {
		gebuehr = 2.50;
		quadrat = 1.00;
	}
	
	public static synchronized Zweirad getInstance() {
		if(instance == null) {
			instance = new Zweirad();
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
