package model;

import domain.DomainException;

public class HintLetter {

	private boolean geraden;
	private char letter;

	public void setGeraden(boolean geraden) {
		this.geraden = geraden;
	}

	public void setLetter(char letter) {
		if(letter == ' '){
			throw new DomainException("Letter mag geen spatie zijn");
		}
		this.letter = letter;
	}

	public HintLetter(char c) {
		setLetter(c);
	}

	public boolean raad(char c) {
		geraden = letter == c;
		return isGeraden();

	}

	public boolean isGeraden() {
		return geraden;
	}

	public char getLetter() {
		return geraden ? toChar() : '_';
	}
	
	public char toChar(){
		return letter;	
	}

}
