
import java.util.ArrayList;

public class IndivListe {
    private ArrayList<Individu> indivListe;

    public IndivListe() {
        this.indivListe=new ArrayList<Individu>();
    }

    public void ajoute(Individu indiv) {
        indivListe.add(indiv);
    }

    public ArrayList<Individu> transformeEnArrayList() {
        ArrayList<Individu> li=new ArrayList<Individu>();
        for (Individu ind:indivListe) {
            li.add(ind);
        }
        return li;
    }

    public String toString() {
        String ret="";
        for (Individu indiv:indivListe) {
            ret+=indiv.toString()+"\n";
        }
        return ret;
    }
}
