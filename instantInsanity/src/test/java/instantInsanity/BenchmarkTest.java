package instantInsanity;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.chocosolver.util.sort.ArraySort;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 * Tests for the benchmark
 */

public class BenchmarkTest {
    @Test
    public void mainBenchmarkTest() {
        try {
            File myObj = new File("benchmark.json");
            Scanner myReader = new Scanner(myObj);
            StringBuilder strb = new StringBuilder();
            while (myReader.hasNextLine()) {
              strb.append(myReader.nextLine());
            }
            myReader.close();
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(strb.toString());
                JSONArray array = (JSONArray)obj;
                List<List<Integer>> instances = new ArrayList<>(); 
                for (Object instance : array) {
                    List<Integer> ninstance = new ArrayList<>(); 
                    for (int value : (int[]) instance) {
                        ninstance.add(value);
                    }
                    instances.add(ninstance);
                }
                // TON CODE le mieux appèle une fonction avac en param la liste
                // la variable est instances
                
            } catch (Exception e) {
                System.out.println("Impossible de lire le JSON");
            }
        }catch (Exception e){
            System.out.println("Impossible de lire>ouvrire le fichier benchmark.json");
        }
    }
}
