package model;

import domain.DomainException;

public class Omhullende {

	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;
	
	
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		// TODO Auto-generated method stub
		return linkerBovenhoek;
	}

	public int getHoogte() {
		// TODO Auto-generated method stub
		return hoogte;
	}

	public int getBreedte() {
		// TODO Auto-generated method stub
		return breedte;
	}
	
	public boolean equals(Object o){
		if(o instanceof Omhullende){
			Omhullende om = (Omhullende) o;
			return getLinkerBovenhoek().equals(om.getLinkerBovenhoek()) && getBreedte() == om.getBreedte() && getHoogte() == om.getHoogte();
		}
		return false;
	}

	private void setHoogte(int hoogte) {
		if(hoogte < 0){
			throw new DomainException("Hoogte mag niet 0 zijn.");
		}
		this.hoogte = hoogte;
	}

	private void setBreedte(int breedte) {
		if(breedte < 0){
			throw new DomainException("Breedte mag niet 0 zijn.");
		}
		this.breedte = breedte;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if(!(linkerBovenhoek instanceof Punt)){
			throw new DomainException("Punt mag niet null zijn.");
		}
		this.linkerBovenhoek = linkerBovenhoek;
	}
	
	public String toString(){
		return "Omhullende: "+getLinkerBovenhoek()+" - "+getBreedte()+" - "+getHoogte();
	}

}
