package de.fahrtenbuch.itprojekt.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;
import de.fahrtenbuch.itprojekt.shared.bo.Tour;

@RemoteServiceRelativePath("buch") //Shortcut Name der im URL Pattern am Ende stehen muss!
public interface FahrtenbuchVerwaltung extends RemoteService {
	
	
	public Fahrer loginCheck(String username, String passwort) throws IllegalArgumentException;
	
	public Tour sucheTourPerID(int id) throws IllegalArgumentException;

}
