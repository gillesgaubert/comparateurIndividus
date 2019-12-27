
import java.util.Comparator;

public class SortByScore implements Comparator<Individu> {

    // utilise pour ordonner en ordre ascendant de score
    public int compare(Individu indA, Individu indB) {
        return (int)((indB.getScore() - indA.getScore())*10000);
    }
}
