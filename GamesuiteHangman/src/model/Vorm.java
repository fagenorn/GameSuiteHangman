package model;

import ui.interfaces.Drawable;

public abstract class Vorm implements Drawable{
	public abstract boolean equals(Object o);
	public abstract Omhullende getOmhullende();
	public abstract String  toString();
}
