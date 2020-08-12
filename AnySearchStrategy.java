package SearchEngine;

import java.util.HashSet;
import java.util.Set;

class AnySearchStrategy implements SearcherStrategy {

    @Override
    public Set<Integer> searchResult(Dataset dataset, String[] data) {
        Set<Integer> indexes = new HashSet<>();
        for(String word : data){
            if(dataset.getInvertedIndex().containsKey(word.toUpperCase())){
                indexes.addAll(dataset.getInvertedIndex().get(word.toUpperCase()));
            }
        }
        return indexes;
    }
}
