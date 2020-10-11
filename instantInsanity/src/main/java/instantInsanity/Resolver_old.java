package instantInsanity;

import java.beans.Expression;
import java.util.Arrays;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression;
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
        // Ces contraintes permettent de verifier 
        // si un cube n'a pas +ieur config à la fois
        for (int i = 0; i < cubeCCs.length; i++) {
            model.sum(cubeCCs[i],"=",1).post();
        }

        //On regarde si chaque face de la pile possède des couleurs différentes
        // On construit d'abord les expressions
        IntVar[][] expressions = new IntVar[4][this.instance.n];
        for (int f = 0; f < 4; f++){
            for (int i = 0; i < this.instance.n; i++) {
                Cube tmpc = this.instance.cubes.get(i);
                ArExpression expr = cubeCCs[i][0].mul(tmpc.getColor(0, f)); 
                for (int j = 1; j < 24; j++) {
                    // System.out.println(tmpc.toString(j));
                    expr.add(cubeCCs[i][j].mul(tmpc.getColor(j, f))); 
                }
                expressions[f][i] = expr.intVar();
            }
        }

        // On réalise les contraintes
        for (int f = 0; f < 4; f++){
            model.allDifferent(expressions[f]).post();
        }
        System.out.println(model.getNbCstrs());
        Solution solution = model.getSolver().findSolution();
        if (solution != null){
            System.out.println(solution.toString());
        }else{
            System.out.println("Pas de solution/bug");
        }
    }
}
