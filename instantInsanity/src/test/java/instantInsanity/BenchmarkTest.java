package instantInsanity;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
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
            JSONParser jsonP = new JSONParser();
            JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("../../../../benchmark.json"));
            String name = (String) jsonO.get(0);
            System.out.println(name);
        } catch(Exception e) {
            System.out.println("ouspi");
        }
    }
}
