package model;

import domain.DomainException;

public class Driehoek extends Vorm{

	public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
		setHoekPunt(punt1, punt2, punt3);
	}

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public void setHoekPunt(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			throw new DomainException("Punten mogen niet leeg zijn");
		}

		if (isOpZelfdeLijnstuk(hoekPunt1, hoekPunt2, hoekPunt3)) {
			throw new DomainException("Punten mogen niet op zelde lijnstuk");
		}

		this.hoekPunt1 = hoekPunt1;
		this.hoekPunt2 = hoekPunt2;
		this.hoekPunt3 = hoekPunt3;
	}

	private boolean isOpZelfdeLijnstuk(Punt x, Punt y, Punt z) {
		return (y.getX() - x.getX()) * (z.getY() - x.getY()) == (z.getX() - x.getX()) * (y.getY() - x.getY());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) obj;
			return this.hasPoint(driehoek.getHoekPunt1()) && this.hasPoint(driehoek.getHoekPunt2())
					&& this.hasPoint(driehoek.getHoekPunt3());
		}
		return false;
	}

	public boolean hasPoint(Punt punt) {
		return hoekPunt1.equals(punt) || hoekPunt2.equals(punt) || hoekPunt3.equals(punt);
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}
	
	public String toString(){
		return String.format("Driehoek: hoekpunt1: {0} - hoekpunt2: {1} - hoekpunt3: {2} - {3}", getHoekPunt1(), getHoekPunt2(), getHoekPunt3(), getOmhullende());
	}

	public Omhullende getOmhullende() {
		int x_min = Math.min(getHoekPunt1().getX(), Math.min(getHoekPunt2().getX(), getHoekPunt3().getX()));
		int y_min = Math.min(getHoekPunt1().getY(), Math.min(getHoekPunt2().getY(), getHoekPunt3().getY()));
		int x_max = Math.max(getHoekPunt1().getX(), Math.max(getHoekPunt2().getX(), getHoekPunt3().getX()));
		int y_max = Math.max(getHoekPunt1().getY(), Math.max(getHoekPunt2().getY(), getHoekPunt3().getY()));
		return new Omhullende(new Punt(x_min,y_min),x_max-x_min,y_max-y_min);
	}
}
