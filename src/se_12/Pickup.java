package se_12;

public class Pickup extends Fahrzeug {

//	private static Pickup instance = null;
	
	private double gebuehr;
	private double quadrat;
	private static final Pickup instance = new Pickup(3.00, 5.00);
	
	public Pickup() {
		throwException();
	}
	
	private Pickup(double gebuehr, double quadrat) {
		this.gebuehr = gebuehr;
		this.quadrat = quadrat;
	}
	
	public static Pickup getInstance() {
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
	
	public static void main(String[] args) {
		Fahrzeug pickup = Pickup.getInstance();
		Fahrzeug pickup2 = new Pickup();
	}
}
