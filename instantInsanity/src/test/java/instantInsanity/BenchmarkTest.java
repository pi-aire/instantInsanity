package instantInsanity;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import org.json.simple.JSONArray;
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
                System.out.println(((JSONArray) (array.get(0))).get(0));
                List<List<int[]>> instances = new ArrayList<>(); 
                for (Object instance : array) {
                    List<int[]> ninstance = new ArrayList<>(); 
                    for (Object cube : (JSONArray) instance) {
                        int[] values = new int[6];
                        for (int i = 0; i < ((JSONArray) cube).size(); i++) {
                            Long tmp = ((Long) ((JSONArray) cube).get(i));
                            values[i] = tmp.intValue();
                            // System.out.println(((JSONArray) cube).get(i).getClass());

                        }
                        ninstance.add(values);
                    }
                    instances.add(ninstance);
                }
                // TON CODE le mieux appèle une fonction avac en param la liste
                // la variable est instances
                // for (List<int[]> instance : instances) {
                //     System.out.println((new Instance(instance)).toJSON());
                // }
                executeBenchmark(instances);
                
            } catch (Exception e) {
                e.printStackTrace();
                // System.out.println("Impossible de lire le JSON");
            }
        }catch (Exception e){
            System.out.println("Impossible de lire>ouvrire le fichier benchmark.json");
        }
    }

    public void executeBenchmark(List<List<int[]>> instances) {
        int i = 0;
        HashMap<Integer, Long> resultBenchmark = new HashMap<Integer, Long>();
        for (List<int[]> instance : instances) {
            System.out.println(instance.size());
            //Given
            Instance inst = new Instance(instance);

            //Starting the stopwatch 
            long start = System.currentTimeMillis();

            //When
            New_Resolver resolve = new New_Resolver(inst);
            List<Integer> config = resolve.start(true);
            
            //Stop the stopwatch
            long time = System.currentTimeMillis() - start;
            
            //Verification
            if (!config.isEmpty() && App.verifyResult(inst, config)){
                System.out.println("La configuration est correcte");
            }
            

            //Then
            resultBenchmark.put(i, time);

            i++;
            System.out.println(resultBenchmark.toString());
        }
    }
}
