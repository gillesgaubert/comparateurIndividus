
import java.util.Comparator;

public class SortByPoids implements Comparator<Individu>{
	
	// utilise pour ordonner en ordre ascendant de poids
	
	public int compare(Individu indA, Individu indB) { 
		return indA.getPoids() - indB.getPoids(); 
	} 
}

