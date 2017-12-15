package se1_08_03;

public class Kunde {

	private String name;
	private boolean firma;
	
	public Kunde(String name, boolean firma) {
		this.name = name;
		this.firma = firma;
	}
	
	public boolean istFirma() {
		return firma;
	}
}
