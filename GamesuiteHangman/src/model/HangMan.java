package model;

import domain.DomainException;
import domain.Speler;

public class HangMan {

	private Speler speler;
	private HintWoord hint;
	private TekeningHangMan tekeningHangMan = new TekeningHangMan("HangMan");
	private boolean gewonnen;
	private boolean verloren;
	private final WoordenLijst lijst;

	public HangMan(Speler speler, WoordenLijst woordenlijst) {
		if (woordenlijst == null) {
			throw new DomainException("");
		}
		setSpeler(speler);
		lijst = woordenlijst;
		reset();
	}

	public void reset() {
		hint = new HintWoord(lijst.getRandomWoord());
		getTekening().reset();
		gewonnen = false;
		verloren = false;
	}

	public Speler getSpeler() {
		return speler;
	}

	public void setSpeler(Speler speler) {
		if (speler == null) {
			throw new DomainException("");
		}
		this.speler = speler;
	}

	public String getHint() {
		return hint.toString();
	}

	public TekeningHangMan getTekening() {
		return tekeningHangMan;
	}

	public boolean isGameOver() {
		return verloren;
	}

	public boolean isGewonnen() {
		return gewonnen;
	}

	public void raad(char letter) {
		if (!hint.raad(letter)) {
			tekeningHangMan.setVolgendeZichtbaar();
		}
		if (hint.isGeraden()) {
			gewonnen = true;
		}
		if (tekeningHangMan.getAantalZichtbaar() == 18) {
			verloren = true;
		}
	}
}
