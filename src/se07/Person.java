package se07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	// Frau Dr. Eva Müller, Hochschule Bonn-Rhein-Sieg, Fachbereich Informatik, Grantham-Allee 20, 53757 Sankt Augustin
	private String anrede;
	private String titel;
	private String vorname;
	private String nachname;
	private String organisation;
	private String abteilung;
	private String strasse;
	private String hausnummer;
	private String plz;
	private String stadt;
	
	public Person(String input) {

		Matcher matcher = Pattern.compile(
				    "(Herr|Frau)"//--------------------- Anrede
				  + "[ \\t]"
				  + "(Prof. Dr.|Dr.|Prof.)"//----------- Titel
				  + "[ \\t]"
				  + "([\\w|ö|ü|ä]+)"//------------------ Vorname
				  + "[ \\t]"
				  + "([\\w|ö|ü|ä]+)"//------------------ Nachname
				  + ",[ \\t]"
				  + "([\\w|ö|ü|ä| \\t|-]+)"//----------- Organisation
				  + ",[ \\t]"
				  + "([\\w|ö|ü|ä| \\t|-]+)"//----------- Abteilung
				  + ",[ \\t]"
				  + "([\\w|ä|ü|ö]+-?\\w+\\.?)"//-------- Straße
				  + "[ \\t]"
				  + "(\\d+[a-z]?)"//-------------------- Hausnummer
				  + ",[ \\t]"
				  + "(\\d{5,5})"//---------------------- PLZ
				  + "[ \\t]"
				  + "(\\w+[ \\t|-]?\\w*)"//------------- Stadt
				  ).matcher(input);
		
		if(matcher.find()) {
			this.anrede = matcher.replaceAll("$1");
			this.titel = matcher.replaceAll("$2");
			this.vorname = matcher.replaceAll("$3");
			this.nachname = matcher.replaceAll("$4");
			this.organisation = matcher.replaceAll("$5");
			this.abteilung = matcher.replaceAll("$6");
			this.strasse = matcher.replaceAll("$7");
			this.hausnummer = matcher.replaceAll("$8");
			this.plz = matcher.replaceAll("$9");
			this.stadt = matcher.replaceAll("$10");
		}
	}
	
	public String getAnrede() {
		return anrede;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public String getOrganisation() {
		return organisation;
	}
	
	public String getAbteilung() {
		return abteilung;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public String getHausnummer() {
		return hausnummer;
	}
	
	public String getPlz() {
		return plz;
	}
	
	public String getStadt() {
		return stadt;
	}
}
