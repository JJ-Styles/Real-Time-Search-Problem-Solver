package uk_ac_tees_t7047098.rtsps.myClojure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DfsTest {

    private Dfs dfs;

    @BeforeEach
    void setUp() {
        dfs = new Dfs("K",
                ":A [:B :E] :B [:C :D] :E [:F :G] :C [:H :I] :G [:J :K]",
                "A");
        dfs.run();
    }

    @Test
    void getResult() {
        String result = "[:A :B :C :H :I :D :E :F :G :J :K]";
        assertEquals(result, dfs.getResult());
    }

    @Test
    void testToString() {
        String toString = "DFS";
        assertEquals(toString, dfs.toString());
    }
}