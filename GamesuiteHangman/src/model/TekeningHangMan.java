package model;

import domain.DomainException;

public class TekeningHangMan extends Tekening{
	private final static int minimumZichtbaar = 4;
	
	private int aantalZichtbaar;

	public int getAantalZichtbaar() {
		return aantalZichtbaar;
	}

	public void setAantalZichtbaar(int aantalZichtbaar) {
		if(aantalZichtbaar > getAantalVormen()){
			throw new DomainException("foute index: " + aantalZichtbaar + "/"+getAantalVormen());
		}
		this.aantalZichtbaar = aantalZichtbaar;
	}

	public TekeningHangMan(String naam) {
		super(naam);
		
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		
		super.voegToe(galgBodem);
		super.voegToe(galgStaaf);
		super.voegToe(hangbar);
		super.voegToe(koord);
		super.voegToe(hoofd);
		super.voegToe(oogLinks);
		super.voegToe(oogRechts);
		super.voegToe(neus);
		super.voegToe(mond);
		super.voegToe(lijf);
		super.voegToe(beenLinks);
		super.voegToe(beenRechts);
		super.voegToe(voetLinks);
		super.voegToe(voetRechts);
		super.voegToe(armLinks);
		super.voegToe(armRechts);
		super.voegToe(handLinks);
		super.voegToe(handRechts);
		setZichtbaar(minimumZichtbaar);
	}
	
	public int getAantalOnzichtbaar(){
		return getAantalVormen() - getAantalZichtbaar() ;
	}
	
	public void setVolgendeZichtbaar(){
		setAantalZichtbaar(getAantalZichtbaar()+1);
		getVorm(getAantalZichtbaar()-1).setZichtbaarheid(true);
		
	}
	
	public void reset(){
		setZichtbaar(minimumZichtbaar);
		
	}
	
	public void setZichtbaar(int index){
		if(index > getAantalVormen()){
			throw new DomainException("foute index: " + index + "/"+getAantalVormen());
		}
		if(index > getAantalZichtbaar()){
			for(int i=aantalZichtbaar;i<index;i++){
				getVorm(i).setZichtbaarheid(true);
			}
		}else{
			for(int i=aantalZichtbaar-1;i >= index;i--){
				getVorm(i).setZichtbaarheid(false);
			}
		}
		setAantalZichtbaar(index);
	}
	
	@Override
	public void voegToe(Vorm v){
		throw new DomainException("Er mogen geen vormen aan Hangman toegevoegd worden.");
	}
	
	@Override
	public void verwijder(Vorm v){
		throw new DomainException("Er mogen geen vormen van Hangman verwijderd worden.");
	}
}
