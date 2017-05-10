package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Tekening;
import model.Vorm;

public class TekenVenster extends JPanel {
	
	private static final long serialVersionUID = 5114728115214149383L;
	
	private Tekening tekening;
	
	public TekenVenster(Tekening tekening) {
		this.tekening = tekening;
		
	}
	
	public void teken(){
		
	}
	
	public void paint(Graphics g){
		for (Vorm v: tekening.getVormen()){
			v.teken(g);
		}
		
		
	}
}
