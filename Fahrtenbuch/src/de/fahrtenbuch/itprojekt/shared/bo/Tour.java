package de.fahrtenbuch.itprojekt.shared.bo;

import java.sql.Timestamp;

public class Tour extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String zweck;
	
	private int kmStandStart;
	
	private int kmStandZiel;
	
	private int tourKm;
	
	private Timestamp startZeit;
	
	private Timestamp endZeit;

	private Timestamp tourDauer;
	
	private int tourID;
	
	private String startOrt;
	
	private String zielOrt;
	
	
	
	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public String getStartOrt() {
		return startOrt;
	}

	public void setStartOrt(String startOrt) {
		this.startOrt = startOrt;
	}

	public String getZielOrt() {
		return zielOrt;
	}

	public void setZielOrt(String zielOrt) {
		this.zielOrt = zielOrt;
	}

	public String getZweck() {
		return zweck;
	}

	public void setZweck(String zweck) {
		this.zweck = zweck;
	}

	public int getKmStandStart() {
		return kmStandStart;
	}

	public void setKmStandStart(int kmStandStart) {
		this.kmStandStart = kmStandStart;
	}

	public int getKmStandZiel() {
		return kmStandZiel;
	}

	public void setKmStandZiel(int kmStandZiel) {
		this.kmStandZiel = kmStandZiel;
	}

	public int getTourKm() {
		return tourKm;
	}

	public void setTourKm(int tourKm) {
		this.tourKm = tourKm;
	}

	public Timestamp getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(Timestamp startZeit) {
		this.startZeit = startZeit;
	}

	public Timestamp getEndZeit() {
		return endZeit;
	}

	public void setEndZeit(Timestamp endZeit) {
		this.endZeit = endZeit;
	}

	public Timestamp getTourDauer() {
		return tourDauer;
	}

	public void setTourDauer(Timestamp tourDauer) {
		this.tourDauer = tourDauer;
	}
}
