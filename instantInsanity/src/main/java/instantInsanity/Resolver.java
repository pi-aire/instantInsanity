package instantInsanity;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

public class Resolver {
    Instance instance;

    public Resolver(Instance inst){
        this.instance = inst;
    }
    
    public int[] start(){
        Model model = new Model();
        // Création des variables
        // chaque variable représente une position d'un cube
        IntVar[] cubePs = new IntVar[this.instance.n];
        for (int i = 0; i < this.instance.n; i++) {
            cubePs[i] = model.intVar("Cube_T"+(i+1),0,23);
        }

        // Contraintes pour chaque face de la pile
        for (int i = 0; i < 4; i++) {
            model.post(new Constraint("Contrainte_face_"+(i+1), new InsanityPropagator(cubePs, this.instance, i)));
        }
        
        Solver solver = model.getSolver();
        solver.solve();
        if (false){
            //    System.out.println("allez je suis le boss")
            // System.out.println(solution.toString());
            int[] results = new int[this.instance.n];
            // for (int i = 0; i < this.instance.n; i++) {
            //     results[i] = solution.getIntVal(cubePs[i]);
            // }   
            return results;
        }else{
            return null;
        }
    }
}
