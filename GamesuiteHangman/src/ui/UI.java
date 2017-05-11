package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import model.Cirkel;
import model.LijnStuk;
import model.Punt;
import model.Rechthoek;
import model.Tekening;

public class UI {
	
	private final Speler speler;
	private Tekening tekening;
	
	public UI(Speler s){
		speler = s;
	}
	
	
	
	public void load(){
		tekening = new Tekening(JOptionPane.showInputDialog("Geef de naam van je tekening:"));
		int option = 1;
		while (option != 0){
			option = Integer.parseInt(JOptionPane.showInputDialog(null, "Wat wil je doen:\n\n1.Vorm maken\n2.Tekening tonen\n\n0.Stoppen"));
		
			switch (option){
			case 1:	
				String[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk","Driehoek"};
				Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen?", "Input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
				if (keuze.equals("Cirkel")){
					tekening.voegToe(cirkel(punt()));
			
				}else if (keuze.equals("Rechthoek")){
					tekening.voegToe(rechthoek(punt()));

				}else if (keuze.equals("Lijnstuk")){
					tekening.voegToe(lijnstuk(punt(),punt()));
				}else if (keuze.equals("Driehoek")){
					tekening.voegToe(lijnstuk(punt(),punt()));
				}
				break;
			case 2:
				GameMainWindow view;
				tekening.zetZichtbaarheid(true);
				try {
					view = new GameMainWindow(speler.getNaam(), tekening);
					view.setVisible(true);
					view.teken();
				} catch (UIException e) {
					
				}
				
				break;
			}
		}
		System.exit(0);
		
		
	}

	private LijnStuk lijnstuk(Punt beginPunt, Punt eindPunt) {
		while(true){
			LijnStuk lijnstuk = new LijnStuk(beginPunt,eindPunt);
			JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaakt: " + lijnstuk.toString());
			return lijnstuk;
		}
		
	}



	private Rechthoek rechthoek(Punt p) {
		while (true){
			int breedte = 0;
			int lengte = 0;
			
			try{
				breedte = Integer.parseInt(JOptionPane.showInputDialog("Geef de breedte van de rechthoek."));
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Dit is geen correcte breedte."); 
			}	
			try{
				lengte = Integer.parseInt(JOptionPane.showInputDialog("Geef de lengte van de rechthoek."));
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Dit is geen correcte lengte."); 
			}	
		
				Rechthoek rechthoek = new Rechthoek(p, breedte, lengte);
				JOptionPane.showMessageDialog(null,"U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString());
				return rechthoek;}
			
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
	
	private Cirkel cirkel(Punt p){
		
		while (true){
		try{
			int radius = Integer.parseInt(JOptionPane.showInputDialog("Geef de straal van de cirkel"));
			Cirkel cirkel = new Cirkel(p,radius);
			JOptionPane.showMessageDialog(null,"U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
			return cirkel;
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Dit is geen correcte straal."); 
		}		
	}

	}
}

