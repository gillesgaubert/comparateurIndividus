
import java.util.Comparator;

public class SortByYeux implements Comparator<Individu> {
	// utilise pour ordonner en ordre ascendant de couleur d yeux
	
	public double conversionCouleur(String coul) {
		// extraire de la valeur rgb le niveau de saturation
		// on classerera les couleurs par niveau de clarté
		int r,v,b;

		switch (coul) {
			case "marron": {
				r=88; v=41; b=0; break;
			}
			case "vert": {
				r=58; v=137; b=49; break;
			}
			case "bleu": {
				r=119; v=181; b=254; break;
			}
			case "noisette": {
				r=137; v=72; b=6; break;
			}
			case "gris": {
				r=180; v=180; b=180; break;
			}
			default : {
				r=88; v=41; b=0;	//marron
			}
		}
		return (Math.sqrt((0.241*r*r) + (0.691*v*v) + (0.068*b*b)));
	}
	
	public int compare(Individu indA, Individu indB) { 
		int ia,ib;
		ia=(int)conversionCouleur(indA.getYeux());
		ib=(int)conversionCouleur(indB.getYeux());
		return ia-ib; 
	} 
}
