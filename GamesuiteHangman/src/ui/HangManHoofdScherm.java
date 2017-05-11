package ui;

import java.awt.BorderLayout;

import model.HangMan;

public class HangManHoofdScherm extends GameHoofdScherm {

	private static final long serialVersionUID = 1L;

	public HangManHoofdScherm(HangMan spel, HangmanPaneel spelpaneel) {
		super("Hangman - " + spel.getSpeler().getNaam(), spel.getTekening());

		spelpaneel.setTekenVenster(getTekenvenster());
		this.add(spelpaneel, BorderLayout.SOUTH);
	}

	private void add(HangmanPaneel spelpaneel, String south) {
	}

	private TekenVenster getTekenvenster() {
		return null;
	}

	public void start() {
		this.pack();
		this.setVisible(true);
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	private void pack() {
		// TODO Auto-generated method stub

	}
}