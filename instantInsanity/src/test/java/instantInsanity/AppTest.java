package instantInsanity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for different configurations
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
    }

    /*
    * Test with ten cubes. A rotation is necessary
    */
    @Test
    public void TenCubesTests() {
        //Given
        List<int[]> cubes = new ArrayList<>();
        // 0 red, 1 yellow, 2 green, 3 blue

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
        New_Resolver resolve = new New_Resolver(inst);
        List<Integer> config = resolve.start();

        //Then
        System.out.println(inst);
        assertTrue(!config.isEmpty() && App.verifyResult(inst, config));
    }
}