package de.fahrtenbuch.itprojekt.client;

import com.google.gwt.core.client.EntryPoint;

import de.fahrtenbuch.itprojekt.client.gui.LoginView;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Fahrtenbuch implements EntryPoint {


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		LoginView login = new LoginView();
		login.loadLoginView();

	}
}
