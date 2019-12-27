
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Similarite {

	public static int positionIndividu(ArrayList<Individu> li, Individu ind) {
		int i;
		int position=0;
		for (i=0; i<li.size();i++) {
			if (ind.equals(li.get(i))) {
				position=i;
			}
		}
		return position;
	}

	public static void scoreIndividus(ArrayList<Individu> li, int indice, int poids) {
		int i;
		for (i=0; i<li.size();i++) {
			li.get(i).calcScore(i,indice,poids);
		}
	}

	public static void afficheListeIndividus(ArrayList<Individu> li) {
		for (Individu ind : li) {
			System.out.println(ind);
		}
	}

	public static void main(String[] args) {
		// pour deserialiser le json on a besoin d une instance d une classe envellope
		//IndivListe indivListe=new IndivListe();

		// on utile Gson pour recuperer la liste dans le fichier individu.json
		String contenu="";
		try{
			InputStream flux=new FileInputStream("individus.json");
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				contenu+=ligne;
			}
			buff.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println("le contenu du fichier json est : "+contenu);

		// maintenant je veux deserialiser
		Gson gson = new Gson();
		IndivListe indivListe = gson.fromJson(contenu,IndivListe.class);
		//Coordonnees co = gson.fromJson(json,Coordonnees.class);
		System.out.println("Resultat = " + indivListe);

		// on caste indivListe au type arrayList<Individu>
		ArrayList<Individu> individus;
		individus=indivListe.transformeEnArrayList();

		// on charge de la meme facon un tableau de latitude-londitude
		// entre les capitales des pays
		Gson gson2 = new Gson();
		contenu="";
		try{
			InputStream flux2=new FileInputStream("coordonnees.json");
			InputStreamReader lecture2=new InputStreamReader(flux2);
			BufferedReader buff2=new BufferedReader(lecture2);
			String ligne2;
			while ((ligne2=buff2.readLine())!=null){
				contenu+=ligne2;
			}
			buff2.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println("le contenu du fichier json est : "+contenu);

		// maintenant je veux deserialiser
		CoordListe coords = gson.fromJson(contenu,CoordListe.class);

		System.out.println("Resultat = " + coords);

		// on caste coords au type arrayList<Coordonnees>
		ArrayList<Coordonnees> coordListe;
		coordListe=coords.transformeEnArrayList();

		// ici j instancie l individu recherche et l ajoute dans la liste
		Individu individuRecherche= new Individu(180, 69, "jean", "marron", "france");
		individus.add(individuRecherche);

		// ici je decide arbitrairement de l importance des criteres de ressemblance
		// 4:important,3:necessaire,2:souhaitable,1:accessoire
		int poidsTaille=2;
		int poidsPoids=2;
		int poidsPrenom=1;
		int poidsYeux=3;
		int poidsOrigine=4;

		/*
		System.out.println("\n\n\nNon triés (individus) :");
		afficheListeIndividus(individus);
		*/

		/*
		// on copie individus puis on ordonne la liste obtenue par taille
		ArrayList<Individu> individusParTaille = new ArrayList<Individu>();
		individusParTaille.addAll(individus);
		*/

		// on trie
		Collections.sort(individus, new SortByTaille());

		/*System.out.println("\n\n\nTriés par taille (individusParTaille:");
		afficheListeIndividus(individus);*/

		// je recherche l indice de l individu recherche
		int indiceIndRech;
		indiceIndRech=positionIndividu(individus,individuRecherche);

		// je calcule le score par la distance qui separe
		// chaque element de celui recherche et met a jour l attribut score
		scoreIndividus(individus,indiceIndRech,poidsTaille);

		System.out.println("\n\n\nApres tri / taille et calcul du score:");
		afficheListeIndividus(individus);

		// on fait pareil avec le poids
		Collections.sort(individus, new SortByPoids());
		indiceIndRech=positionIndividu(individus,individuRecherche);
		scoreIndividus(individus,indiceIndRech,poidsPoids);
		System.out.println("\n\n\nApres tri / poids et calcul du score:");
		afficheListeIndividus(individus);

		// on fait pareil avec le prenom
		Collections.sort(individus, new SortByPrenom(individuRecherche.getPrenom()));
		indiceIndRech=positionIndividu(individus,individuRecherche);
		scoreIndividus(individus,indiceIndRech,poidsPrenom);
		System.out.println("\n\n\nApres tri / prenom et calcul du score:");
		afficheListeIndividus(individus);

		// on fait pareil avec la couleur des yeux
		Collections.sort(individus, new SortByYeux());
		indiceIndRech=positionIndividu(individus,individuRecherche);
		scoreIndividus(individus,indiceIndRech,poidsYeux);
		System.out.println("\n\n\nApres tri / couleur des yeux et calcul du score:");
		afficheListeIndividus(individus);

		// on fait pareil avec l origine
		Collections.sort(individus, new SortByPays(coordListe,individuRecherche.getOrigine()));
		indiceIndRech=positionIndividu(individus,individuRecherche);
		scoreIndividus(individus,indiceIndRech,poidsOrigine);
		System.out.println("\n\n\nApres tri / origine et calcul du score:");
		afficheListeIndividus(individus);

		// finalement on trie par score...
		Collections.sort(individus, new SortByScore());
		System.out.println("\n\n\nFinalement, par ordre de ressemblance :");
		afficheListeIndividus(individus);

		Individu leSosie=individus.get(1);
		System.out.println("\n\n\nFinalement, l'individu le plus proche de john est : "
				+leSosie.getPrenom());
		System.out.println("Avec une ressemblance de : "
				+(leSosie.getScore()/11)*100+" %");
	}
}

