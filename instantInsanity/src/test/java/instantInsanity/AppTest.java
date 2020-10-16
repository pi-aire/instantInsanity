package instantInsanity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void mainTest()
    //TODO 
    /*
    Faire un test qui prends 10 mesures de temps à chaque fois de 0 à 10 cubes. 
    Tracer le graphique de la moyenne 
    */

    {
        long start = System.currentTimeMillis();
        Instance inst = new Instance(4);
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();
        System.out.println(config);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
