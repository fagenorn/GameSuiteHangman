package ui;

import java.io.File;
import java.net.URL;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.Speler;
import model.HangMan;
import model.WoordenLijst;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		URL keyFileURL = Launcher.class.getClassLoader().getResource("resources/hangman.txt");
		WoordenLezer lezer = new WoordenLezer(new File(keyFileURL.getPath()));
		WoordenLijst lijst = lezer.lees();

		String[] choices = { "Pictionary", "HangMan" };
		String choice = (String) JOptionPane.showInputDialog(null, "Welke spel wil je spelen?", "Keuze spel",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
		switch (choice) {
		case "HangMan":
			HangMan spel = new HangMan(speler, lijst);
			HangManHoofdScherm scherm;
			try {
				scherm = new HangManHoofdScherm(spel, new HangmanPaneel(spel));
				scherm.start();
			} catch (UIException e) {
				e.printStackTrace();
			}
			break;
		default:
			UI ui = new UI(speler);
			ui.load();
			break;
		}
	}

}
