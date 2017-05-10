package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijstLeeg = new WoordenLijst();
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		
	}
	@Test
	public void RandomTest_lijst_is_leeg_geeft_null_terug(){
		WoordenLijst woorden = new WoordenLijst();
		assertEquals(null,woorden.getRandomWoord() );
	}
	
	@Test
	public void RandomTest_lijst_heeft_1waarde_geeft_die_terug(){
		WoordenLijst woorden = new WoordenLijst();
		woorden.voegToe("patat");
		assertEquals("patat",woorden.getRandomWoord() );
	}

	@Test
	public void RandomTest_lijst_heeft_meerdere_waardes_geeft_random_terug_no_Exception(){
		WoordenLijst woorden = new WoordenLijst();
		String Randomness = "";
		woorden.voegToe("patat0");
		woorden.voegToe("patat1");
		woorden.voegToe("patat2");
		woorden.voegToe("patat3");
		woorden.voegToe("patat4");
		woorden.voegToe("patat5");
		woorden.voegToe("patat6");
		woorden.voegToe("patat7");
		woorden.voegToe("patat8");
		woorden.voegToe("patat9");
		
		for(int i = 0;i < 1000;i++){
			Randomness +=woorden.getRandomWoord();
		}
	}
	
	@Test
	public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() {
		WoordenLijst woordenlijstLeeg = new WoordenLijst();
		assertEquals(0,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test
	public void voegToe_moet_een_woord_toevoegen() {
		woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
		
		assertEquals(1,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() {
		woordenlijstLeeg.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() {
		woordenlijstLeeg.voegToe("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() {
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
	}

}