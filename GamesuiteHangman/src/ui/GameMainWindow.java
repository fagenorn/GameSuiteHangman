package ui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import model.Tekening;

public class GameMainWindow extends JFrame {

	public GameMainWindow(String naam, Tekening tekening) throws HeadlessException {
		super();
		this.naam = naam;
		tekenvenster = new TekenVenster(tekening);
	}
	private static final long serialVersionUID = 1L;
	
	private String naam;
	private TekenVenster tekenvenster;
	
	public void teken(){
		
	}
	

}
