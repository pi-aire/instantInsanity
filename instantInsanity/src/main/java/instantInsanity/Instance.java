package instantInsanity;

import java.util.ArrayList;
import java.util.List;

public class Instance {
    List<Cube> cubes;
    public int n;
    /**
     * Creation d'une instance avec des valeurs aléatoires
     * @param n nombre de couleur et nombre de cube
     */
    public Instance(int n){
        do {
            this.cubes = new ArrayList<Cube>();
            for (int i = 0; i < n; i++) {
                this.cubes.add(new Cube(n));
            }
        } while (!this.viableInstance());
        this.n = n;
        System.out.println("L'instance générée est prète");
    }
    
    /**
     * Création d'une instance avec une assignation des couleur sur chaque cube
     * @param cubesAssignation tableau contenant la liste des couleurs pour chaque cubes 
     */
    public Instance(List<int[]> cubesAssignation){
        this.cubes = new ArrayList<Cube>();
        for (int[] cubeColor : cubesAssignation) {
            this.cubes.add(new Cube(cubeColor));
        }
        this.n = this.cubes.size();
    }

    /**
     * Verifie si le modèle est réalisable pour les configuration basique
     * C'est-à-dire pas au moins 4 fois la même couleurs
     * @return
     */
    public boolean viableInstance(){
        
        // POur chaque couleur on verifie s'il y en à 4 par instance
        int[] counter = new int[this.n];
        for (int j = 0; j < this.n; j++) {
            //ON parcour les face des cubes
            for (Integer color : this.cubes.get(j).colorfaces.values()) {
                counter[color] += 1;
            }
        }
        for (int i : counter) {
            if (i < 4){
                return false;
            }
        }
        return true;
    }

    /**
     * @param indexCube numéro du cube
     * @return le cube voulu
     */
    public Cube getCube(int indexCube){
        return cubes.get(indexCube);
    }
    
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (Cube cube : cubes) {
            tmp.append(cube.toString());
        }
        return tmp.toString();
    }
}
