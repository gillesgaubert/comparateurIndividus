
import java.util.ArrayList;
import java.util.Comparator;

public class SortByPays implements Comparator<Individu> {
    // utilise pour ordonner en terme de pays

    private ArrayList<Coordonnees> coordListe;
    private String paysRecherche;

    public SortByPays(ArrayList<Coordonnees> coordListe, String paysRecherche) {
        this.coordListe=coordListe;
        this.paysRecherche=paysRecherche;
    }

    private double[] recupereCoords(String nomPays) {
        double[] resLatLong={0,0};
        /*System.out.println("resLatLong[0] : "+resLatLong[0]);
        System.out.println("resLatLong[1] : "+resLatLong[1]);*/

        for (Coordonnees coord:coordListe) {
            if (coord.getNom().equals(nomPays)) {
                //System.out.println("je trouve le pays : "+nomPays);
                resLatLong[0]=coord.getLatitude();
                //System.out.println("lat : "+resLatLong[0]);
                resLatLong[1]=coord.getLongitude();
                //System.out.println("long : "+resLatLong[1]);
            }
        }
        return resLatLong;
    }

    public double distanceOrigine(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        /*double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;
        double height = 0;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);*/
        double a=a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c =Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance=2*R*c*1000;
        return distance;
        //return Math.sqrt(distance);
    }

    public int compare(Individu indA, Individu indB) {

        // a chaque pays il faut associer longitude-latitude
        // de la capitale puis en deduire les distances par la formule

        double[] latLongA=recupereCoords(indA.getOrigine());
        double[] latLongB=recupereCoords(indB.getOrigine());
        double[] latLongO=recupereCoords(paysRecherche);
        /*System.out.println("Affichons les coordonnees de l origine recherchee : lat="+
                latLongO[0]+" long="+latLongO[1]);*/
        int distanceOrigineA=(int)distanceOrigine(latLongA[0],latLongO[0],latLongA[1],latLongO[1]);
        int distanceOrigineB=(int)distanceOrigine(latLongB[0],latLongO[0],latLongB[1],latLongO[1]);

        System.out.println("distance  entre "+indA.getOrigine()+" et "+paysRecherche+
                " est de "+distanceOrigineA/1000);
        System.out.println("distance  entre "+indB.getOrigine()+" et "+paysRecherche+
                " est de "+distanceOrigineB/1000);

        return distanceOrigineA-distanceOrigineB;
    }
}