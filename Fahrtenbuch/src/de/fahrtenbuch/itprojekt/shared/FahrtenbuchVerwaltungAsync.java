package de.fahrtenbuch.itprojekt.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;
import de.fahrtenbuch.itprojekt.shared.bo.Tour;

public interface FahrtenbuchVerwaltungAsync {

	void loginCheck(String username, String passwort, AsyncCallback<Fahrer> callback);

	void sucheTourPerID(int id, AsyncCallback<Tour> callback);

}
