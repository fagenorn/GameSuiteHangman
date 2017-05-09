package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import model.Cirkel;
import model.Punt;

public class UI {
	
	private final Speler speler;
	
	public UI(Speler s){
		speler = s;
	}
	
	public void load(){
		cirkel(punt());
	}

	private Punt punt() {
		do{
		String xString = JOptionPane.showInputDialog("x coordinaat van het punt");
		String yString = JOptionPane.showInputDialog("y coordinaat van het punt");
		
		try{
			int x = Integer.parseInt(xString);
			int y = Integer.parseInt(yString);
			Punt p = new Punt(x, y);
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: ("+p.getX() +", " + p.getY()+")");
			return p;
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Dit is geen correct punt.");
		}
		}while (true);
		
		
	}
	
	private void cirkel(Punt p){
		try{
			int radius = Integer.parseInt(JOptionPane.showInputDialog("Geef de straal van de cirkel"));
			Cirkel cirkel = new Cirkel(p,radius);
			JOptionPane.showMessageDialog(null,cirkel.toString());
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Dit is geen correte straal."); 
		
		
	}

}}

