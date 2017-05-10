package ui;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import domain.Speler;
import model.Cirkel;
import model.LijnStuk;
import model.Punt;
import model.Rechthoek;
import model.Tekening;
import model.Vorm;

public class DrawTest {

	@Test
	public void test() throws InterruptedException, UIException {
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
	
	@Test
	public void tekenRechthoek() throws InterruptedException, UIException{
		Punt linkerBovenhoek = new Punt(200, 200);
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		int breedte = 20;
		int hoogte = 40;
		Rechthoek rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
		
		tekening.voegToe(rechthoek);
		
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		
		TimeUnit.SECONDS.sleep(5);
	}
	
	
	public void cirkelTest() throws InterruptedException, UIException{
		Punt punt = new Punt(200,200);
		Cirkel cirkel = new Cirkel(punt, 100);
		Speler speler = new Speler("Mark");
		Tekening tekening = new Tekening(speler.getNaam());
		tekening.voegToe(cirkel);
		
		GameMainWindow view = new GameMainWindow(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		
		TimeUnit.SECONDS.sleep(5);
		
		
	}

}
