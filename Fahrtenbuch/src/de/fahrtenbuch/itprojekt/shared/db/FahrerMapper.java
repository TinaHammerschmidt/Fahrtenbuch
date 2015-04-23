package de.fahrtenbuch.itprojekt.shared.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;

public class FahrerMapper {
	
	private static FahrerMapper fahrerMapper = null;
	
	/**
	 * Protected constructor to prevent to generate a new object of FahrerMapper
	 * (hidden from all)
	 */
	protected FahrerMapper() {
	}

	/**
	 * Static method to generate exact one object of FahrerMapper
	 * 
	 * @return The static instance of FahrerMapper
	 */
	public static FahrerMapper fahrerMapper() {
		if (fahrerMapper == null) {
			fahrerMapper = new FahrerMapper();
		}
		return fahrerMapper;
	}
	
	/*
	 * Methode überprüft Login
	 */
	
	public Fahrer getFahrer(String username, String passwort) {
		
		Connection con = DBConnection.connection();
		Fahrer f = new Fahrer();
		try {

			Statement state = con.createStatement();
			ResultSet rs = state
					.executeQuery("SELECT * FROM Fahrer WHERE Username='"
							+ username + "' AND Passwort='" + passwort
							+ "'");

			while (rs.next()) {
				
				f.setFahrerID(rs.getInt("FahrerID"));
				f.setVorname(rs.getString("Vorname"));
				f.setNachname(rs.getString("Nachname"));
				f.setPasswort(rs.getString("Passwort"));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * Gibt das ausgelesene Fahrerobjekt zurück.
		 */
		
		return f;
		
	}
	
}
