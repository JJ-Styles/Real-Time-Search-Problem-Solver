package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.dijkstra;
import uk_ac_tees_t7047098.rtsps.app.Debug;

/**
 * Class handles the Dijkstra's algorithm.
 * Extends the super class Search algorithm.
 */
public class Dijkstra extends SearchAlgorithm {

    /**
     * @param goal property required for the algorithm to run, passes it to super.
     * @param graph property required for the algorithm to run, passes it to super.
     * @param start property required for the algorithm to run, passes it to super.
     */
    Dijkstra(String goal, String graph, String start) {
        super(graph, start, goal);
    }

    /**
     * Runs the Clojure code for Dijkstra's with the properties required.
     * Calls the super to check if the result is a valid result.
     * Adds the exception to the Debug class if one occurs.
     */
    @Override
    public void run() {
        try {
            checkResult(dijkstra.dijkstraMethod(getStart(), getGoal(), getGraph()));
        } catch (Exception e) {
            Debug.addException(e);
        }
    }

    /**
     * @return The name of the algorithm that will be returned to the User.
     */
    @Override
    public String toString(){
        return "Dijkstra's";
    }
}
