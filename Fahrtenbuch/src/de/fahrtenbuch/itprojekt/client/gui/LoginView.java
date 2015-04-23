package de.fahrtenbuch.itprojekt.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

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
	private class LoginClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
					
			
			
		service.loginCheck(textFeld.getText(), passwortTextBox.getText(), new AsyncCallback<Fahrer>() {

				@Override
				public void onFailure(Throwable caught) {
					System.out.println("Error!");
					
				}

				@Override
				public void onSuccess(Fahrer result) {
					ausgabeLabel.setText(result.getVorname() + " " + result.getNachname());
					
				}
				
			});

			
		}
		
		
	}
	

}
