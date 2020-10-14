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
        this.cubes = new ArrayList<Cube>();
        for (int i = 0; i < n; i++) {
            this.cubes.add(new Cube(n));
        }
        this.n = n;
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
