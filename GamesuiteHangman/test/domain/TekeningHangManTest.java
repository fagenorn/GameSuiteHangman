package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Cirkel;
import model.LijnStuk;
import model.Punt;
import model.Rechthoek;
import model.TekeningHangMan;
import model.Vorm;

public class TekeningHangManTest {
	
	Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
	Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
	Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
	Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
	Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
	Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
	Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
	Vorm neus = new Cirkel(new Punt(280, 128), 2);
	Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
	Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
	Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
	Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
	Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
	Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
	Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
	Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
	Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
	Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
	
	TekeningHangMan tek = new TekeningHangMan("hangman");
	
	@Test
	public void tets(){
		assertEquals(4, tek.getAantalZichtbaar());
		tek.setAantalZichtbaar(tek.getAantalVormen()-1);
		assertEquals(tek.getAantalVormen()-1, tek.getAantalZichtbaar());
		tek.setVolgendeZichtbaar();
		assertEquals(tek.getAantalVormen(), tek.getAantalZichtbaar());
	}
	
	@Test(expected = DomainException.class)
	public void throws_exception(){
		tek.setAantalZichtbaar(tek.getAantalVormen());
		tek.setVolgendeZichtbaar();
	}
	
	
	@Test(expected = DomainException.class)
	public void Voeg_Toe_In_Hangman_Gooit_Exception(){
		tek.voegToe(handLinks);
	}
	
	@Test(expected = DomainException.class)
	public void Verwijder_Toe_In_Hangman_Gooit_Exception(){
		tek.verwijder(handLinks);
	}

}
