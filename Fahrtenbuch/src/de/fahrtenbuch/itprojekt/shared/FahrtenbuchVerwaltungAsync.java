package de.fahrtenbuch.itprojekt.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;

public interface FahrtenbuchVerwaltungAsync {

	void loginCheck(String username, String passwort, AsyncCallback<Fahrer> callback);

}
