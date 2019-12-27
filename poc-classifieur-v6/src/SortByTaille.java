import java.util.Comparator;

public class SortByTaille implements Comparator<Individu> {
	
	// utilise pour ordonner en ordre ascendant de taille
	
	public int compare(Individu indA, Individu indB) { 
		return indA.getTaille() - indB.getTaille(); 
	} 
}
