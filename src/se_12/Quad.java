package se_12;

public class Quad extends Fahrzeug {

	private static Quad instance;
	private double gebuehr;
	private double quadrat;
	
	public Quad() {
		throwException();
	}
	
	private Quad(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static synchronized Quad getInstance() {
		if(instance == null) {
			instance = new Quad(4.50, 3.50);
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
