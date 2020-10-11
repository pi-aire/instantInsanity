package instantInsanity;
/****************************/
/*   Disposition des cubes  */
/****************************/
//          |5|
//        |1|2|3|4|
//          |6|

import java.util.HashMap;
import java.util.Random;

public class Cube {

    //Orientation du cube
    public int config = 0;

    // Assignation des couleurs, clef numéro de face et couleur
    public HashMap<Integer,Integer> colorfaces;

    // Liste des positions possibles que le cube peut prendre 
    private int[][] position = {
        {1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3},{1,4,3,2},{2,1,4,3},
        {3,2,1,4},{4,3,2,1},{1,5,3,6},{5,3,6,1},{3,6,1,5},{6,1,5,3},
        {1,6,3,5},{5,1,6,3},{3,5,1,6},{6,3,5,1},{2,5,4,6},{5,4,6,2},
        {4,6,2,5},{6,2,5,4},{2,6,4,5},{5,2,6,4},{4,5,2,6},{6,4,5,2}};

    // Combinaison de couleur possible
    public int[][] colorC;

    /**
     * Assignation des valeur fournie sur chaque face du cube
     * @param values listes des couleurs sur chaque face en respectant l'ordre donnée
     */
    public Cube(int[] values){
        this.config = 0;
        this.colorfaces = new HashMap<Integer,Integer>();
        for (int i = 0; i < values.length; i++) {
            this.colorfaces.put(i+1, values[i]);
        }
        this.generateColorC();
    }

    /**
     * Assigne aléatoirement la valeur des faces
     * @param n nombre de couleurs
     */
    public Cube(int n){
        Random rand = new Random();
        for (int i = 1; i <= 6; ++i){
            // bound exclusive
            this.colorfaces.put(i,rand.nextInt(n));
        }
        this.generateColorC();
    }

    /**
     * Realisation d'une rotation du cube
     * @return le cube
     */
    public Cube rotation(){
        this.config = (this.config + 1) % this.position.length;
        return this;
    }

    /**
     * Réalisation d'une rotation du cube dans une configuration précise
     * @param c la configuration choisie
     * @return le cube
     */
    public Cube rotation(int c){
        this.config = c;
        return this;
    }
    
    /**
     * Génère la liste des combinaisons des couleurs possibles
     */
    public void generateColorC(){
        this.colorC = new int[this.position.length][4];
        for (int i = 0; i < this.position.length; i++) {
            int[] colorConfig = new int[4];
            for (int j = 0; j < 4; j++) {
                colorConfig[j] = this.colorfaces.get(this.position[i][j]);
            }
            this.colorC[i] = colorConfig;
        }
    }
    
    /**
     * Retourne la couleur de la face demandée
     * @param configu configuration du cube
     * @param face numéro de la face
     * @return
     */
    public int getColor(int configu, int face){
        return this.colorfaces.get(this.position[configu][face]);
    }

    /**
     * 
     * @return couleur de la face avant
     */
    public int getFC(){
        return this.colorfaces.get(this.position[this.config][1]);
    }

    /**
     * 
     * @return couleur de la face arrière
     */
    public int getBC(){
        return this.colorfaces.get(this.position[this.config][3]);
    }

    /**
     * 
     * @return couleur de la face gauche
     */
    public int getLC(){
        return this.colorfaces.get(this.position[this.config][0]);
    }

    /**
     * 
     * @return couleur de la face droite
     */
    public int getRC(){
        return this.colorfaces.get(this.position[this.config][2]);
    }

    @Override
    public String toString() {
        return this.position[this.config].toString();
    }
    public String toString(int c) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            st.append(""+ getColor(c, i));
        }
        return st.toString();
    }

}
