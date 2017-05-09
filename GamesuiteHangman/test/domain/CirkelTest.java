package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Cirkel;
import model.Punt;

public class CirkelTest {

	@Test
	public void CirkelMetGeldigMiddelpunt() {
		Punt punt = new Punt(2,2);
		Cirkel cirkel = new Cirkel(punt, 2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void CirkelMetMiddelpuntNull() {
		Cirkel cirkel = new Cirkel(null, 2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void CirkelMetStraalKkleinerNul() {
		Punt punt = new Punt(2,2);
		Cirkel cirkel = new Cirkel(punt, -2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void CirkelMetStraalNul() {
		Punt punt = new Punt(2,2);
		Cirkel cirkel = new Cirkel(punt, 0);
	}

	@Test
	public void TweeGelijkeCirkels() {
		Punt punt = new Punt(2,2);
		Cirkel cirkel = new Cirkel(punt, 2);
		Cirkel cirkel2 = new Cirkel(punt, 2);
		assertTrue(cirkel.equals(cirkel2));
	}

	@Test
	public void TweeVerschillendeCirkels() {
		Punt punt = new Punt(2,2);
		Punt punt2 = new Punt(3,3);
		Cirkel cirkel = new Cirkel(punt, 2);
		Cirkel cirkel2 = new Cirkel(punt, 3);

		Cirkel cirkel3 = new Cirkel(punt2, 2);
		assertFalse(cirkel.equals(cirkel2));
		assertFalse(cirkel.equals(cirkel3));
	}

}
