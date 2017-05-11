package model;

import java.awt.Graphics;

import domain.DomainException;

public class LijnStuk extends Vorm{
	private Punt startPunt;
	private Punt eindPunt;

	public LijnStuk(Punt startPunt, Punt Eindpunt) {

		setStartEnEindPunt(startPunt, Eindpunt);

	}

	// SETTERS
	private void setStartEnEindPunt(Punt start, Punt eind) {
		if (start == null || eind == null || start == eind) {
			throw new DomainException("Punten mogen niet leeg zijn !");
		}
		this.startPunt = start;
		this.eindPunt = eind;
	}

	// GETTERS
	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}

	public String toString(){
		return "Lijn: startpunt: "+getStartPunt()+" - " + getEindPunt() + " - " + getOmhullende();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof LijnStuk) {
			LijnStuk new_name = (LijnStuk) o;
			if(this.getEindPunt().equals(new_name.getEindPunt()) || this.getEindPunt().equals(new_name.getStartPunt())){
				if(this.getStartPunt().equals(new_name.getEindPunt()) || this.getStartPunt().equals(new_name.getStartPunt())){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Omhullende getOmhullende() {
		// TODO Auto-generated method stub
		int x = Math.min(getStartPunt().getX(), getEindPunt().getX());
		int y = Math.min(getStartPunt().getY(), getEindPunt().getY());
		return new Omhullende(new Punt(x, y), Math.abs(getStartPunt().getX() - getEindPunt().getX()),Math.abs(getStartPunt().getY() - getEindPunt().getY()));
	}

	@Override
	public void teken(Graphics g) {
		if(isZichtbaar()){
			g.drawLine(getStartPunt().getX(),getStartPunt().getY(),getEindPunt().getX(),getEindPunt().getY());
		}
		
	}

}
