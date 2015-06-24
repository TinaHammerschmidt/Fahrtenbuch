package de.fahrtenbuch.itprojekt.client.gui;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.fahrtenbuch.itprojekt.shared.FahrtenbuchVerwaltung;
import de.fahrtenbuch.itprojekt.shared.FahrtenbuchVerwaltungAsync;
import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;

public class LoginView {
	
	/**
	 * <b>service</b> heißt unsere Proxyreferenz, welche mit dem Server interagiert.
	 */
	
	FahrtenbuchVerwaltungAsync service = GWT.create(FahrtenbuchVerwaltung.class);
	
	private Label fahrerLabel = new Label("Fahrer:");
	private Label passwortLabel = new Label("Passwort:");
	private Button loginButton = new Button("Login");
	private TextBox textFeld = new TextBox();
	private PasswordTextBox passwortTextBox = new PasswordTextBox();
	
	private Label ausgabeLabel = new Label("Nutzer");
	
	private DecoratorPanel decPanel = new DecoratorPanel();
	private FlexTable loginFlexTable = new FlexTable();
	
	
	
	
	public void loadLoginView() {
		
		/**
		 * Dem Button wird ein ClickHandler zugeordnet.
		 */
		
		loginButton.addClickHandler(new LoginClickHandler());
		
		/**
		 * Oben definierte Buttons, Labels und Textboxen werden dem Flextable zugeordnet.
		 */
		
		loginFlexTable.setWidget(0, 1, fahrerLabel);
		loginFlexTable.setWidget(0, 2, textFeld);
		loginFlexTable.setWidget(1, 1, passwortLabel);
		loginFlexTable.setWidget(1, 2, passwortTextBox);
		loginFlexTable.setWidget(2, 2, loginButton);
		loginFlexTable.setWidget(2, 3, ausgabeLabel);
		
		/**
		 * Hier wird das FlexTable in ein DecoratorPanel gepackt.
		 */
		
		decPanel.add(loginFlexTable);
		textFeld.addKeyDownHandler( new LoginKeyDownHandler());
		passwortTextBox.addKeyDownHandler( new LoginKeyDownHandler());
		
		/**
		 * Das Loginfenster (DecoratorPanel) wird dem DIV-Element <b>Navigator</b> zugeordnet.
		 */
		
		RootPanel.get("tabellenDiv").add(decPanel);
	}
	/**
	 * ClickHandler für den Login
	 * @author raven
	 *
	 */
	
	private class LoginKeyDownHandler implements KeyDownHandler{
		
		public void onKeyDown(KeyDownEvent event){
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
			ueberPruefeLoginInformationen();
			
		}
	}
	}
	private class LoginClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			
			ueberPruefeLoginInformationen();
			
		}
		
		
	}
	
	public void ueberPruefeLoginInformationen() {
		
		if (textFeld.getText().isEmpty() || passwortTextBox.getText().isEmpty()) {
			ausgabeLabel.setText("Bitte beide Felder ausfuellen.");
		}
		else {
		
			if (textFeld.getText().matches("[a-z][a-z][0123456789][0123456789][0123456789]")) {
				/*
				 * Ab hier passen alle Logininformationen. Nun kommt die Datenbankabfrage per Proxy.
				 */
				service.loginCheck(textFeld.getText(), passwortTextBox.getText(), new AsyncCallback<Fahrer>() {

					@Override
					public void onFailure(Throwable caught) {
						ausgabeLabel.setText("User" + textFeld.getText() + "nicht gefunden.");
						
					}

					@Override
					public void onSuccess(Fahrer result) {
						
						if ((result.getVorname() == null) || (result.getNachname() == null)) {
							ausgabeLabel.setText("User:" + " " + textFeld.getText() + " " + "mit angegebenem Passwort nicht gefunden.");
						}
						else {
							//ausgabeLabel.setText(result.getVorname() + " " + result.getNachname());
							RootPanel.get("tabellenDiv").clear();
							FahrtenbuchView fbview = new FahrtenbuchView();
							fbview.loadFahrtenbuch(result);
						
						}
					}
					
				});
			}
			else {
				ausgabeLabel.setText("Bitte korrektes Format angeben: xx123");
			}	
		}
	}
	

}
