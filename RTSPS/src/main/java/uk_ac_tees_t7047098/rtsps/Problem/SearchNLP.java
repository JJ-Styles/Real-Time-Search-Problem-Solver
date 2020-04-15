package uk_ac_tees_t7047098.rtsps.Problem;

import java.util.ArrayList;
import java.util.List;

public class SearchNLP {
    private List<String> found = new ArrayList<>();
    private SearchProperties searchProperties = new SearchProperties();

    public SearchNLP() {
    }

    public void search(List<String> lemmas, List<String> tokens){

        for (String temp : lemmas) {
            for (String keyword : KeywordDictionary.getKeywords()) {
                if (temp.equals(keyword.toLowerCase())) {
                    found.add(temp);
                }
            }
        }

        for (String temp : found) {
            if (KeywordDictionary.AnyGraphWord(temp)) {
                searchProperties.setGraph(KeywordDictionary.getGraphHeuristic(temp, tokens));
            } else if (KeywordDictionary.AnyStartWord(temp)) {
                searchProperties.setStart(KeywordDictionary.getNode(temp, tokens));
            } else if (KeywordDictionary.AnyEndWord(temp)) {
                searchProperties.setEnd(KeywordDictionary.getNode(temp, tokens));
            } else if (KeywordDictionary.AnyHeuristicWord(temp)) {
                searchProperties.setHeuristic(KeywordDictionary.getGraphHeuristic(temp, tokens));
            } else {
                //do something with extras
            }
        }
    }

    public SearchProperties getSearchProperties() {
        return searchProperties;
    }
}
