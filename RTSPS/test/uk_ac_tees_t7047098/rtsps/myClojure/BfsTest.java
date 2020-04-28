package uk_ac_tees_t7047098.rtsps.myClojure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BfsTest {

    private Bfs bfs;

    @BeforeEach
    void setUp() {
        bfs = new Bfs("K",
                ":A [:B :E] :B [:C :D] :E [:F :G] :C [:H :I] :G [:J :K]",
                "A");
        bfs.run();
    }

    @Test
    void getResult() {
        String result = "[:A :B :E :C :D :F :G :H :I :J :K]";
        assertEquals(result, bfs.getResult());
    }

    @Test
    void testToString() {
        String toString = "BFS";
        assertEquals(toString, bfs.toString());
    }
}