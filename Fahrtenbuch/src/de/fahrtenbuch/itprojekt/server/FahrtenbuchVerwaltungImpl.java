package de.fahrtenbuch.itprojekt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.fahrtenbuch.itprojekt.shared.FahrtenbuchVerwaltung;
import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;
import de.fahrtenbuch.itprojekt.shared.db.FahrerMapper;

public class FahrtenbuchVerwaltungImpl extends RemoteServiceServlet implements FahrtenbuchVerwaltung {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/*
	 * Methode gibt bei Login einen Fahrer aus.
	 */
	
	@Override
	public Fahrer loginCheck(String username, String passwort) {
				
		// TODO Auto-generated method stub
		Fahrer f = FahrerMapper.fahrerMapper().getFahrer(username, passwort);

		return f;
	}
	

}
