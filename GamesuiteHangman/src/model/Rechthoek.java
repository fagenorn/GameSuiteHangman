package model;

import java.awt.Graphics;

import domain.DomainException;

public class Rechthoek extends Vorm{
	
	private Punt linkerboven;
	private int breedte;
	private int lengte;
	
	public Rechthoek(Punt p, int b, int l){
		setLinkerBovenhoek(p);
		setBreedte(b);
		setHoogte(l);
	}

	private void setHoogte(int l) {
		if(l <= 0){
			throw new DomainException("Hoogte mag niet 0 zijn.");
		}
		lengte = l;
	}

	private void setBreedte(int b) {
		if(b <= 0){
			throw new DomainException("Breedte mag niet 0 zijn.");
		}
		breedte = b;
	}

	private void setLinkerBovenhoek(Punt p) {
		if(!(p instanceof Punt)){
			throw new DomainException("Punt mag niet null zijn.");
		}
		linkerboven = p;
	}

	public int getHoogte() {
		return lengte;
	}

	public int getBreedte() {
		return breedte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerboven;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Rechthoek){
			Rechthoek r = (Rechthoek) o;
			return getLinkerBovenhoek().equals(r.getLinkerBovenhoek()) && getHoogte() == r.getHoogte() && getBreedte() == r.getBreedte();
		}
		return false;
	}
	
	public String toString(){
		return "Rechthoek: Positie: "+getLinkerBovenhoek()+" - Breedte: "+getBreedte()+" - Hoogte: "+getHoogte() + " " + getOmhullende();
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(getLinkerBovenhoek(),getBreedte(),getHoogte());
	}

	@Override
	public void teken(Graphics g) {

		g.drawRect(getLinkerBovenhoek().getX(),getLinkerBovenhoek().getY(), getBreedte(), getHoogte());	
	}

}
