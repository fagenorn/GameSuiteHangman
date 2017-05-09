package model;

import java.util.ArrayList;

import domain.DomainException;

public class Tekening{
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
		if (naam == null || naam.trim().isEmpty()){
			throw new DomainException("");
		}
		this.naam = naam;
	}
	
	public Tekening(String naam){
		setNaam(naam);
		
	}
	
	public void voegToe(Vorm vorm){
		if (vorm == null || vormen.contains(vorm)){
			throw new DomainException("");
		}
		vormen.add(vorm);
	}
	public Vorm getVorm(int index){
		return null;
	}
	public int getAantalVormen(){
		return 0;
	}
	public void verwijder(Vorm vorm){
		
	}
	public boolean bevat(Vorm vorm){
		return false;
	}
	public String toString(){
		return "";
	}
	public boolean equals(Object o){
		return false;
	}
	
	

}
