

public class Coordonnees {
    private String nom;
    private double latitude;
    private double longitude;

    public Coordonnees(String nom, int latitude, int longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNom() { return this.nom; }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String toString() {
        return this.nom+" lat =" + this.latitude + ", long =" + this.longitude;
    }
}