package model;

import java.util.ArrayList;

import domain.DomainException;

public class HintWoord {

	private ArrayList<HintLetter> woord = new ArrayList<>();
	private boolean geraden = false;

	private void setWoord(String woord) {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("");
		}
		final int len = woord.length();
		for (int i = 0; i < len; i++) {
			char letter = woord.charAt(i);
			this.woord.add(new HintLetter(letter));
		}
	}

	public HintWoord(String string) {
		setWoord(string);
	}

	public boolean raad(char c) {
		int correct = 0;
		int aantal = 0;
		for (HintLetter letter : woord) {
			if (letter.raad(c)) {
				correct++;
			}
			if (letter.isGeraden()) {
				aantal++;
			}
		}

		if (aantal == woord.size()) {
			setGeraden(true);
		}
		return correct > 0;
	}

	public void setGeraden(boolean b) {
		geraden = b;
	}

	public boolean isGeraden() {
		return geraden;
	}

	public String getWoord() {
		String woord = "";
		for (HintLetter letter : this.woord) {
			woord += letter.getLetter();
		}
		return woord;
	}

	public String toString() {
		String woord = "";
		for (HintLetter letter : this.woord) {
			woord += (letter.isGeraden() ? letter.getLetter() : "_") + " ";
		}
		return woord.substring(0, woord.length() - 1);
	}

}
