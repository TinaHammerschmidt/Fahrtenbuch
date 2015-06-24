package de.fahrtenbuch.itprojekt.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;

public class FahrtenbuchView {

	private HorizontalPanel hPanelOne = new HorizontalPanel();
	private HorizontalPanel hPanelTwo = new HorizontalPanel();
	
	private Hyperlink fahrtenBuchLink = new Hyperlink("Fahrtenbuch ", "url");
	private Hyperlink report   = new Hyperlink ("Report","url");
	private Hyperlink logout = new Hyperlink ("Logout","url");
	private Button neueFahrtAnlegen = new Button ("Neue Fahrt anlegen");
	private Button bearbeiten = new Button ("Bearbeiten");
	private Button loeschen = new Button ("Löschen");
	private FlexTable tabelle = new FlexTable();
	
	private FlexTable flexTable = new FlexTable();

	private Label auswahl = new Label("x");
	private Label startzeit = new Label("x");
	private Label endzeit = new Label("x");
	private Label fahrer = new Label("x");
	private Label startort = new Label("x");
	private Label zielort = new Label("x");
	private Label startKm = new Label("x");
	private Label endKm = new Label("x");
	private Label tourKm = new Label("x");
	private Label zweck = new Label("x");
	

	
	
	

	
	public void neueFahrtAnlegen (){
		//int test = 1;
		//Window.alert(Integer.toString(test));

	  /**  flexTable.setText(2, 0, "Auswahl");
	    flexTable.setText(2, 1, "Startzeit");
	    flexTable.setText(2, 2, "Endzeit");
	    flexTable.setText(2, 4, "Fahrer");
	    flexTable.setText(2, 5, "Startort");
	    flexTable.setText(2, 6, "Zielort");
	    flexTable.setText(1, 7, "Start-KM");
	    flexTable.setText(1, 8, "End-KM");
	    flexTable.setText(1, 9, "Tour-KM");
	    flexTable.setText(1, 9, "Zweck");
		
	    flexTable.setWidget(1, 0, auswahl);
	    flexTable.setWidget(1, 1, startzeit);
	    flexTable.setWidget(1, 2, endzeit);
	    flexTable.setWidget(1, 4, fahrer);
	    flexTable.setWidget(1, 5, startort);
	    flexTable.setWidget(1, 6, zielort);
	    flexTable.setWidget(1, 7, startKm);
	    flexTable.setWidget(1, 8, endKm);
	    flexTable.setWidget(1, 9, tourKm);
	    flexTable.setWidget(1, 9, zweck);
*/
	}
	
	private Image image = new Image();
	
	public void loadFahrtenbuch(Fahrer fahrerObjekt){
		
		neueFahrtAnlegen.addClickHandler(new FahrerAnlegenClickHandler());
		
		fahrer.setText(fahrerObjekt.getVorname() + " " + fahrerObjekt.getNachname());
		
		image.setWidth("250px");
		image.setHeight("Auto");
		image.setUrl("Image/amg_gt.jpg");
		
		
	hPanelOne.add(image);
		hPanelOne.add(fahrtenBuchLink);
		hPanelOne.add(report);
		hPanelOne.add(logout);
		hPanelTwo.add(neueFahrtAnlegen);
		hPanelTwo.add(bearbeiten);
		hPanelTwo.add(loeschen);
		
	


		    flexTable.setText(0, 0, "Auswahl");
		    flexTable.setText(0, 1, "Startzeit");
		    flexTable.setText(0, 2, "Endzeit");
		    flexTable.setText(0, 4, "Fahrer");
		    flexTable.setText(0, 5, "Startort");
		    flexTable.setText(0, 6, "Zielort");
		    flexTable.setText(0, 7, "Start-KM");
		    flexTable.setText(0, 8, "End-KM");
		    flexTable.setText(0, 9, "Tour-KM");
		    flexTable.setText(0, 9, "Zweck");
			
		    flexTable.setWidget(1, 0, auswahl);
		    flexTable.setWidget(1, 1, startzeit);
		    flexTable.setWidget(1, 2, endzeit);
		    flexTable.setWidget(1, 4, fahrer);
		    flexTable.setWidget(1, 5, startort);
		    flexTable.setWidget(1, 6, zielort);
		    flexTable.setWidget(1, 7, startKm);
		    flexTable.setWidget(1, 8, endKm);
		    flexTable.setWidget(1, 9, tourKm);
		    flexTable.setWidget(1, 9, zweck);
		
		
		RootPanel.get("tabellenDiv").add(hPanelOne);
		RootPanel.get("tabellenDiv").add(hPanelTwo);
		RootPanel.get("tabellenDiv").add(flexTable);
		
		
		
		
		hPanelOne.addStyleName("hPanelOne");
		
	
		
		
		
		
	}
	
	private class FahrerAnlegenClickHandler implements ClickHandler {
		public void onClick(ClickEvent event){
			neueFahrtAnlegen ();
		}
	}
	
	
	
}
