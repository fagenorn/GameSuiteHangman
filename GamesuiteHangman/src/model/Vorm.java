package model;

import ui.interfaces.Drawable;

public abstract class Vorm implements Drawable{
	private boolean zichtbaar;
	public abstract boolean equals(Object o);
	public abstract Omhullende getOmhullende();
	public abstract String  toString();
	
	public Vorm(){
		setZichtbaarheid(false);
	}
	
	public boolean isZichtbaar(){
		return zichtbaar;
	}
	public void setZichtbaarheid(boolean z){
		zichtbaar = z;
	}
}
