package domain;

public class Speler {
	private String naam;
	private int score;

	public Speler(String naam) {
		setNaam(naam);
		setScore(0);
	}

	public void addToScore(int score) {
		if(this.score + score < 0){
			throw new DomainException("Score mag niet negatief worden !");
		}
		this.score += score;
	}

	public boolean equals(Object object){
		if(object instanceof Speler){
			Speler o = (Speler) object;
			if(this.getNaam().equals(o.getNaam()) && this.getScore() == o.getScore()){
				return true;
			}
		}
		return false;
		
	}
	
	public String toString(){
		return getNaam() + " heeft als score: " + getScore();
		
	}
	
	
	// GETTERS SETTERS
	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Naam mag niet leeg zijn !");
		}
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		if (score < 0) {
			throw new DomainException("Score mag niet kleiner zijn als 0 !");
		}
		this.score = score;
	}

}
