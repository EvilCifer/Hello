package se_12;

public class Quad extends Fahrzeug {

	private static Quad instance = null;
	private double gebuehr;
	private double quadrat;
	
	public Quad() {
		gebuehr = 4.50;
		quadrat = 3.50;
	}
	
	public static synchronized Quad getInstance() {
		if(instance == null) {
			instance = new Quad();
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
