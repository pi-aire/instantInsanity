package instantInsanity;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class GeneratorInstances {
    public static void main(String[] args) {
        
        List<Instance> instances = new ArrayList<Instance>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 6; j++) {
                instances.add(new Instance(i));
            }    
        }
        for (int i = 25; i < 100; i+=25) {
            instances.add(new Instance(i));
        }

    
    }
}
