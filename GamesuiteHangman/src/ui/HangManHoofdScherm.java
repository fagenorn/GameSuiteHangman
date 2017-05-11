package ui;

import java.awt.BorderLayout;

import model.HangMan;

public class HangManHoofdScherm extends GameMainWindow {

	private static final long serialVersionUID = 1L;

	public HangManHoofdScherm(HangMan spel, HangmanPaneel spelpaneel) throws UIException {
		super("Hangman - " + spel.getSpeler().getNaam(), spel.getTekening());

		spelpaneel.setTekenVenster(getTekenvenster());
		this.add(spelpaneel, BorderLayout.SOUTH);
	}
	public void start() {
		this.pack();
		this.setVisible(true);
	}
}