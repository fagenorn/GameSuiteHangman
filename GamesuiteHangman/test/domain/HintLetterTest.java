package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import model.HintLetter;

public class HintLetterTest {

	private HintLetter letter = new HintLetter('a');

	@Test(expected=DomainException.class)
	public void letter_aanmaken_die_spatie_is_gooit_exception() {
		HintLetter letter = new HintLetter(' ');
	}

	@Test
	public void letter_juist_raden() {
		assertTrue(letter.raad('a'));
		assertTrue(letter.isGeraden());
		assertTrue('a' == letter.getLetter());
	}

	@Test
	public void letter_fout_raden() {
		assertFalse(letter.raad('s'));
		assertFalse(letter.isGeraden());
		assertTrue('_' == letter.getLetter());
	}
}
