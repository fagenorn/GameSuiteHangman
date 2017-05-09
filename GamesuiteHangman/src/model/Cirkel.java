package model;

public class Cirkel {

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
	
	public boolean equals(Cirkel cirkel){
		return this.getRadius() == cirkel.getRadius() && this.getMiddelpunt().equals(cirkel.getMiddelpunt());
	}
	
	public String toString(){
		return "Cirkel: middelPunt: "+ getMiddelpunt().toString()+" - straal: " +getRadius();
	}
	
	
}
