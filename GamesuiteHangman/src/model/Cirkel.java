package model;
import model.Vorm;

public class Cirkel extends Vorm {

	private int radius;
	private Punt middelpunt;
	public Cirkel(Punt punt, int i) {
		
	}
	public int getRadius() {
		return radius;
	}
	private void setRadius(int radius) {
		this.radius = radius;
	}
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	private void setMiddelpunt(Punt middelpunt) {
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
		return "Cirkel: middelPunt: "+ getMiddelpunt().toString()+" - straal: " +getRadius();
	}
	
	
}
