package instantInsanity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

public class GeneratorInstances {
    public static void main(String[] args) {
        JSONArray list = new JSONArray();
        List<Instance> instances = new ArrayList<Instance>();
        for (int i = 2; i < 20; i++) {
            for (int j = 0; j < 6; j++) {
                instances.add(new Instance(i+1));
            }    
        }
        for (int i = 25; i < 100; i+=25) {
            instances.add(new Instance(i));
        }
        for (Instance instance : instances) {
            list.add(instance.toJSON());
        }

        System.out.println(instances.size());
        String jsonText = list.toString();

        // Suppression du fichier JSON
        File djson = new File("benchmark.json"); 
        djson.delete();

        // ajout du json dans un fichier
        try {
            FileWriter file = new FileWriter("benchmark.json");
            file.write(jsonText);
            file.close();
        }
        catch (IOException e) {
            System.out.println("Impossible d'exporter le fichier");
            e.printStackTrace();
        }
    }
}
