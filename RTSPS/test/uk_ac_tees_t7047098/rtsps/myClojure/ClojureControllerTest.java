package uk_ac_tees_t7047098.rtsps.myClojure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClojureControllerTest {

    private final ClojureController clojureController = new ClojureController();

    @Test
    void runAlgorithmsGraph() {
        String goal = "c";
        String graph = ":a [{ :b 20 :e 10 :d 4 :g 9 :j 15} ] :b [{ :a 20 :c 11 :d 9 :e 21} ] :c [{ :b 11 :h 13 :i 14 :d 3} ] :d [{ :b 9 :a 4 :c 3 :h 15 :j 10} ] :e [{ :a 10 :b 21 :f 16 :g 17} ] :f [{ :e 16 :g 24} ] :g [{ :e 17 :f 24 :k 5 :j 7 :a 9} ] :h [{ :c 13 :i 2 :d 15 :j 4 :k 23} ] :i [{ :h 2 :c 14} ] :j [{ :g 7 :k 10 :h 4 :d 10 :a 15} ] :k [{ :g 5 :j 10 :h 23}] ".toLowerCase();
        String start = "a";
        String heuristic = ":A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23 ".toLowerCase();
        String result1 = "The algorithm used was: A*. The Solution is: [[:a :d :c] 7]";
        String result2 = "The algorithm used was: Dijkstra's. The Solution is: [[:a :d :c] 7]";

        assertEquals(result1, clojureController.runAlgorithms(graph,start,goal,heuristic));
    }

    @Test
    void runAlgorithmsTree() {
        String goal = "k";
        String graph = ":A [:B :E] :B [:C :D] :E [:F :G] :C [:H :I] :G [:J :K]".toLowerCase();
        String start = "a";
        String heuristic = null;
        String result1 = "The algorithm used was: DFS. The Solution is: [:a :b :c :h :i :d :e :f :g :j :k]";
        String result2 = "The algorithm used was: BFS. The Solution is: [:A :B :E :C :D :F :G :H :I :J :K]";

        assertEquals(result1, clojureController.runAlgorithms(graph,start,goal,heuristic));
    }
}