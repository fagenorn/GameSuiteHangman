package model;

public class HintLetter {

	private boolean geraden;
	private char letter;

	public void setGeraden(boolean geraden) {
		this.geraden = geraden;
	}

	public void setLetter(char letter) {
		if (letter == ' '){
			setGeraden(true);
		}
		this.letter = letter;
	}

	public HintLetter(char c) {
		setLetter(c);
	}

	public boolean raad(char c) {
		if (isGeraden()) {
			return false;
		}
		geraden = Character.toLowerCase(letter) == Character.toLowerCase(c);
		return isGeraden();

	}

	public boolean isGeraden() {
		return geraden;
	}

	public char getLetter() {
		return letter;
	}

	public char toChar() {
		return geraden ? getLetter() : '_';
	}

}
