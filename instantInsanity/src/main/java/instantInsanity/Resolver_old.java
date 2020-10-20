package instantInsanity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.assignments.DecisionOperator;
import org.chocosolver.solver.search.strategy.assignments.DecisionOperatorFactory;
import org.chocosolver.solver.search.strategy.decision.Decision;
import org.chocosolver.solver.search.strategy.decision.IntDecision;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.search.strategy.strategy.AbstractStrategy;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.PoolManager;

public class Resolver_old {
    
    Instance instance;

    public Resolver_old(Instance inst){
        this.instance = inst;

    }

    public List<Integer> start(){
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
                    expr = expr.add(cubeCCs[i][j].mul(tmpc.getColor(j, f))); 
                }
                expressions[f][i] = expr.intVar();
            }
        }

        // On réalise les contraintes
        for (int f = 0; f < 4; f++){
            model.allDifferent(expressions[f]).post();
        }
        System.out.println(model.getNbCstrs());
        // model.getSolver().setSearch(Search.intVarSearch(
        //     // variable selector
        //     (VariableSelector<IntVar>) variables -> {
        //         List<IntVar> list = new ArrayList<IntVar>();
        //         for(IntVar v: variables){
        //             if(!v.isInstantiated()){
        //                 list.add(v);
        //             }
        //         }
        //         return list.stream().min((v1, v2) -> 
        //             distance(instance.n, v2, expressions) - distance(instance.n,v1, expressions)
        //         )
        //     },
        //     // value selector
        //     (IntValueSelector) var -> var.getLB()
        // ));
        
        // Le timeOut est paramétré 
        model.getSolver().limitTime("10m");
        // Démarrage de la résolution
        Solution solution = model.getSolver().findSolution();
        if (solution != null){
            model.getSolver().printStatistics();
            List<Integer> configuration = new ArrayList<Integer>();
            for (int i = 0; i < this.instance.n; i++) {
                for (int j = 0; j < 24; j++) {
                    if (solution.getIntVal(cubeCCs[i][j]) == 1){
                        configuration.add(j);
                        break;
                    }
                }
            }
            return configuration;
        }else{
            System.out.println("Pas de solution/bug");
            return new ArrayList<>();
        }
    }

    /**
     * Cherche le cube qui a le moins de couleur sur ses faces visibles
     * @return liste d'indice des cubes qui ont le moins de couleurs au total sur les faces 1
     */
    public List<Integer> lowerNbColor(int n, IntVar[][] expressions){
        int total = Integer.MAX_VALUE;
        List<Integer> cubesMin = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 4; j++) {
                if (expressions[j][i].isInstantiated()){
                    set.add(expressions[j][i].getValue());
                }
            }
            if (set.size() < total){
                total = set.size();
                cubesMin.clear();
                cubesMin.add(i);
            }else if(set.size() == total){
                cubesMin.add(i);
            }
        }
        return cubesMin;
    }

    /**
     * Retourne un nouveau model basé sur l'instance contenur dans le résolver
     * @return un nouveau modèle
     */
    public Model makeModel(){
        Model model = new Model();
        // Création des variables
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
                    expr = expr.add(cubeCCs[i][j].mul(tmpc.getColor(j, f))); 
                }
                expressions[f][i] = expr.intVar();
            }
        }

        // On réalise les contraintes
        for (int f = 0; f < 4; f++){
            model.allDifferent(expressions[f]).post();
        }
        return model;
    }

    
}
