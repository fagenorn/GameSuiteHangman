package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import model.HintWoord;
import model.WoordenLijst;

public class HangManUi {
	private static String spelNaam = "HangMan";
	private String titel;
	private Speler speler;
	private WoordenLijst lijst;

	public Speler getSpeler() {
		return speler;
	}

	private void setSpeler(Speler speler) {
		this.speler = speler;
		titel = "spelNaam - " + getSpeler().getNaam();
	}

	public HangManUi(Speler speler, WoordenLijst lijst) {
		setSpeler(speler);
		this.lijst = lijst;
	}

	public void play() {
		String woord = lijst.getRandomWoord();
		HintWoord hintWoord = new HintWoord(woord);
		while (!hintWoord.isGeraden()) {
			String gok = JOptionPane.showInputDialog(null, "Gok een letter: \n" + hintWoord.toString(), titel, JOptionPane.DEFAULT_OPTION);
			if (gok.length() != 1) {
				continue;
			}

			String message = hintWoord.raad(gok.charAt(0)) ? "Goed geraden" : "Fout, probeer nog eens...";
			JOptionPane.showMessageDialog(null, message);
		}
		JOptionPane.showMessageDialog(null, "Goed gegokt!\nJe hebt gewonnen.");

	}
}
