package se1_08_03;

public class Auto {

	private boolean turbo;
	private Kunde kunde;
	private int dauer;
	
	public Auto(boolean turbo, Kunde kunde, int dauer) {
		this.turbo = turbo;
		this.kunde = kunde;
		this.dauer = dauer;
	}
	
	public boolean hatTurbo() {
		return turbo;
	}
	
	public Kunde kunde() {
		return kunde;
	}
	
	public int parkdauer() {
		return dauer;
	}
}
