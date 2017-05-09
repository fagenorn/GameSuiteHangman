package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import model.Punt;

public class UI {
	
	private final Speler speler;
	
	public UI(Speler s){
		speler = s;
	}
	
	public void load(){
		String xString = JOptionPane.showInputDialog("x coordinaat van het punt");
		String yString = JOptionPane.showInputDialog("y coordinaat van het punt");
		try{
			int x = Integer.parseInt(xString);
			int y = Integer.parseInt(yString);
			Punt p = new Punt(x, y);
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: ("+p.getX() +", " + p.getY()+")");
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Dit is geen correct punt.");
		}
	}

}
