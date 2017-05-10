package model;

import java.util.ArrayList;

import domain.DomainException;

public class WoordenLijst {
	private ArrayList<String> woorden = new ArrayList<>();
	
	public WoordenLijst() {

	}

	public int getAantalWoorden(){
		return woorden.size();
		
	}
	
	public void voegToe(String woord){
		if(woord == null || woord.trim().isEmpty() || woorden.contains(woord)){
			throw new DomainException("Woord mag niet leeg zijn !");
		}
		woorden.add(woord);
	}
	
	public String getRandomWoord(){
		int randomG = (int) Math.floor(Math.random() * woorden.size());
		if(woorden.size() == 0){
			return null;
		}
	return woorden.get(randomG);
		
		
	}
}
