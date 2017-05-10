package ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Tekening;
import model.Vorm;

public class TekenVenster extends Canvas {
	
	private static final long serialVersionUID = 5114728115214149383L;
	
	private Tekening tekening;
	
	public TekenVenster(Tekening tekening) throws UIException {
		setTekening(tekening);
		this.setPreferredSize(new Dimension(400,400));
		
	}

	private void setTekening(Tekening tekening) throws UIException {
		if (tekening == null) throw new UIException("Tekening mag niet null zijn.");
		this.tekening = tekening;
	}
	
	public void teken(){
		repaint();
	}
	
	public void paint(Graphics g){
		for (Vorm v: tekening.getVormen()){
			v.teken(g);
		}
		
		
	}
}
