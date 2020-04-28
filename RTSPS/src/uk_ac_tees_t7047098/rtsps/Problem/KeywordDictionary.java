package uk_ac_tees_t7047098.rtsps.Problem;

import java.util.Arrays;
import java.util.List;

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
            "Heuristic");


    static List<String> getKeywords() {
        return keywords;
    }

    static boolean anyStartWord(String word) {
        List<String> startWords = Arrays.asList( "Start", "Begin");
        for (String startWord : startWords) {
            if (word.equals(startWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean anyGraphWord(String word) {
        List<String> graphWords = Arrays.asList( "Graph", "Set", "Tree");
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean anyEndWord(String word) {
        List<String> endWords = Arrays.asList( "End", "Destination", "Goal", "Arrive");
        for (String endWord : endWords) {
            if (word.equals(endWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean anyHeuristicWord(String word) {
        List<String> graphWords = Arrays.asList( "Heuristic");
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static String getGraphHeuristic(String word, List<String> tokens) {
        StringBuilder result = new StringBuilder();
        int index = tokens.indexOf(word);

        for (int i = index + 1; i < tokens.size(); i++) {
            if (tokens.get(i).equals(".")) {
                break;
            } else {
             result.append(tokens.get(i)).append(" ");
            }
        }
        return result.toString();
    }

    static String getNode(String word, List<String> tokens) {
        return tokens.get(tokens.indexOf(word) + 2);
    }
}
