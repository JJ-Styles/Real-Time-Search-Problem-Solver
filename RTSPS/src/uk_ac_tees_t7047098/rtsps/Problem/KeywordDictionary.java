package uk_ac_tees_t7047098.rtsps.Problem;

import java.util.Arrays;
import java.util.List;

public class KeywordDictionary {

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

    static boolean AnyStartWord(String word) {
        List<String> startWords = Arrays.asList( "Start", "Begin");
        for (String startWord : startWords) {
            if (word.equals(startWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean AnyGraphWord(String word) {
        List<String> graphWords = Arrays.asList( "Graph", "Set", "Tree");
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean AnyEndWord(String word) {
        List<String> endWords = Arrays.asList( "End", "Destination", "Goal", "Arrive");
        for (String endWord : endWords) {
            if (word.equals(endWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static boolean AnyHeuristicWord(String word) {
        List<String> graphWords = Arrays.asList( "Heuristic");
        for (String graphWord : graphWords) {
            if (word.equals(graphWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static String getGraphHeuristic(String word, List<String> tokens) {
        String result = "";
        int index = tokens.indexOf(word);

        for (int i = index + 1; i < tokens.size(); i++) {
            if (tokens.get(i).equals(".")) {
                break;
            } else {
             result += tokens.get(i) + " ";
            }
        }
        return result;
    }

    static String getNode(String word, List<String> tokens) {
        return tokens.get(tokens.indexOf(word) + 2);
    }
}
