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
		
		

		String[] choices = { "Pictionary", "HangMan" };
		String choice = (String) JOptionPane.showInputDialog(null, "Welke spel wil je spelen?",
				"Keuze spel", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
		switch (choice) {
		case "HangMan":
			HangManUi hangman = new HangManUi(speler);
			hangman.play();
			break;
		default:
			UI ui = new UI(speler);
			ui.load();
			break;
		}
	}

}
