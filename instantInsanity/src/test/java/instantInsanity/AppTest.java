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
    {
        long startTest = System.currentTimeMillis();
        long timeTotal = 0;
        int success = 0;
        int fail = 0;
        //Le nombre d'instance à chaque fois 
        for (int j = 1 ; j < 11 ; j++){
            //Réinitialisation des variables
            timeTotal = 0;
            success = 0;
            fail = 0; 

            for(int i = 0 ; i < 10 ; i++) {
                //Début du chrono 
                long start = System.currentTimeMillis();

                //Création du problème
                Instance inst = new Instance(j);
                Resolver_old resolve = new Resolver_old(inst);
                List<Integer> config = resolve.start();

                //Fin du chrono
                long time = System.currentTimeMillis() - start;
                timeTotal += time;

                //Traitement du résultat
                if (config.isEmpty()) {
                    fail++;
                } else {
                    success++;
                }
            }
            long moyTime = timeTotal / 10;
            if (j == 1) {
                System.out.println("Pour " + j + " cube et une couleur, le temps moyen est de " + moyTime + " ms. Il y a eu " + success + " succès et " + fail + " échecs.");
            } else {
                System.out.println("Pour " + j + " cubes et autant de couleurs, le temps moyen est de " + moyTime + " ms. Il y a eu " + success + " succès et " + fail + " échecs.");
            }
        }
        long timeTest = System.currentTimeMillis() - startTest;
        System.out.println("La duree total du benchmark est de " + timeTest + " ms.");
    }
}