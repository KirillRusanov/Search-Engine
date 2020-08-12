package SearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Dataset {

    private final List<String> peopleListString = new ArrayList<>();
    private final Map<String, Set<Integer>> invertedIndex = new HashMap<>();

    public void enter(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                addPerson(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        }
        createIndex();
    }

    public void addPerson(String lineToParse) {
        peopleListString.add(lineToParse);
    }

    public void createIndex() {
        invertedIndex.clear();
        for (int i = 0; i < getPeopleListString().size(); i++) {
            for (String word : getPeopleListString().get(i).split(",|\\s+")) {
                word = word.toUpperCase();
                if (invertedIndex.containsKey(word)) {
                    invertedIndex.get(word).add(i);
                } else {
                    invertedIndex.put(word, new HashSet<>(Set.of(i)));
                }
            }
        }
    }

    public Map<String, Set<Integer>> getInvertedIndex() {
        return invertedIndex;
    }

    public List<String> getPeopleListString() {
        return peopleListString;
    }
}