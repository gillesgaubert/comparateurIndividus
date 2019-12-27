
public class Individu {
	private int taille;
	private int poids;
	private String prenom;
	private String yeux;
	private String origine;
	private double score;
	
	// constructeur
	
	public Individu(int taille, int poids, String prenom, String yeux,
		String origine) {
		this.taille=taille;
		this.poids=poids;
		this.prenom=prenom;
		this.yeux=yeux;
		this.origine=origine;
		this.score=0;
	}
	
	// getters
	
	public int getTaille() {
		return taille;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getYeux() {
		return yeux;
	}
	
	public String getOrigine() {
		return origine;
	}

	public double getScore() { return score; }
	
	// setters
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setYeux(String yeux) {
		this.yeux = yeux;
	}
	
	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public void setScore(double score) { this.score=score; }
	
	// pour afficher les details d'un individu
	
	public String toString() { 
		return this.prenom + " est de taille " + this.taille + 
			", de poids " + this.poids + ", a les yeux " +
			this.yeux + " et vient de " + this.origine + ", score = " +
				this.score;
	}

	// pour calculer le score par la distance avec les autre individus

	public void calcScore(int pos,int ref,int poids) {
		this.score+=((double)1/(Math.abs(pos-ref)+1))*poids;
	}
}
