package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.LijnStuk;
import model.Omhullende;
import model.Punt;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
		new LijnStuk(null, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
		new LijnStuk(punt1, null);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		assertFalse(lijnStuk.equals(null));
	}
	
	@Test
	public void omhullende_is_juist(){
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
		int x = Math.min(lijnstuk.getStartPunt().getX(), lijnstuk.getEindPunt().getX());
		int y = Math.min(lijnstuk.getStartPunt().getY(), lijnstuk.getEindPunt().getY());
		Omhullende om = new Omhullende(new Punt(x, y), Math.abs(lijnstuk.getStartPunt().getX() - lijnstuk.getEindPunt().getX()),Math.abs(lijnstuk.getStartPunt().getY() - lijnstuk.getEindPunt().getY()));
		assertEquals(om, lijnstuk.getOmhullende());
	}
}
	
