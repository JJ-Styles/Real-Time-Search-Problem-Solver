package uk_ac_tees_t7047098.rtsps.myClojure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AStarTest {

    private AStar aStar;

    @BeforeEach
    void setUp() {
        aStar = new AStar("c",
                ":a [{ :b 20 :e 10 :d 4 :g 9 :j 15} ] :b [{ :a 20 :c 11 :d 9 :e 21} ] :c [{ :b 11 :h 13 :i 14 :d 3} ] :d [{ :b 9 :a 4 :c 3 :h 15 :j 10} ] :e [{ :a 10 :b 21 :f 16 :g 17} ] :f [{ :e 16 :g 24} ] :g [{ :e 17 :f 24 :k 5 :j 7 :a 9} ] :h [{ :c 13 :i 2 :d 15 :j 4 :k 23} ] :i [{ :h 2 :c 14} ] :j [{ :g 7 :k 10 :h 4 :d 10 :a 15} ] :k [{ :g 5 :j 10 :h 23}] ".toLowerCase(),
                "a",
                ":A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23 ".toLowerCase());
        aStar.run();
    }

    @Test
    void getResult() {
        String result = "[[:a :d :c] 7]";
        assertEquals(result, aStar.getResult());
    }

    @Test
    void testToString() {
        String toString = "A*";
        assertEquals(toString, aStar.toString());
    }
}