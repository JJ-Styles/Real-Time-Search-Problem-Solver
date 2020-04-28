package uk_ac_tees_t7047098.rtsps.Problem;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NaturalLanguageProcessingTest {

    private final String input = "Tom wishes to Start at A and End at C within the graph :A [{:B 20 :E 10 :D 4 :G 9 :J 15}] :B [{:A 20 :C 11 :D 9 :E 21}] :C [{:B 11 :H 13 :I 14 :D 3}] :D [{:B 9 :A 4 :C 3 :H 15 :J 10}] :E [{:A 10 :B 21 :F 16 :G 17}] :F [{:E 16 :G 24}] :G [{:E 17 :F 24 :K 5 :J 7 :A 9}] :H [{:C 13 :I 2 :D 15 :J 4 :K 23}] :I [{:H 2 :C 14}] :J [{:G 7 :K 10 :H 4 :D 10 :A 15}] :K [{:G 5 :J 10 :H 23}]. This graph uses the heuristic :A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23";
    private final NaturalLanguageProcessing nlp = new NaturalLanguageProcessing(input.toLowerCase());
    private List<String> sentences = new ArrayList<>();
    private List<String> tokens = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private List<String> lemmas = new ArrayList<>();

    @BeforeEach
    void setUp() {
        sentences = Arrays.asList("tom wishes to start at a and end at c within the graph :a [{:b 20 :e 10 :d 4 :g 9 :j 15}] :b [{:a 20 :c 11 :d 9 :e 21}] :c [{:b 11 :h 13 :i 14 :d 3}] :d [{:b 9 :a 4 :c 3 :h 15 :j 10}] :e [{:a 10 :b 21 :f 16 :g 17}] :f [{:e 16 :g 24}] :g [{:e 17 :f 24 :k 5 :j 7 :a 9}] :h [{:c 13 :i 2 :d 15 :j 4 :k 23}] :i [{:h 2 :c 14}] :j [{:g 7 :k 10 :h 4 :d 10 :a 15}] :k [{:g 5 :j 10 :h 23}].",
                     "this graph uses the heuristic :a 7 :b 11 :c 0 :d 3 :e 17 :f 33 :g 20 :h 13 :i 14 :j 13 :k 23");
        tokens = Arrays.asList("tom", "wishes", "to", "start", "at", "a", "and", "end", "at", "c", "within", "the", "graph", ":a", "[{", ":b", "20", ":e", "10", ":d", "4", ":g", "9", ":j", "15}", "]", ":b", "[{", ":a", "20", ":c", "11", ":d", "9", ":e", "21}", "]", ":c", "[{", ":b", "11", ":h", "13", ":i", "14", ":d", "3}", "]", ":d", "[{", ":b", "9", ":a", "4", ":c", "3", ":h", "15", ":j", "10}", "]", ":e", "[{", ":a", "10", ":b", "21", ":f", "16", ":g", "17}", "]", ":f", "[{", ":e", "16", ":g", "24}", "]", ":g", "[{", ":e", "17", ":f", "24", ":k", "5", ":j", "7", ":a", "9}", "]", ":h", "[{", ":c", "13", ":i", "2", ":d", "15", ":j","4", ":k", "23}", "]", ":i", "[{", ":h", "2", ":c", "14}", "]", ":j", "[{", ":g", "7", ":k", "10", ":h", "4", ":d", "10", ":a", "15}", "]", ":k", "[{", ":g", "5", ":j", "10", ":h", "23}]", ".", "this", "graph", "uses", "the", "heuristic", ":a", "7", ":b", "11", ":c", "0", ":d", "3", ":e", "17", ":f", "33", ":g", "20", ":h", "13", ":i", "14", ":j", "13", ":k", "23");
        tags = Arrays.asList("NN", "VBZ", "TO", "VB", "IN", "DT", "CC", "NN", "IN", "NN", "IN", "DT", "NN", "VBD", "IN", "NNP", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "SYM", ":", "JJ", "RP", "CD", "JJ", "CD", "NN", "CD", "NN", "CD", "SYM", "JJ", "NN", "NN", "CD", "NN", "CD", "NNP", "CD", "VBD", "CD", "SYM", "VBN", "IN", "NN", "CD", "NNP", "CD", "NN", "CD", "NN", "CD", "NN", "CD","NN", "NN", "IN", "NNP", "CD", "NN", "CD", "NNP", "CD", ",", "CD", "SYM", ":", "NN", "NN", "CD", "NN", "CD", "SYM", ":", "JJ", "NN", "CD", "NNP", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "SYM", "JJ", "NN", "IN", "CD", "NN", "CD", "NN", "CD", "NNS","CD", "NN", "JJ", "SYM", "FW", "NNP", "NN", "CD", ",", "CD", "SYM", ":", "NN", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NNP", "CD", "SYM", ":", "NN", "NN", "CD", "NN", "CD", "NN", "CD", ".", "DT", "NN", "VBZ", "DT", "JJ", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NN", "CD", "NNP", "CD", "NN", "CD", "NN", "CD");
        lemmas = Arrays.asList("tom", "wish", "to", "start", "at", "a", "and", "end", "at", "O", "within", "the", "graph", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "this", "graph", "use", "the", "heuristic", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O");
    }

    @Test
    void getSentences() {
        assertEquals(sentences, nlp.getSentences());
    }

    @Test
    void getTokens() {
        assertEquals(tokens, nlp.getTokens());
    }

    @Test
    void getTags() {
        assertEquals(tags, nlp.getTags());
    }

    @Test
    void getLemmas() {
        assertEquals(lemmas, nlp.getLemmas());
    }
}