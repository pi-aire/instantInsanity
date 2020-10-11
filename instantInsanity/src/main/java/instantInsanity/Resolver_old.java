package instantInsanity;

import java.util.Arrays;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class Resolver_old {
    
    Instance instance;

    public Resolver_old(Instance inst){
        this.instance = inst;

    }

    public void start(){
        Model model = new Model();
        // Création des variables
        // chaque variable représente une position d'un cube
        // IntVar[] cubePs = new IntVar[this.instance.n];
        // for (int i = 0; i < this.instance.n; i++) {
        //     cubePs[i] = model.intVar("Cube_T"+(i+1),0,23);
        // }

        // Les variables représentant les combinaisons.
        IntVar[][] cubeCCs = new IntVar[this.instance.n][];
        for (int i = 0; i < this.instance.n; i++) {
            cubeCCs[i] = new IntVar[24];
            for (int j = 0; j < 24; j++) {
                cubeCCs[i][j] = model.intVar("Cube_"+(i+1)+"_conf"+(j+1),0,1);
            }
        }
        // Contraintes
        // int[][] colorFace = new int[4][];
        // // On génère les valeurs de contrainte
        // for (int j = 0; j < this.instance.n; j++) {
        //     Cube tmp = this.instance.getCube(j).rotation(cubePs[j].getValue());
        //     colorFace[0][j] = tmp.getFC();
        //     colorFace[1][j] = tmp.getBC();
        //     colorFace[2][j] = tmp.getLC();
        //     colorFace[3][j] = tmp.getRC();
        // }
        // model.allDifferent(model.incolorFace[0]).post();
        
        // Contraintes

        // Ces contraintes permettent de verifier 
        // si un cube n'a pas +ieur config à la fois
        for (int i = 0; i < cubeCCs.length; i++) {
            model.sum(cubeCCs[i],"=",1).post();
        }

        //On regarde si chaque face de la pile possède des couleurs différentes
        for (int f = 0; f < 4; f++){

            for (int i = 0; i < this.instance.n; i++) {
                for (int j = i+1; j < this.instance.n; j++) {
                    
                }
            }
        }
        Solution solution = model.getSolver().findSolution();
        if (solution != null){
            System.out.println(solution.toString());
        }
    }
}
