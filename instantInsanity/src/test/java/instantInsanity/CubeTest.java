package instantInsanity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Cube.
 */
public class CubeTest 
{
    /**
     * Test of getColor
     */
    @Test
    public void getColorTest(){
        //Given
        Instance monInstance = new Instance(1);
        Cube monCube = monInstance.cubes.get(0);
        //When
        int colorL = monCube.getColor(0,0);
        int colorF = monCube.getColor(0,1);
        int colorR = monCube.getColor(0,2);
        int colorB = monCube.getColor(0,3);

        //Then
        assertEquals(colorL, colorF);
        assertEquals(colorF, colorR);
        assertEquals(colorR, colorB);
    }
}