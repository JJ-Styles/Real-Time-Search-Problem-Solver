package uk_ac_tees_t7047098.rtsps.Problem;

import java.util.Arrays;
import java.util.List;


/**
 * Static Class used to define the dictionary terms for the NLP.
 * Has the methods to check for graph based terms.
 * Finds nodes and graphical data for NLP.
 */
class KeywordDictionary {

    private static final List<String> keywords = Arrays.asList(
            "Graph",
            "Node",
            "Start",
            "End",
            "Set",
            "Destination",
            "Goal",
            "Tree",
            "Vertex",
            "Edge",
            "Traverse",
            "Begin",
            "Arrive",
            "Heuristic"); //Allows future words to be added


    /**
     * @return The keywords of the dictionary
     */
    static List<String> getKeywords() {
        return keywords;
    }

    /**
     * @param word found from the NLP
     * @return boolean if the word is word relating to start
     */
    static boolean anyStartWord(String word) {
        List<String> startWords = Arrays.asList( "Start", "Begin"); //Allows future words to be added
        for (String startWord : startWords) {
            if (word.equals(startWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param word found from the NLP
     * @return boolean if the word is word relating to graph
     */
    static boolean anyGraphWord(String word) {
        List<String> graphWords = Arrays.asList( "Graph", "Set", "Tree"); //Allows future words to be added
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param word found from the NLP
     * @return boolean if the word is word relating to end
     */
    static boolean anyEndWord(String word) {
        List<String> endWords = Arrays.asList( "End", "Destination", "Goal", "Arrive"); //Allows future words to be added
        for (String endWord : endWords) {
            if (word.equals(endWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param word found from the NLP
     * @return boolean if the word is word relating to heuristic
     */
    static boolean anyHeuristicWord(String word) {
        List<String> graphWords = Arrays.asList( "Heuristic"); //Allows future words to be added
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param word found from the NLP
     * @param tokens generated in the NLP from the input
     * @return String of tokens from the token after word till a full-stop
     */
    static String getGraphHeuristic(String word, List<String> tokens) {
        StringBuilder result = new StringBuilder();
        int index = tokens.indexOf(word);

        /*
        Takes the value 1 after the graph/heuristic as the word graph/heuristic is not needed.
        Future Additions to be made here to improve whether the input is accurate and to allow parsing into the correct format.
         */
        for (int i = index + 1; i < tokens.size(); i++) {
            if (tokens.get(i).equals(".")) {
                break;
            } else {
             result.append(tokens.get(i)).append(" ");
            }
        }
        return result.toString();
    }

    /**
     * @param word found from the NLP
     * @param tokens generated in the NLP from the input
     * @return String containing the token that is the second token after word
     */
    static String getNode(String word, List<String> tokens) {
        /*
        Takes the value 2 after the graph/heuristic as the word graph/heuristic is not needed and the next word is most likely a word like 'is'.
        Future Additions to be made here to improve whether the input is accurate and to allow parsing into the correct format.
         */
        return tokens.get(tokens.indexOf(word) + 2);
    }
}
