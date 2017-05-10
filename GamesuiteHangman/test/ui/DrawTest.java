package ui;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import domain.Speler;
import model.LijnStuk;
import model.Punt;
import model.Tekening;
import model.Vorm;

public class DrawTest {

	@Test
	public void test() throws InterruptedException {
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		Punt begin =  new Punt(1,1);
		Punt eind = new Punt(399,399);
		tekening.voegToe(new LijnStuk(begin, eind));
		
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		
		TimeUnit.SECONDS.sleep(5);
		}

}
