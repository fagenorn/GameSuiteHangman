package ui;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import domain.Speler;
import model.Cirkel;
import model.Driehoek;
import model.LijnStuk;
import model.Punt;
import model.Rechthoek;
import model.Tekening;
import model.TekeningHangMan;

public class DrawTest {

	@Test
	public void test() throws InterruptedException, UIException {
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		Punt begin = new Punt(1, 1);
		Punt eind = new Punt(399, 399);
		tekening.voegToe(new LijnStuk(begin, eind));
		tekening.getVormen().forEach((v) -> v.setZichtbaarheid(true));
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();

		// TimeUnit.SECONDS.sleep(5); //Als je tekening visueel wilt zien.
	}

	@Test
	public void tekenRechthoek() throws InterruptedException, UIException {
		Punt linkerBovenhoek = new Punt(200, 200);
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		int breedte = 20;
		int hoogte = 40;
		Rechthoek rechthoek = new Rechthoek(linkerBovenhoek, breedte, hoogte);

		tekening.voegToe(rechthoek);

		tekening.getVormen().forEach((v) -> v.setZichtbaarheid(true));
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();

		// TimeUnit.SECONDS.sleep(5); //Als je tekening visueel wilt zien.
	}

	public void cirkelTest() throws InterruptedException, UIException {
		Punt punt = new Punt(200, 200);
		Cirkel cirkel = new Cirkel(punt, 100);
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		tekening.voegToe(cirkel);

		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();

		// TimeUnit.SECONDS.sleep(5); //Als je tekening visueel wilt zien.
	}

	@Test
	public void driehoekTest() throws InterruptedException, UIException {
		Punt punt = new Punt(220, 200);
		Punt punt2 = new Punt(100, 100);
		Punt punt3 = new Punt(300, 300);
		Driehoek driehoek = new Driehoek(punt, punt2, punt3);
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		tekening.voegToe(driehoek);

		tekening.getVormen().forEach((v) -> v.setZichtbaarheid(true));
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();

		// TimeUnit.SECONDS.sleep(5); //Als je tekening visueel wilt zien.
	}

	@Test
	public void hangman() throws InterruptedException, UIException{
		TekeningHangMan tekening = new TekeningHangMan("Hangman");

		GameMainWindow view = new GameMainWindow("Lol", tekening);
		view.setVisible(true);
		view.teken();

		// TimeUnit.SECONDS.sleep(5); //Als je tekening visueel wilt zien.
	}

}
