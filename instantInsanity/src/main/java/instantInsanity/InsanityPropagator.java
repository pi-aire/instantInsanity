package instantInsanity;

import java.util.HashSet;
import java.util.Set;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.ESat;

/**
 * InsanityConstraint
 */
public class InsanityPropagator extends Propagator<IntVar> {

    private Instance instance;
    private int face;
    private IntVar[] cubes;

    public InsanityPropagator(IntVar[] c, Instance inst, int face) {
        super(c, PropagatorPriority.VERY_SLOW, false);
        this.instance = inst;
        this.face = face;
        this.cubes = c;
    }

    // incremental donc pas à implémenter
    @Override
    public void propagate(int evtmask) throws ContradictionException {
    }
    
    @Override
    public ESat isEntailed() {
        Set<Integer> valuesFace = new HashSet<>();
        for (int i = 0; i < this.instance.n; ++i) {
            System.out.println(this.cubes[i].getUB()+"_"+this.cubes[i].getValue());
            System.out.println("cube_"+i+"_face_"+this.face+"_value_"+cubes[i].getValue()+"_c:"+this.instance.cubes.get(i).getColor(cubes[i].getValue(), this.face));
            if (!valuesFace.add(this.instance.cubes.get(i).getColor(cubes[i].getValue(), this.face))){
                // System.out.println("ne marche pas");
                return ESat.FALSE;
            };
        }
        System.out.println("marche");
        return ESat.TRUE;
    }

    
    
}
