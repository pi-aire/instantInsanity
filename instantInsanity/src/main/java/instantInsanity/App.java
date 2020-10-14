package instantInsanity;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<int[]> cubes = new ArrayList<>();
        
        // 0 rouge, 1 jaune, 2 vert, 3 blue
        // int[] c1 = {0,1,2,3,0,0};
        // cubes.add(c1);
        // int[] c2 = {0,1,3,2,0,1};
        // cubes.add(c2);
        // int[] c3 = {3,3,0,1,2,2};
        // cubes.add(c3);
        // int[] c4 = {2,1,0,2,3,1};
        // cubes.add(c4);
        int[] c1 = {0,0,0,1,0,0};
        cubes.add(c1);
        int[] c2 = {1,1,0,1,1,1};
        cubes.add(c2);
        int[] c3 = {2,2,2,2,2,2};
        cubes.add(c3);
        int[] c4 = {3,3,3,3,3,3};
        cubes.add(c4);
        Instance inst = new Instance(cubes);
        System.out.println(inst);
        // Resolver resolve = new Resolver(inst);
        Resolver_old resolve = new Resolver_old(inst);
        resolve.start();
        // int[] configs = resolve.start();
        // for (int i = 0; i < inst.n; ++i){
        //     inst.cubes.get(i).rotation(configs[i]);
        //     System.out.println(inst.cubes.get(i));
        // }
    }
}
