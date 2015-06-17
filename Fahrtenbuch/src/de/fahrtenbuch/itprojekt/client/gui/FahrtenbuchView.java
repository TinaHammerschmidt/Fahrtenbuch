package de.fahrtenbuch.itprojekt.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import de.fahrtenbuch.itprojekt.shared.bo.Fahrer;

public class FahrtenbuchView {
	
	
	private HorizontalPanel hPanelOne = new HorizontalPanel();
	private HorizontalPanel hPanelTwo = new HorizontalPanel();

	
	//Panel 1
	
	private Hyperlink fahrtenBuchLink = new Hyperlink("Fahrtenbuch", "#");
	private Hyperlink reportLink = new Hyperlink("Report","#");
	private Hyperlink logoutLink = new Hyperlink("Logout", "#");
	private Button neueFahrtButton = new Button("Neue Fahrt anlegen");
	private Button eintragBearbeiten = new Button("Bearbeiten");
	private Button eintragLoeschen = new Button("Löschen");
	private Label fahrtenbuchHeader = new Label("Fahrtenbuch");
	
	//Panel 2
	
	private FlexTable tabellenKopf = new FlexTable();
	private DecoratorPanel decPanel = new DecoratorPanel();
	
	
	private Label startZeit = new Label("Startzeit");
	private Label endZeit = new Label("Endzeit");
	private Label dauer = new Label("Dauer");
	private Label fahrerName = new Label("Fahrer");
	private Label startOrt = new Label("Startort");
	private Label zielOrt = new Label("Zielort");
	private Label startKM = new Label("Start-KM");
	private Label endKM = new Label("End-KM");
	private Label tourKM = new Label("Tour-KM");
	private Label zweck = new Label("Zweck");
	
	//Panel mit veränderbaren Datensätze
	
	private Label startZeit1 = new Label("13:56:45");
	private Label endZeit1 = new Label("16:54:34");
	private Label dauer1 = new Label("3 Stunden");
	private Label fahrerName1 = new Label("Gustav Gans");
	private Label startOrt1 = new Label("Stuttgart");
	private Label zielOrt1 = new Label("München");
	private Label startKM1 = new Label("231.234");
	private Label endKM1 = new Label("245.234");
	private Label tourKM1 = new Label("15.323");
	private Label zweck1 = new Label("Dienstreise");
	
	private Image image = new Image();
	

	
	
	
	
	public void loadFahrtenbuch(Fahrer fahrerObjekt) {
		
		fahrerName1.setText(fahrerObjekt.getVorname() + " " + fahrerObjekt.getNachname());
		
		image.setWidth("100px");
		image.setHeight("60px");
		image.setUrl("images/amg_gt.jpg");
		
		hPanelTwo.add(image);
		
		
		//Panel Oben
		
		hPanelOne.add(fahrtenbuchHeader);
		hPanelOne.add(fahrtenBuchLink);
		hPanelOne.add(reportLink);
		hPanelOne.add(logoutLink);
		hPanelOne.add(eintragLoeschen);
		hPanelOne.add(eintragBearbeiten);
		hPanelOne.add(neueFahrtButton);
		
		//Panel Unten
		
		tabellenKopf.setWidget(0, 0, startZeit);
		tabellenKopf.setWidget(0, 1, endZeit);
		tabellenKopf.setWidget(0, 2, dauer);
		tabellenKopf.setWidget(0, 3, fahrerName);
		tabellenKopf.setWidget(0, 4, startOrt);
		tabellenKopf.setWidget(0, 5, zielOrt);
		tabellenKopf.setWidget(0, 6, startKM);
		tabellenKopf.setWidget(0, 7, endKM);
		tabellenKopf.setWidget(0, 8, tourKM);
		tabellenKopf.setWidget(0, 9, zweck);
		
		
		
		tabellenKopf.setWidget(1, 0, startZeit1);
		tabellenKopf.setWidget(1, 1, endZeit1);
		tabellenKopf.setWidget(1, 2, dauer1);
		tabellenKopf.setWidget(1, 3, fahrerName1);
		tabellenKopf.setWidget(1, 4, startOrt1);
		tabellenKopf.setWidget(1, 5, zielOrt1);
		tabellenKopf.setWidget(1, 6, startKM1);
		tabellenKopf.setWidget(1, 7, endKM1);
		tabellenKopf.setWidget(1, 8, tourKM1);
		tabellenKopf.setWidget(1, 9, zweck1);
		
		
		
		
		
		decPanel.add(tabellenKopf);
		
		RootPanel.get("headerDiv").add(hPanelOne);
		RootPanel.get("headerDiv").add(hPanelTwo);
		RootPanel.get("tabellenDiv").add(decPanel);
	}

}