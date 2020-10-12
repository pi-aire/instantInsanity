package instantInsanity;

import static org.junit.Assert.*;

import org.junit.Test;

import instantInsanity.*;

/**
 * Unit test for Cube.
 */
public class CubeTest 
{
    /**
     * 
     */
    @Test
    public void getColorTest()
    {
        long start = System.currentTimeMillis();
        //Given
        Instance moninst = new Instance(1);
        Cube monCube = moninst.cubes.get(0);
        System.out.println("Nombre de cube/couleur " + moninst.n);
        //When
        int colorL = monCube.getColor(0,0);
        int colorF = monCube.getColor(0,1);
        int colorR = monCube.getColor(0,2);
        int colorB = monCube.getColor(0,3);

        //Then
        assertEquals(colorL, colorF);
        assertEquals(colorF, colorR);
        assertEquals(colorR, colorB);
        long time = System.currentTimeMillis() - start;

    }
}
