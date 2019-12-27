import java.util.ArrayList;

public class CoordListe {
    private ArrayList<Coordonnees> coordListe;

    public CoordListe() {
        this.coordListe=new ArrayList<Coordonnees>();
    }

    public void ajoute(Coordonnees coord) {
        coordListe.add(coord);
    }


    public ArrayList<Coordonnees> transformeEnArrayList() {
        ArrayList<Coordonnees> li=new ArrayList<Coordonnees>();
        for (Coordonnees coord:coordListe) {
            li.add(coord);
        }
        return li;
    }

    public String toString() {
        String ret="";
        for (Coordonnees co:coordListe) {
            ret+=co.toString()+"\n";
        }
        return ret;
    }
}
