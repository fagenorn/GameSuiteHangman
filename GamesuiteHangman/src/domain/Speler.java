package domain;

public class Speler {
	private String naam;
	private int score;

	public Speler(String naam) {
		setNaam(naam);
		setScore(0);
	}

	public void addToScore(int score) {
		if(score < 0){
			throw new IllegalArgumentException();
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
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		if (score < 0) {
			throw new IllegalArgumentException();
		}
		this.score = score;
	}

}
