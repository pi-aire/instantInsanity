package instantInsanity;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /*
    * Test with two cubes.
    */
    @Test
    public void TwoCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,0,1,1,1};
        int[] c2 = {1,1,1,0,0,0};
        cubes.add(c1);
        cubes.add(c2);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        assertFalse(config.isEmpty());
    }

    /*
    * Test with three cubes. 
    */
    @Test
    public void ThreeCubesTest() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with four cubes.
    */
    @Test
    public void FourCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with five cubes. A rotation is necessary
    */
    @Test
    public void FiveCubesTest() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        int[] c5 = {1,4,0,4,4,4};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with six cubes. A rotation is necessary
    */
    @Test
    public void SixCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        int[] c5 = {1,4,0,4,4,4};
        int[] c6 = {4,5,1,5,5,5};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        cubes.add(c6);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with seven cubes. A rotation is necessary
    */
    @Test
    public void SevenCubesTest() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        int[] c5 = {1,4,0,4,4,4};
        int[] c6 = {4,5,1,5,5,5};
        int[] c7 = {6,5,6,5,6,6};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        cubes.add(c6);
        cubes.add(c7);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with eight cubes. A rotation is necessary
    */
    @Test
    public void EightCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        int[] c5 = {1,4,0,4,4,4};
        int[] c6 = {4,5,1,5,5,5};
        int[] c7 = {6,5,6,5,6,6};
        int[] c8 = {7,7,7,7,1,2};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        cubes.add(c6);
        cubes.add(c7);
        cubes.add(c8);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with nine cubes. A rotation is necessary
    */
    @Test
    public void NineCubesTest() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        int[] c1 = {0,0,1,1,2,2};
        int[] c2 = {1,1,2,2,0,0};
        int[] c3 = {2,2,0,0,0,0};
        int[] c4 = {3,3,3,3,3,3};
        int[] c5 = {1,4,0,4,4,4};
        int[] c6 = {4,5,1,5,5,5};
        int[] c7 = {6,5,6,5,6,6};
        int[] c8 = {7,7,7,7,1,2};
        int[] c9 = {1,8,2,8,8,8};
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        cubes.add(c6);
        cubes.add(c7);
        cubes.add(c8);
        cubes.add(c9);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }

    /*
    * Test with ten cubes. A rotation is necessary
    */
    @Test
    public void TenCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue
        // int[] c1 =  {0,9,1,8,2,2};
        // int[] c2 =  {1,2,3,4,5,6};
        // int[] c3 =  {2,7,0,0,0,0};
        // int[] c4 =  {3,6,3,3,3,3};
        // int[] c5 =  {4,5,0,4,4,4};
        // int[] c6 =  {5,4,1,5,5,5};
        // int[] c7 =  {6,3,6,5,6,6};
        // int[] c8 =  {7,2,7,7,1,2};
        // int[] c9 =  {9,1,2,1,8,8};
        // int[] c10 = {9,0,9,9,9,9};
        
        // int[] c1 =  {1,2,3,4,0,0};
        // int[] c2 =  {0,2,0,3,4,5};
        // int[] c3 =  {3,0,4,0,5,6};
        // int[] c4 =  {4,5,6,7,0,0};
        // int[] c5 =  {0,5,0,6,7,9};
        // int[] c6 =  {6,0,7,0,9,8};
        // int[] c7 =  {7,9,8,0,0,0};
        // int[] c8 =  {0,9,0,8,0,1};
        // int[] c9 =  {8,0,0,0,1,2};
        // int[] c10 = {0,1,2,3,0,0};

        int[] c1 =  {1,2,3,4,2,3};
        int[] c2 =  {2,2,1,3,4,5};
        int[] c3 =  {3,3,4,1,5,6};
        int[] c4 =  {4,5,6,7,3,4};
        int[] c5 =  {5,5,5,6,7,9};
        int[] c6 =  {6,4,7,2,9,8};
        int[] c7 =  {7,9,8,0,6,7};
        int[] c8 =  {9,9,9,8,0,1};
        int[] c9 =  {8,0,0,0,1,2};
        int[] c10 = {0,1,2,3,8,0};
        
        cubes.add(c1);
        cubes.add(c2);
        cubes.add(c3);
        cubes.add(c4);
        cubes.add(c5);
        cubes.add(c6);
        cubes.add(c7);
        cubes.add(c8);
        cubes.add(c9);
        cubes.add(c10);
        Instance inst = new Instance(cubes); 

        //When
        Resolver_old resolve = new Resolver_old(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertFalse(config.isEmpty());
    }


    /**
     * This is the test to calculate the time required
     */
    //@Test
    public void mainTest()
    {
        long startTest = System.currentTimeMillis();
        long timeTotal = 0;
        int success = 0;
        int fail = 0;
        //The number of cubes 
        for (int j = 1 ; j < 11 ; j++){
            //Variable reset
            timeTotal = 0;
            success = 0;
            fail = 0; 

            for(int i = 0 ; i < 10 ; i++) {
                //Starting the stopwatch 
                long start = System.currentTimeMillis();

                //Creation of the problem
                Instance inst = new Instance(j);
                Resolver_old resolve = new Resolver_old(inst);
                List<Integer> config = resolve.start();

                //Stop the stopwatch
                long time = System.currentTimeMillis() - start;
                timeTotal += time;

                //Results analysis
                if (config.isEmpty()) {
                    fail++;
                } else if (App.verifyResult(inst, config)){
                    success++;
                } else {
                    fail++;
                }
            }
            long moyTime = timeTotal / 10;
            if (j == 1) {
                System.out.println("For " + j + " cube and one colors, the average time is " + moyTime + " ms. There were " + success + " successes and " + fail + " failures.");
            } else {
                System.out.println("For " + j + " cubes and as many colors, the average time is " + moyTime + " ms. There were " + success + " successes and " + fail + " failures.");
            }
        }
        long timeTest = System.currentTimeMillis() - startTest;
        System.out.println("The benchmark duration is " + timeTest + " ms.");
    }
}