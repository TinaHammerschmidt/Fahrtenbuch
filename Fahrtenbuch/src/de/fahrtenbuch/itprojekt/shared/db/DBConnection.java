package de.fahrtenbuch.itprojekt.shared.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBConnection {
	/**
	 * Die Klasse DBConnection wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten <b>Singleton</b>.<p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal f�r
	 * s�mtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 * 
	 * @see NutzerMapper.nutzerMapper()
	 */
	
	private static Connection con = null;
	
	/**
	 * Die URL, mit deren Hilfe die Datenbank angesprochen wird. In einer 
	 * professionellen Applikation w�rden diese Zeichenketten aus einer 
	 * Konfigurationsdatei eingelesen oder �ber einen Parameter von au�en 
	 * mitgegeben, um bei einer Ver�nderung dieser URL nicht die gesamte 
	 * Software neu komilieren zu m�ssen.
	 */
	
	private static String dbHost = "localhost"; // Hostname
	private static String dbPort = "3306";      // Port -- Standard: 3306
	private static String dbName = "fahrtenbuch";   // Datenbankname
	private static String dbUser = "root";     // Datenbankuser
	private static String dbPass = "";      // Datenbankpasswort

	/**
	 * Gibt die IP oder den DNS des Datenbankservers zur�ck.
	 * @return dbHost
	 */
	public static String getDbHost() {
		return dbHost;
	}
	/**
	 * Setzt die IP oder den DNS des Datenbankservers.
	 * @param dbHost
	 */
	public static void setDbHost(String dbHost) {
		DBConnection.dbHost = dbHost;
	}
	/**
	 * Gibt den Port des Datenbankservers zur�ck.
	 * @return dbPort
	 */
	public static String getDbPort() {
		return dbPort;
	}
	/**
	 * Setzt den Port des Datenbankservers.
	 * @param dbPort
	 */
	public static void setDbPort(String dbPort) {
		DBConnection.dbPort = dbPort;
	}
	/**
	 * Gibt den Datenbankbenutzer zur�ck.
	 * @return dbUser
	 */
	public static String getDbUser() {
		return dbUser;
	}
	/**
	 * Setzt den Datenbankbenutzer.
	 * @param dbUser
	 */
	public static void setDbUser(String dbUser) {
		DBConnection.dbUser = dbUser;
	}
	/**
	 * Gibt das Datenbankpasswort zur�ck.
	 * @return dbPass
	 */
	public static String getDbPass() {
		return dbPass;
	}
	/**
	 * Setzt das Datenbankpasswort.
	 * @param dbPass
	 */
	public static void setDbPass(String dbPass) {
		DBConnection.dbPass = dbPass;
	}
	/**
	 * Gibt den Namen den Datenbank zur�ck.
	 * @return dbName
	 */
	public static String getDbName() {
		return dbName;
	}
	/**
	 * Setzt den Datenbanknamen.
	 * @param dbName
	 */
	public static void setDbName(String dbName) {
		DBConnection.dbName = dbName;
	}

	/**
	 * Diese statische Methode kann aufgrufen werden durch 
	 * <code>DBConnection.connection()</code>. Sie stellt die 
	 * Singleton-Eigenschaft sicher, indem Sie daf�r sorgt, dass nur eine einzige
	 * Instanz von <code>DBConnection</code> existiert.<p>
	 * 
	 * <b>Fazit:</b> DBConnection sollte nicht mittels <code>new</code> 
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.<p>
	 * 
	 * <b>Nachteil:</b> Bei Zusammenbruch der Verbindung zur Datenbank - dies kann
	 * z.B. durch ein unbeabsichtigtes Herunterfahren der Datenbank ausgel�st 
	 * werden - wird keine neue Verbindung aufgebaut, so dass die in einem solchen
	 * Fall die gesamte Software neu zu starten ist. In einer robusten L�sung 
	 * w�rde man hier die Klasse dahingehend modifizieren, dass bei einer nicht
	 * mehr funktionsf�higen Verbindung stets versucht w�rde, eine neue Verbindung
	 * aufzubauen. Dies w�rde allerdings ebenfalls den Rahmen dieses Projekts 
	 * sprengen.
	 * 
	 * @return DAS <code>DBConnection</code>-Objekt.
	 * @see con
	 */

	public static Connection connection() {
		// Wenn es bisher keine Conncetion zur DB gab, ... 
		if (con == null) {
	    try {
	    	// Ersteinmal muss der passende DB-Treiber geladen werden
	    	DriverManager.registerDriver(new AppEngineDriver()); // Create driver from GWT-Package
	    	
			/*
			 * Dann erst kann uns der DriverManager eine Verbindung mit den oben
			 * in der Variable url angegebenen Verbindungsinformationen aufbauen.
			 * 
			 * Diese Verbindung wird dann in der statischen Variable con 
			 * abgespeichert und fortan verwendet.
			 */

	        //Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber f�r JDBC Schnittstellen laden.

	        // Verbindung zur JDBC-Datenbank herstellen.
	        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+ dbPort+"/"+dbName+"?"+"user="+dbUser+"&"+"password="+dbPass);

	     //   con = DriverManager.getConnection("jdbc:google:rdbms://smp-itp:elite/db", "root", "");


	    } catch (SQLException error) { //Wenn ein Fehler auftritt -> Verbidung trennen
	    	con = null;
	        System.out.println("Verbindung nicht moglich");
	        System.out.println("SQLException: " + error.getMessage());
	        System.out.println("SQLState: " + error.getSQLState());
	        System.out.println("VendorError: " + error.getErrorCode());
	    }
	  }
		// Zurückgegeben der Verbindung
		return con;
	}
}
