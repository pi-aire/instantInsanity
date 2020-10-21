package instantInsanity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.selectors.variables.VariableSelector;
import org.chocosolver.solver.variables.IntVar;

public class New_Resolver {
    
    Instance instance;

    public New_Resolver(Instance inst){
        this.instance = inst;

    }
    public List<Integer> start(){
        return start(true);
    }
    public List<Integer> start(boolean strategy){
        Model model = new Model();
        // Création des variables
        // chaque variable représente une position d'un cube
        // IntVar[] cubePs = new IntVar[this.instance.n];
        // for (int i = 0; i < this.instance.n; i++) {
        //     cubePs[i] = model.intVar("Cube_T"+(i+1),0,23);
        // }

        // Les variables représentant les combinaisons.
        IntVar[][] cubeCCs = new IntVar[this.instance.n][];
        List<IntVar> listCubeConf = new ArrayList<>();
        HashMap<String,Integer> valueConf = new HashMap<String,Integer>();
        for (int i = 0; i < this.instance.n; i++) {
            cubeCCs[i] = new IntVar[24];
            for (int j = 0; j < 24; j++) {
                cubeCCs[i][j] = model.intVar("Cube_"+(i+1)+"_conf"+(j+1),0,1);
                listCubeConf.add(cubeCCs[i][j]);
                valueConf.put(cubeCCs[i][j].getName(), this.getNbColor(i, j));
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

        // Mise en place de la stratégie 
        if (strategy){
            model.getSolver().setSearch(Search.intVarSearch(
                // variable selector
                (VariableSelector<IntVar>) variables -> listCubeConf.stream()
                    .filter(v -> !v.isInstantiated())
                    .max((v1, v2) -> valueConf.get(v1.getName()) - valueConf.get(v2.getName()))
                    .orElse(null),
                (IntValueSelector) var -> 1
            ));
        }       
        // model.getSolver().setSearch(Search.intVarSearch(
        //     (VariableSelector<IntVar>) variables -> {
        //         List<IntVar> list = new ArrayList<>();
        //         for (IntVar v : listCubeConf) {
        //             if (!v.isInstantiated()){
        //                 list.add(v);
        //             }
        //         }

        //         return ;

        //     },
        //     (IntValueSelector) var -> 1
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
                    if (cubeCCs[i][j].isInstantiated() && solution.getIntVal(cubeCCs[i][j]) == 1){
                        configuration.add(j);
                        break;
                    }
                }
                // if (configuration.size() - 1 != i){
                //     configuration.add(0);
                // }
            }
            return configuration;
        }else{
            System.out.println("Pas de solution");
            return new ArrayList<>();
        }
    }
    /**
     * 
     * @param indexCube
     * @return
     */
    public int getNbColor(IntVar var){
        // compilation de la regex
        Pattern p = Pattern.compile("Cube_([0-9]+)_conf([0-9]+)");
        // création d'un moteur de recherche
        Matcher m = p.matcher(var.getName());

        if( m.matches()) {
            // pour chaque groupe
            // for(int i=0; i <= m.groupCount(); i++) {
            //     // affichage de la sous-chaîne capturée
            //     System.out.println("Groupe " + i + " : " + m.group(i));
            // }
            int idCube = Integer.parseInt(m.group(1)) - 1;
            int idConfig = Integer.parseInt(m.group(2)) - 1;
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 4; j++) {
                set.add(this.instance.cubes.get(idCube).colorC[idConfig][j]);
            }
            return set.size();
        }else{
            return 0;
        }
    }
    /**
     * 
     * @param indexCube
     * @return
     */
    public int getNbColor(int idCube, int idConfig){
        Set<Integer> set = new HashSet<Integer>();
        for (int j = 0; j < 4; j++) {
            set.add(this.instance.cubes.get(idCube).colorC[idConfig][j]);
        }
        return set.size();
    }

    /**
     * On cherche la configuration pour un cube donné qui à le plus de couleur sur ses faces visible
     * @param indexCube indice du cube
     * @return indice de la configuration
     */
    public int selectIntVar(Integer indexCube){
        int i = 0;
        int total = 0;
        int indexConfHigh = 0;
        for (int[] configC : this.instance.cubes.get(indexCube).colorC) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 4; j++) {
                set.add(configC[j]);
            }
            if (total < set.size()){
                total = set.size();
                indexConfHigh = i;
            }
            i++;
        }
        return indexConfHigh;
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
