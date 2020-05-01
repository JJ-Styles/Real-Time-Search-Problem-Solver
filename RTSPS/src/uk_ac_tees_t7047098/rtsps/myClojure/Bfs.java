package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.bfs;
import uk_ac_tees_t7047098.rtsps.app.Debug;

/**
 * Class handles the BFS algorithm.
 * Extends the super class Search algorithm.
 */
public class Bfs extends SearchAlgorithm {

    /**
     * @param goal property required for the algorithm to run, passes it to super.
     * @param graph property required for the algorithm to run, passes it to super.
     * @param start property required for the algorithm to run, passes it to super.
     */
    Bfs(String goal, String graph, String start) {
        super(graph, start, goal);
    }

    /**
     * Runs the Clojure code for BFS with the properties required.
     * Calls the super to check if the result is a valid result.
     * Adds the exception to the Debug class if one occurs.
     */
    @Override
    public void run() {
        try {
            checkResult(bfs.bfsMethod(getGraph(), getStart(), getGoal()));
        } catch (Exception e) {
            Debug.addException(e);
        }
    }

    /**
     * @return The name of the algorithm that will be returned to the User.
     */
    @Override
    public String toString(){
        return "BFS";
    }
}
