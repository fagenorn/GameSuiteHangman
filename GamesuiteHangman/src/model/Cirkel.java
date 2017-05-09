package model;
import model.Vorm;

public class Cirkel extends Vorm {

	private int radius;
	private Punt middelpunt;
	public Cirkel(Punt punt, int i) {
		setRadius(i);
		setMiddelpunt(punt);
		
	}
	public int getRadius() {
		return radius;
	}
	private void setRadius(int radius) {
		if(radius <= 0){
			throw new IllegalArgumentException();
		}
		this.radius = radius;
	}
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	private void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null){
			throw new IllegalArgumentException();
		}
		this.middelpunt = middelpunt;
	}
	
	@Override
	public boolean equals(Object cirkel){
		if (cirkel instanceof Cirkel){
			Cirkel c = (Cirkel) cirkel;
			return this.getRadius() == c.getRadius() && this.getMiddelpunt().equals(c.getMiddelpunt());
		}
		return false;
	}
	
	public String toString(){
		return "Cirkel: middelPunt: "+ getMiddelpunt() +" - straal: " +getRadius();
	}
	
	
}
