package se_12_03;

public class Ticket {

	private int dauer;
	private double preis;
	private String kunde;
	
	public Ticket(int dauer, double preis, String kunde) {
		this.dauer = dauer;
		this.preis = preis;
		this.kunde = kunde;
	}
	
	public int getDauer() {
		return dauer;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public String getKunde() {
		return kunde;
	}
}
