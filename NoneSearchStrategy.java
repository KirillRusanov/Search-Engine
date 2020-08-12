package SearchEngine;

import java.util.HashSet;
import java.util.Set;

class NoneSearchStrategy implements SearcherStrategy {

    @Override
    public Set<Integer> searchResult(Dataset dataset, String[] data) {

        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < dataset.getPeopleListString().size(); i++) {
            indexes.add(i);
        }
        for (String word : data) {
            if (dataset.getInvertedIndex().containsKey(word.toUpperCase())) {
                indexes.removeAll(dataset.getInvertedIndex().get(word.toUpperCase()));
            }

        }
        return indexes.size() == 0 ? null : indexes;
    }
}