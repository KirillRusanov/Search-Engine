package SearchEngine;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearcherSet {
    private SearcherStrategy strategy;

    public SearcherSet(SearcherStrategy strategy) {
        this.strategy = strategy;
    }

    public String search(Dataset dataset, String[] data) {
        var indexes = this.strategy.searchResult(dataset, data);
        StringBuilder output = new StringBuilder();
        if (indexes == null) {
            output.append("No matching people found.");
        } else {
            for (int i : indexes) {
                output.append(dataset.getPeopleListString().get(i)).append("\n");
            }
        }
        return output.toString();
    }
}

interface SearcherStrategy {

    Set<Integer> searchResult(Dataset dataset, String[] data);

}

