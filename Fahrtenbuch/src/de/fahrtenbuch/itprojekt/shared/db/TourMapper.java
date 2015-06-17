package de.fahrtenbuch.itprojekt.shared.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;
import de.fahrtenbuch.itprojekt.shared.bo.Tour;

public class TourMapper {
	
	private static TourMapper tourMapper = null;
	
	/**
	 * Protected constructor to prevent to generate a new object of FahrerMapper
	 * (hidden from all)
	 */
	protected TourMapper() {
	}

	/**
	 * Static method to generate exact one object of FahrerMapper
	 * 
	 * @return The static instance of FahrerMapper
	 */
	public static TourMapper tourMapper() {
		if (tourMapper == null) {
			tourMapper = new TourMapper();
		}
		return tourMapper;
	}
	
	 public ArrayList<Tour> alleTourenProFahrer(int fahrerID) {
			//Aufbau der DBVerbindung
			Connection con = DBConnection.connection();
			ArrayList <Tour> tourArraylist = new ArrayList<Tour>();
			//Versuch der Abfrage
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `Tour` WHERE `FahrerID` = '"+fahrerID+"'");

				while (rs.next()) {
					// Ergebnis in Beitrag- Objekt umwandeln
					Tour t = new Tour();
					t.setEndZeit(rs.getTimestamp("EntZeit"));
					t.setKmStandStart(rs.getInt("KmStandStart"));
					t.setKmStandZiel(rs.getInt("KmStandZiel"));
					t.setStartOrt(rs.getString("StartOrt"));
					t.setStartZeit(rs.getTimestamp("StartZeit"));
					t.setTourDauer(rs.getTimestamp("TourDauer"));
					t.setTourID(rs.getInt("TourID"));
					t.setTourKm(rs.getInt("TourKm"));
					t.setZielOrt(rs.getString("ZielOrt"));
					t.setZweck(rs.getString("Zweck"));
				
				

			        tourArraylist.add(t);
				}
				return tourArraylist;		
			}
			   catch (SQLException e) {
		    		e.printStackTrace();
		    		return null;
			    }				
		}

}
