package instantInsanity;
//    |5|
//  |1|2|3|4|
//    |6|

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO Voir comment représenter les cubes et leur position

public class Cube {

    //Couleur de chaque face
    public ArrayList<Integer> faces;

    /**
     * Assignation des valeur fournie sur chaque face du cube
     * @param values listes des couleurs sur chaque face en respectant l'ordre donnée
     */
    public Cube(List<Integer> values){
        this.faces = new ArrayList<>(values);
    }

    /**
     * Assigne aléatoirement la valeur des faces
     * @param n nombre de couleurs
     */
    public Cube(int n){
        this.faces = new ArrayList<>(6);
        Random rand = new Random();
        for (int i = 0; i < 6; ++i){
            // bound exclusive
            this.faces.add(rand.nextInt(n));
        }
    }

    @Override
    public String toString() {
        return this.faces.toString();
    }
}
