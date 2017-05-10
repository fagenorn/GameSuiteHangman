package ui;

import java.io.File;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.Speler;
import model.WoordenLijst;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
		WoordenLijst lijst = lezer.lees();
		
		

		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		UI ui = new UI(speler);
		ui.load();
	}
	
	

}
