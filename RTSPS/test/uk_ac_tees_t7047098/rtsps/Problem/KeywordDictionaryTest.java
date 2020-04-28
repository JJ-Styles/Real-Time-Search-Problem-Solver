package uk_ac_tees_t7047098.rtsps.Problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeywordDictionaryTest {

    List<String> keywords = new ArrayList<>();
    List<String> tokens = new ArrayList<>();

    @BeforeEach
    void setUp() {
     keywords = Arrays.asList(
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

     NaturalLanguageProcessing nlp = new NaturalLanguageProcessing("Tom wishes to Start at A and End at C within the graph :A [{:B 20 :E 10 :D 4 :G 9 :J 15}] :B [{:A 20 :C 11 :D 9 :E 21}] :C [{:B 11 :H 13 :I 14 :D 3}] :D [{:B 9 :A 4 :C 3 :H 15 :J 10}] :E [{:A 10 :B 21 :F 16 :G 17}] :F [{:E 16 :G 24}] :G [{:E 17 :F 24 :K 5 :J 7 :A 9}] :H [{:C 13 :I 2 :D 15 :J 4 :K 23}] :I [{:H 2 :C 14}] :J [{:G 7 :K 10 :H 4 :D 10 :A 15}] :K [{:G 5 :J 10 :H 23}]. This graph uses the heuristic :A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23");
     tokens = nlp.getTokens();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getKeywords() {
        assertEquals(keywords, KeywordDictionary.getKeywords());
    }

    @Test
    void correctStartWord() {
        assertTrue(KeywordDictionary.anyStartWord("start"));
    }

    @Test
    void incorrectStartWord() {
        assertFalse(KeywordDictionary.anyStartWord("end"));
    }

    @Test
    void correctGraphWord() {
        assertTrue(KeywordDictionary.anyGraphWord("graph"));
    }

    @Test
    void incorrectGraphWord() {
        assertFalse(KeywordDictionary.anyGraphWord("blah"));
    }

    @Test
    void correctEndWord() {
        assertTrue(KeywordDictionary.anyEndWord("end"));
    }

    @Test
    void incorrectEndWord() {
        assertFalse(KeywordDictionary.anyEndWord("graph"));
    }

    @Test
    void correctHeuristicWord() {
        assertTrue(KeywordDictionary.anyHeuristicWord("heuristic"));
    }

    @Test
    void incorrectHeuristicWord() {
        assertFalse(KeywordDictionary.anyHeuristicWord("end"));
    }

    @Test
    void getGraphHeuristic() {
        String expectedGraph = ":A [{ :B 20 :E 10 :D 4 :G 9 :J 15} ] :B [{ :A 20 :C 11 :D 9 :E 21} ] :C [{ :B 11 :H 13 : I 14 :D 3} ] :D [{ :B 9 :A 4 :C 3 :H 15 :J 10} ] :E [{ :A 10 :B 21 :F 16 :G 17} ] :F [{ :E 16 :G 24} ] :G [{ :E 17 :F 24 :K 5 :J 7 :A 9} ] :H [{ :C 13 : I 2 :D 15 :J 4 :K 23} ] : I [{ :H 2 :C 14} ] :J [{ :G 7 :K 10 :H 4 :D 10 :A 15} ] :K [{ :G 5 :J 10 :H 23}] ";
        assertEquals(expectedGraph, KeywordDictionary.getGraphHeuristic("graph", tokens));
    }

    @Test
    void getNode() {
        String expectedNode = "A";
        assertEquals(expectedNode, KeywordDictionary.getNode("Start", tokens));
    }
}