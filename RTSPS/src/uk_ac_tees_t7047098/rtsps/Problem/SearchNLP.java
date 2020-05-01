package uk_ac_tees_t7047098.rtsps.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Class takes the lemmas and tokens from the NLP and searches for the values from the Keyword Dictionary.
 * When a word is found it assigns it to the search properties class.
 */
public class SearchNLP {
    private List<String> found = new ArrayList<>();
    private SearchProperties searchProperties = new SearchProperties();

    /**
     * @param lemmas created by the NLP
     * @param tokens created by the NLP
     */
    public void search(List<String> lemmas, List<String> tokens){

        for (String temp : lemmas) {
            for (String keyword : KeywordDictionary.getKeywords()) {
                if (temp.equals(keyword.toLowerCase())) {
                    found.add(temp);
                }
            }
        }

        if (!found.isEmpty()){
            for (String temp : found) {
                if (KeywordDictionary.anyGraphWord(temp)) {
                    searchProperties.setGraph(KeywordDictionary.getGraphHeuristic(temp, tokens));
                } else if (KeywordDictionary.anyStartWord(temp)) {
                    searchProperties.setStart(KeywordDictionary.getNode(temp, tokens));
                } else if (KeywordDictionary.anyEndWord(temp)) {
                    searchProperties.setEnd(KeywordDictionary.getNode(temp, tokens));
                } else if (KeywordDictionary.anyHeuristicWord(temp)) {
                    searchProperties.setHeuristic(KeywordDictionary.getGraphHeuristic(temp, tokens));
                } else {
                    //do something with extras
                }
            }
        }
    }

    /**
     * @return the search properties that have been created through the NLP and Keyword Dictionary.
     */
    public SearchProperties getSearchProperties() {
        return searchProperties;
    }
}
