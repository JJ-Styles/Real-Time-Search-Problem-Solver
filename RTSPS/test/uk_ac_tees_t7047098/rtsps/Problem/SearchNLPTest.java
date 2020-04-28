package uk_ac_tees_t7047098.rtsps.Problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchNLPTest {

    private final SearchNLP searchNLP = new SearchNLP();
    private List<String> tokens = new ArrayList<>();
    private List<String> lemmas = new ArrayList<>();
    private SearchProperties searchProperties = new SearchProperties();

    @BeforeEach
    void setUp() {
        tokens = Arrays.asList("tom", "wishes", "to", "start", "at", "a", "and", "end", "at", "c", "within", "the", "graph", ":a", "[{", ":b", "20", ":e", "10", ":d", "4", ":g", "9", ":j", "15}", "]", ":b", "[{", ":a", "20", ":c", "11", ":d", "9", ":e", "21}", "]", ":c", "[{", ":b", "11", ":h", "13", ":i", "14", ":d", "3}", "]", ":d", "[{", ":b", "9", ":a", "4", ":c", "3", ":h", "15", ":j", "10}", "]", ":e", "[{", ":a", "10", ":b", "21", ":f", "16", ":g", "17}", "]", ":f", "[{", ":e", "16", ":g", "24}", "]", ":g", "[{", ":e", "17", ":f", "24", ":k", "5", ":j", "7", ":a", "9}", "]", ":h", "[{", ":c", "13", ":i", "2", ":d", "15", ":j","4", ":k", "23}", "]", ":i", "[{", ":h", "2", ":c", "14}", "]", ":j", "[{", ":g", "7", ":k", "10", ":h", "4", ":d", "10", ":a", "15}", "]", ":k", "[{", ":g", "5", ":j", "10", ":h", "23}]", ".", "this", "graph", "uses", "the", "heuristic", ":a", "7", ":b", "11", ":c", "0", ":d", "3", ":e", "17", ":f", "33", ":g", "20", ":h", "13", ":i", "14", ":j", "13", ":k", "23");
        lemmas = Arrays.asList("tom", "wish", "to", "start", "at", "a", "and", "end", "at", "O", "within", "the", "graph", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "this", "graph", "use", "the", "heuristic", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O");
        searchProperties.setGraph(":a [{ :b 20 :e 10 :d 4 :g 9 :j 15} ] :b [{ :a 20 :c 11 :d 9 :e 21} ] :c [{ :b 11 :h 13 :i 14 :d 3} ] :d [{ :b 9 :a 4 :c 3 :h 15 :j 10} ] :e [{ :a 10 :b 21 :f 16 :g 17} ] :f [{ :e 16 :g 24} ] :g [{ :e 17 :f 24 :k 5 :j 7 :a 9} ] :h [{ :c 13 :i 2 :d 15 :j 4 :k 23} ] :i [{ :h 2 :c 14} ] :j [{ :g 7 :k 10 :h 4 :d 10 :a 15} ] :k [{ :g 5 :j 10 :h 23}] ".toLowerCase());
        searchProperties.setEnd("c");
        searchProperties.setStart("a");
        searchProperties.setHeuristic(":A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23 ".toLowerCase());
        searchNLP.search(lemmas, tokens);
    }

    @Test
    void getSearchPropertyGraph() {
        assertEquals(searchProperties.getGraph(), searchNLP.getSearchProperties().getGraph());
    }

    @Test
    void getSearchPropertyStart() {
        assertEquals(searchProperties.getStart(), searchNLP.getSearchProperties().getStart());
    }

    @Test
    void getSearchPropertyEnd() {
        assertEquals(searchProperties.getEnd(), searchNLP.getSearchProperties().getEnd());
    }

    @Test
    void getSearchPropertyHeuristics() {
        assertEquals(searchProperties.getHeuristic(), searchNLP.getSearchProperties().getHeuristic());
    }
}