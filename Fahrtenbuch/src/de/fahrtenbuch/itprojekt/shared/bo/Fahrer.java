package de.fahrtenbuch.itprojekt.shared.bo;

public class Fahrer extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int fahrerID;
	
	private String vorname;
	
	private String nachname;
	
	private String passwort;

	public int getFahrerID() {
		return fahrerID;
	}

	public void setFahrerID(int fahrerID) {
		this.fahrerID = fahrerID;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}
