package model;

public class Cirkel {

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
	
	public boolean equals(Cirkel cirkel){
		return this.getRadius() == cirkel.getRadius() && this.getMiddelpunt().equals(cirkel.getMiddelpunt());
	}
	
	public String toString(){
		return "Cirkel: middelPunt: "+ getMiddelpunt() +" - straal: " +getRadius();
	}
	
	
}
