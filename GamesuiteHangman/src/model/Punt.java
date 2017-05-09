package model;

public class Punt {
	
	private int x;
	private int y;
	
	public Punt(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean equals(Object o){
		if(o instanceof Punt){
			Punt p = (Punt) o;
			return getX() == p.getX() && getY() == p.getY();
		}
		return false;
	}
}
