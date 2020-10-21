package instantInsanity;
import java.util.ArrayList;
import java.util.List;

import org.chocosolver.solver.ParallelPortfolio;

public class App 
{
    public static void main( String[] args )
    {
        List<int[]> cubes = new ArrayList<>();
        
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,1,2,3,0,0};
        cubes.add(c1);
        int[] c2 = {0,1,3,2,0,1};
        cubes.add(c2);
        int[] c3 = {3,3,0,1,2,2};
        cubes.add(c3);
        int[] c4 = {2,1,0,2,3,1};
        cubes.add(c4);
        Instance inst = new Instance(4);
        System.out.println(inst);
        // Resolver resolve = new Resolver(inst);
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();
        if (!config.isEmpty()){
            for (Integer integer : config) {
                System.out.print(integer+", ");
            }
            System.out.println();
            for (int i = 0; i < inst.n; i++) {
                System.out.print("Cube "+(i+1)+" : "+inst.cubes.get(i).toString(config.get(i))+", ");
                
            }
            System.out.println();
            // Is the solution right ?
            if (!verifyResult(inst, config)){
                System.out.println("La solution est incorrect");
            }else{
                
                System.out.println("La solution est correct");
            }
        }else{
            System.out.println("Pas de solution");
        }
        // int[] configs = resolve.start();
        // for (int i = 0; i < inst.n; ++i){
        //     inst.cubes.get(i).rotation(configs[i]);
        //     System.out.println(inst.cubes.get(i));
        // }
        // testMultiThread();
    }

    public static boolean verifyResult(Instance inst, List<Integer> config){
        System.out.println(config +" "+ inst.n);
        for (int f = 0; f < 4; f++) {
            for (int i = 0; i < inst.n; i++) {
                for (int j = 0; j < inst.n; j++) {
                    if (i != j && inst.cubes.get(i).getColor(config.get(i), f) == inst.cubes.get(j).getColor(config.get(j), f)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void testMultiThread(){
        Instance inst = new Instance(10);
        System.out.println(inst);
        // Resolver resolve = new Resolver(inst);
        New_Resolver resolve = new New_Resolver(inst);
        ParallelPortfolio portfolio = new ParallelPortfolio(false);
        int nbModels = 12;
        for(int s=0;s<nbModels;s++){
            portfolio.addModel(resolve.makeModel());
        }
        portfolio.solve();

    }
}
