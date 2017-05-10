package model;

import java.util.ArrayList;

import domain.DomainException;

public class Tekening {
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	private ArrayList<Vorm> vormen = new ArrayList<>();

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("");
		}
		this.naam = naam;
	}

	public Tekening(String naam) {
		setNaam(naam);

	}

	public void voegToe(Vorm vorm) {
		if (vorm == null || vormen.contains(vorm)) {
			throw new DomainException("vorm bestaat al");
		}

		if (vorm.getOmhullende().getMinimumX() < MIN_X || vorm.getOmhullende().getMaximumX() > MAX_X
				|| vorm.getOmhullende().getMinimumY() < MIN_Y || vorm.getOmhullende().getMaximumY() > MAX_Y) {
			throw new DomainException("vorm ligt buiten tekening");
		}

		vormen.add(vorm);
	}

	public Vorm getVorm(int index){
		return vormen.get(index);
	}
	public int getAantalVormen(){
		return vormen.size();
	}
	public void verwijder(Vorm vorm){
		vormen.remove(vorm);
	}
	public boolean bevat(Vorm vorm){
		return vormen.contains(vorm) ? true : false;
	}
	public String toString(){
		String result = "Tekening met naam " + getNaam() + " bestaat uit " + getAantalVormen() + "vormen:";
		for (Vorm vorm : vormen){
			result += "\n" + vorm.toString();
		}
		return result;
	}
	public boolean equals(Object o){
		if (o instanceof Tekening){
			Tekening tekening = (Tekening) o;
			if (this.naam == tekening.getNaam()){
				return true;
			}
		}
		return false;
	}

}
